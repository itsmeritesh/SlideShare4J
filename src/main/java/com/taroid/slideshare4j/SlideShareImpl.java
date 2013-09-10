package com.taroid.slideshare4j;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/*package*/ final class SlideShareImpl extends AbstractSlideShare {

    private final SlideshowConverter slideshowConverter;

    public SlideShareImpl(final String apiKey, final String sharedSecret, final SlideshowConverter converter) {
        super(apiKey, sharedSecret);
        this.slideshowConverter = converter;
    }

    @Override
    public List<Slideshow> searchSlideshows(final Query query, final Paging paging) {
        final URL url;
        try {
            url = new URLBuilder(URLs.SEARCH)
                    .putParam("api_key", getAPIKey())
                    .putParam("ts", getCurrentTimeSeconds())
                    .putParam("hash", getHash())
                    .putParam("q", query.getWords())
                    .putParam("lang", query.getLanguage())
                    .putParam("sort", query.getSortOrder())
                    .putParam("page", paging.getPage())
                    .putParam("items_per_page", paging.getItemsPerPage())
                    .create();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        final InputStream inputStream;
        try {
            inputStream = url.openStream();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return slideshowConverter.convert(inputStream);
    }

    private static class URLs {
        private static final String BASE = "https://www.slideshare.net/api/2/";
        public static final String SEARCH = BASE + "search_slideshows";
    }
}
