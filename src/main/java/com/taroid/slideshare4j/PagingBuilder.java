package com.taroid.slideshare4j;

public final class PagingBuilder {

    public static final int DEFAULT_ITEMS_PER_PAGE = 16;

    public static final int DEFAULT_PAGE = 1;

    private int itemsPerPage = DEFAULT_ITEMS_PER_PAGE;

    private int page = DEFAULT_PAGE;

    public Paging create() {
        return new Paging(itemsPerPage, page);
    }

    public void clear() {
        itemsPerPage = DEFAULT_ITEMS_PER_PAGE;
        page = DEFAULT_PAGE;
    }

    public PagingBuilder setItemsPerPage(int itemsPerPage) {
        if(itemsPerPage <= 0 || 100 < itemsPerPage) {
            throw new IllegalArgumentException("itemsPerPage must be in 1 to 100.");
        }

        this.itemsPerPage = itemsPerPage;
        return this;
    }

    public PagingBuilder setPage(int page) {
        if(page <= 0) {
            throw new IllegalArgumentException("page must be greater than zero.");
        }

        this.page = page;
        return this;
    }
}
