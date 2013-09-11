package com.taroid.slideshare4j;

public class QueryBuilder {

    private String words;

    private String language = Query.DEFAULT_LANG;

    private SortOrder sortOrder = Query.DEFAULT_SORT_ORDER;

    public Query create() {
        if(words == null) {
            throw new IllegalStateException("please call a method \"setWords\".");
        }

        return new Query(words, language, sortOrder);
    }

    public QueryBuilder clear() {
        words = null;
        language = Query.DEFAULT_LANG;
        sortOrder = Query.DEFAULT_SORT_ORDER;
        return this;
    }

    public QueryBuilder setWords(final String words) {
        if(words == null) {
            throw new NullPointerException("words must not be null.");
        }

        this.words = words;
        return this;
    }

    public QueryBuilder setLanguage(final String language) {
        if(language == null) {
            throw new NullPointerException("language must not be null.");
        }

        this.language = language;
        return this;
    }

    public QueryBuilder setSortOrder(final SortOrder sortOrder) {
        if(sortOrder == null) {
            throw new NullPointerException("sortOrder must not be null.");
        }

        this.sortOrder = sortOrder;
        return this;
    }
}
