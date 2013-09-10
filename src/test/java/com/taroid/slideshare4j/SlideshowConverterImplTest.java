package com.taroid.slideshare4j;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

public class SlideshowConverterImplTest {

    @Test(expected = NullPointerException.class)
    public void 引数にnull渡すと例外を投げる() {
        new SlideshowConverterImpl().convert(null);
    }

    @Test
    public void 引数にスライド情報を渡すとSlideshowのリストを返す() throws ParseException {
        // setup
        final String xml = "<Slideshows>" +
                " <Slideshow>" +
                "  <ID>111111</ID>" +
                "  <Title>aaa</Title>" +
                "  <Username>bbb</Username>" +
                "  <Description>ccc</Description>" +
                "  <URL>ddd</URL>" +
                "  <ThumbnailURL>eee</ThumbnailURL>" +
                "  <Created>Thu Jan 01 00:00:00 +0900 2013</Created>" +
                "  <Updated>Thu Jan 01 01:00:00 +0900 2013</Updated>" +
                "  <Language>ff</Language>" +
                "  <Embed>ggg</Embed>" +
                " </Slideshow>" +
                "</Slideshows>";

        final SlideshowConverterImpl converter = new SlideshowConverterImpl();

        // exercise
        final List<Slideshow> slideshows = converter.convert(new ByteArrayInputStream(xml.getBytes()));

        // verify
        assertThat(slideshows, notNullValue());
        assertThat(slideshows.size(), is(1));

        final Slideshow slideshow = slideshows.get(0);
        assertThat(slideshow.getID(), is(111111L));
        assertThat(slideshow.getTitle(), is("aaa"));
        assertThat(slideshow.getUsername(), is("bbb"));
        assertThat(slideshow.getDescription(), is("ccc"));
        assertThat(slideshow.getURL(), is("ddd"));
        assertThat(slideshow.getThumbnailURL(), is("eee"));
        assertThat(slideshow.getLanguage(), is("ff"));
        assertThat(slideshow.getEmbed(), is("ggg"));

        final DateFormat dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy");
        assertThat(slideshow.getCreated(), is(dateFormat.parse("Thu Jan 01 00:00:00 +0900 2013")));
        assertThat(slideshow.getUpdated(), is(dateFormat.parse("Thu Jan 01 01:00:00 +0900 2013")));
    }
}
