package com.taroid.slideshare4j;

import java.util.Date;

/**
 * スライド
 */
public final class Slideshow {

    private final long id;

    private final String title;

    private final String username;

    private final String description;

    private final String url;

    private final String thumbnailURL;

    private final Date created;

    private final Date updated;

    private final String language;

    private final String embed;

    // SlideShare4J使用者には直接newさせない
    /*package*/ Slideshow(
            final long id,
            final String title,
            final String username,
            final String description,
            final String url,
            final String thumbnailURL,
            final Date created,
            final Date updated,
            final String language,
            final String embed
    ) {
        this.id = id;
        this.title = title;
        this.username = username;
        this.description = description;
        this.url = url;
        this.thumbnailURL = thumbnailURL;
        this.created = created;
        this.updated = updated;
        this.language = language;
        this.embed = embed;
    }

    /**
     * スライドIDを返します。
     *
     * @return スライドID
     */
    public long getID() {
        return id;
    }

    /**
     * スライドのタイトルを返します。
     *
     * @return タイトル
     */
    public String getTitle() {
        return title;
    }

    /**
     * スライドを所有しているユーザ名を返します。
     *
     * @return ユーザ名
     */
    public String getUsername() {
        return username;
    }

    /**
     * スライドの説明文を返します。
     *
     * @return 説明文
     */
    public String getDescription() {
        return description;
    }

    /**
     * スライドの掲載URLを返します。
     *
     * @return 掲載URL
     */
    public String getURL() {
        return url;
    }

    /**
     * スライドのサムネイル画像のURLを返します。
     *
     * @return サムネイル画像のURL
     */
    public String getThumbnailURL() {
        return thumbnailURL;
    }

    /**
     * スライドの作成日を返します。
     *
     * @return 作成日
     */
    public Date getCreated() {
        return created;
    }

    /**
     * スライドの更新日を返します。
     *
     * @return 更新日
     */
    public Date getUpdated() {
        return updated;
    }

    /**
     * スライドの言語を返します。
     *
     * @return 言語
     */
    public String getLanguage() {
        return language;
    }

    /**
     * スライドの埋め込み用HTMLタグを返します。
     *
     * @return 埋め込み用HTMLタグ
     */
    public String getEmbed() {
        return embed;
    }
}