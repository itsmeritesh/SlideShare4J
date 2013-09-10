package com.taroid.slideshare4j;

public class SlideShareFactory {

    public static SlideShare newInstance(final String apiKey, final String sharedSecret) {
        return new SlideShareImpl(apiKey, sharedSecret, new SlideshowConverterImpl());
    }
}
