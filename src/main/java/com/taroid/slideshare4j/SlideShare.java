package com.taroid.slideshare4j;

import java.util.List;

/**
 * SlideShareのAPI
 */
public interface SlideShare {

    /**
     * 指定されたクエリに基づいてスライドを検索し、ヒットしたスライドのリストを返します。<br>
     *
     * @param query 検索クエリ
     * @param paging 検索ページ
     * @return 検索にヒットしたスライドのリスト
     * @throws NullPointerException 引数が{@code null}の場合
     */
    List<Slideshow> searchSlideshows(Query query, Paging paging);
}
