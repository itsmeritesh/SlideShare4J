package com.taroid.slideshare4j;

public final class Paging {

    private final int itemsPerPage;

    private final int page;

    public Paging(final int itemsPerPage, final int page) {
        this.itemsPerPage = itemsPerPage;
        this.page = page;
    }

    public int getItemsPerPage() {
        return itemsPerPage;
    }

    public int getPage() {
        return page;
    }
}
