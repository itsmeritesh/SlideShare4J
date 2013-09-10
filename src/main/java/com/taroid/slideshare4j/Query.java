package com.taroid.slideshare4j;

public final class Query {

    private static final String DEFAULT_LANG = "**";

    private static final SortOrder DEFAULT_SORT_ORDER = SortOrder.RELEVANCE;

    private final String words;

    private final String language;

    private final SortOrder sortOrder;

    public Query(final String words, final String language, final SortOrder sortOrder) {
        this.words = words;
        this.language = language;
        this.sortOrder = sortOrder;
    }

    public Query(final String words, final String language) {
        this(words, language, DEFAULT_SORT_ORDER);
    }

    public Query(final String words, final SortOrder sortOrder) {
        this(words, DEFAULT_LANG, sortOrder);
    }

    public Query(final String words) {
        this(words, DEFAULT_LANG, DEFAULT_SORT_ORDER);
    }

    public String getWords() {
        return words;
    }

    public String getLanguage() {
        return language;
    }

    public SortOrder getSortOrder() {
        return sortOrder;
    }
}
