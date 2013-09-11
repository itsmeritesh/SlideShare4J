package com.taroid.slideshare4j;

import java.io.InputStream;
import java.util.List;

public interface SlideshowConverter {

    /**
     * 指定されたInputStreamからスライド情報を取得し、@{link Slideshow}へ変換しリストとして返します。
     * @param inputStream
     * @return
     */
    List<Slideshow> convert(InputStream inputStream);
}
