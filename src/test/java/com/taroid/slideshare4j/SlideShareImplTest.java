package com.taroid.slideshare4j;

import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.sameInstance;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

@RunWith(Enclosed.class)
public class SlideShareImplTest {

    public static class constructor {
        @Test(expected = NullPointerException.class)
        public void 第1引数にnullを渡すと例外を投げる() {
            new SlideShareImpl(null, "", mock(SlideshowConverter.class));
        }

        @Test(expected = NullPointerException.class)
        public void 第2引数にnullを渡すと例外を投げる() {
            new SlideShareImpl("", null, mock(SlideshowConverter.class));
        }

        @Test(expected = NullPointerException.class)
        public void 第3引数にnullを渡すと例外を投げる() {
            new SlideShareImpl("", "", null);
        }
    }

    @RunWith(PowerMockRunner.class)
    public static class serachSlideshows {

        @Test(expected = NullPointerException.class)
        public void 第1引数にnullを渡すと例外を投げる() {
            new SlideShareImpl("", "", mock(SlideshowConverter.class)).searchSlideshows(null, new Paging(12, 1));
        }

        @Test(expected = NullPointerException.class)
        public void 第2引数にnullを渡すと例外を投げる() {
            new SlideShareImpl("", "", mock(SlideshowConverter.class)).searchSlideshows(new Query("a"), null);
        }

        @Test
        @PrepareForTest(Query.class)
        public void 引数の検索クエリの各プロパティを参照する() {
            final Query query = PowerMockito.spy(new Query("a"));
            new SlideShareImpl("", "", mock(SlideshowConverter.class)).searchSlideshows(query, new Paging(12, 1));

            verify(query, times(1)).getWords();
            verify(query, times(1)).getLanguage();
            verify(query, times(1)).getSortOrder();
        }

        @Test
        @PrepareForTest(Paging.class)
        public void 引数のページングの各プロパティを参照する() {
            final Paging paging = PowerMockito.spy(new Paging(12, 1));
            new SlideShareImpl("", "", mock(SlideshowConverter.class)).searchSlideshows(new Query("a"), paging);

            verify(paging, times(1)).getItemsPerPage();
            verify(paging, times(1)).getPage();
        }

        @Test
        public void SlideshowConverterを呼び出しその結果をそのまま返す() {
            final SlideshowConverter converter = mock(SlideshowConverter.class);
            final List<Slideshow> expected = new ArrayList<Slideshow>();
            when(converter.convert(Matchers.<InputStream>any())).thenReturn(expected);

            final List<Slideshow> actual = new SlideShareImpl("", "", converter).searchSlideshows(new Query("a"), new Paging(1, 1));

            assertThat(actual, sameInstance(expected));
        }
    }
}
