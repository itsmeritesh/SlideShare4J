package com.taroid.slideshare4j;

/**
 * 検索クエリ
 */
public final class Query {

    public static final String DEFAULT_LANG = "**";

    public static final SortOrder DEFAULT_SORT_ORDER = SortOrder.RELEVANCE;

    private final String words;

    private final String language;

    private final SortOrder sortOrder;

    /**
     * 指定された値を持ったクエリを生成します。
     * @param words 検索キーワード
     * @param language 検索対象言語
     * @param sortOrder ソート順
     * @throws java.lang.NullPointerException 引数に{@code null}が指定された場合
     * @throws java.lang.IllegalArgumentException 引数{@code words}の文字数が{@literal 0}の場合
     */
    public Query(final String words, final String language, final SortOrder sortOrder) {
        if(words == null) {
            throw new NullPointerException("words must not be null.");
        }
        if(words.length() == 0) {
            throw new IllegalArgumentException("");
        }
        if(language == null) {
            throw new NullPointerException("language must not be null.");
        }
        if(sortOrder == null) {
            throw new NullPointerException("sortOrder must not be null.");
        }

        this.words = words;
        this.language = language;
        this.sortOrder = sortOrder;
    }

    /**
     * 指定された値を持ったクエリを生成します。<br>
     * ソート順にはデフォルトの値({@link Query#DEFAULT_SORT_ORDER}})が割り当てられます。
     *
     * @param words 検索キーワード
     * @param language 検索対象言語
     */
    public Query(final String words, final String language) {
        this(words, language, DEFAULT_SORT_ORDER);
    }

    /**
     * 指定された値を持ったクエリを生成します。<br>
     * 検索対象言語にはデフォルトの値({@link Query#DEFAULT_LANG})が割り当てられます。
     *
     * @param words 検索キーワード
     * @param sortOrder 検索対象言語
     */
    public Query(final String words, final SortOrder sortOrder) {
        this(words, DEFAULT_LANG, sortOrder);
    }

    /**
     * 指定された値を持ったクエリを生成します。<br>
     * 検索対象言語にはデフォルトの値({@link Query#DEFAULT_LANG})が割り当てられます。<br>
     * ソート順にはデフォルトの値({@link Query#DEFAULT_SORT_ORDER}})が割り当てられます。
     *
     * @param words
     */
    public Query(final String words) {
        this(words, DEFAULT_LANG, DEFAULT_SORT_ORDER);
    }

    /**
     * 検索キーワードを返します。
     * @return 検索キーワード
     */
    public String getWords() {
        return words;
    }

    /**
     * 検索対象言語を返します。
     * @return 検索対象言語
     */
    public String getLanguage() {
        return language;
    }

    /**
     * ソート順を返します。
     * @return ソート順
     */
    public SortOrder getSortOrder() {
        return sortOrder;
    }
}
