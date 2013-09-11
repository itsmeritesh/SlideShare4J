package com.taroid.slideshare4j;

/**
 * ページング用クラス
 */
public final class Paging {

    private final int itemsPerPage;

    private final int page;

    /**
     * @param itemsPerPage ページあたりのスライド数(最大100)
     * @param page ページ
     * @throws IllegalArgumentException 引数に0以下が与えられた場合、または{@code itemsPerPage}に100を超える値が与えられた場合
     */
    public Paging(final int itemsPerPage, final int page) {
        if(itemsPerPage <= 0 || 100 < itemsPerPage) {
            throw new IllegalArgumentException("itemsPerPage must be in 1 to 100.");
        }
        if(page <= 0) {
            throw new IllegalArgumentException("page must be greater than zero.");
        }

        this.itemsPerPage = itemsPerPage;
        this.page = page;
    }

    /**
     * ページあたりのスライド数を返します。
     * @return ページあたりのスライド数
     */
    public int getItemsPerPage() {
        return itemsPerPage;
    }

    /**
     * ページを返します。
     * @return ページ
     */
    public int getPage() {
        return page;
    }
}
