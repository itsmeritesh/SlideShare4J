package com.taroid.slideshare4j;

import java.io.InputStream;
import java.util.List;

public interface SlideshowConverter {

    List<Slideshow> convert(InputStream inputStream);
}
