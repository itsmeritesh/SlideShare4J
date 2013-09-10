package com.taroid.slideshare4j;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/*package*/ final class URLBuilder {

    private final String baseURL;

    private final Map<String, String> params = new HashMap<String, String>();

    public URLBuilder(final String baseURL) {
        if (baseURL == null) {
            throw new NullPointerException("baseURL must not be null.");
        }

        this.baseURL = baseURL;
    }

    public URLBuilder putParam(final String key, final Object value) {
        if(key == null) {
            throw new NullPointerException("key must not be null.");
        }
        if(value == null) {
            throw new NullPointerException("value must not be null.");
        }

        params.put(key, value.toString());
        return this;
    }

    public URL create() throws MalformedURLException {
        return new URL(createURLString());
    }

    private String createURLString() {
        if(params.isEmpty()) {
            return baseURL;
        }

        final StringBuilder builder = new StringBuilder(baseURL).append('?');


        for(String key: params.keySet()) {
            builder.append(key).append('=').append(params.get(key)).append('&');
        }

        return builder.substring(0, builder.length() - 1);
    }
}
