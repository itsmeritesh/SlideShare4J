package com.taroid.slideshare4j;

import java.util.Date;

public final class SlideshowBuilder {

    private Long id;

    private String title;

    private String username;

    private String description;

    private String url;

    private String thumbnailURL;

    private Date created;

    private Date updated;

    private String language;

    private String embed;

    public Slideshow create() {
        if (id == null || title == null || username == null || description == null || url == null
                || thumbnailURL == null || created == null || updated == null || language == null || embed == null) {
            throw new IllegalStateException("please call each methods \"set*\".");
        }

        return new Slideshow(id, title, username, description, url, thumbnailURL, created, updated, language, embed);
    }

    public SlideshowBuilder clear() {
        id = null;
        title = null;
        username = null;
        description = null;
        url = null;
        thumbnailURL = null;
        created = null;
        updated = null;
        language = null;
        embed = null;
        return this;
    }

    public SlideshowBuilder setID(long id) {
        this.id = id;
        return this;
    }

    public SlideshowBuilder setTitle(String title) {
        if (title == null) {
            throw new NullPointerException("title must not be null.");
        }

        this.title = title;
        return this;
    }

    public SlideshowBuilder setUsername(String username) {
        if (username == null) {
            throw new NullPointerException("username must not be null.");
        }

        this.username = username;
        return this;
    }

    public SlideshowBuilder setDescription(String description) {
        if (description == null) {
            throw new NullPointerException("description must not be null.");
        }

        this.description = description;
        return this;
    }

    public SlideshowBuilder setURL(String url) {
        if (url == null) {
            throw new NullPointerException("url must not be null.");
        }

        this.url = url;
        return this;
    }

    public SlideshowBuilder setThumbnailURL(String thumbnailURL) {
        if (thumbnailURL == null) {
            throw new NullPointerException("thumbnailURL must not be null.");
        }

        this.thumbnailURL = thumbnailURL;
        return this;
    }

    public SlideshowBuilder setCreated(Date created) {
        if (created == null) {
            throw new NullPointerException("created must not be null.");
        }

        this.created = created;
        return this;
    }

    public SlideshowBuilder setUpdated(Date updated) {
        if (updated == null) {
            throw new NullPointerException("updated must not be null.");
        }

        this.updated = updated;
        return this;
    }

    public SlideshowBuilder setLanguage(String language) {
        if (language == null) {
            throw new NullPointerException("language must not be null.");
        }

        this.language = language;
        return this;
    }

    public SlideshowBuilder setEmbed(String embed) {
        if (embed == null) {
            throw new NullPointerException("embed must not be null.");
        }

        this.embed = embed;
        return this;
    }
}
