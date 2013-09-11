package com.taroid.slideshare4j;

/**
 * ソート順列挙型
 */
public enum SortOrder {
    /**
     * 関連順
     */
    RELEVANCE,

    /**
     * 表示回数順
     */
    MOSTVIEWED,

    /**
     * ダウンロード数順
     */
    MOSTDOWNLOADED,

    /**
     * 新しい順
     */
    LATEST;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
