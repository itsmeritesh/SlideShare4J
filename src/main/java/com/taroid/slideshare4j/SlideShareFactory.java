package com.taroid.slideshare4j;

public class SlideShareFactory {

    public static SlideShare newInstance(final String apiKey, final String sharedSecret) {
        if(apiKey == null) {
            throw new NullPointerException("apiKey must not be null.");
        }
        if(sharedSecret == null) {
            throw new NullPointerException("sharedSecret must not be null.");
        }

        return new SlideShareImpl(apiKey, sharedSecret, new SlideshowConverterImpl());
    }
}
