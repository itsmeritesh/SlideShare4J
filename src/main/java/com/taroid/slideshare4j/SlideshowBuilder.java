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
        return new Slideshow(id, title, username, description, url, thumbnailURL, created, updated, language, embed);
    }

    public void clear() {
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
    }

    public SlideshowBuilder setID(long id) {
        this.id = id;
        return this;
    }

    public SlideshowBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    public SlideshowBuilder setUsername(String username) {
        this.username = username;
        return this;
    }

    public SlideshowBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    public SlideshowBuilder setURL(String url) {
        this.url = url;
        return this;
    }

    public SlideshowBuilder setThumbnailURL(String thumbnailURL) {
        this.thumbnailURL = thumbnailURL;
        return this;
    }

    public SlideshowBuilder setCreated(Date created) {
        this.created = created;
        return this;
    }

    public SlideshowBuilder setUpdated(Date updated) {
        this.updated = updated;
        return this;
    }

    public SlideshowBuilder setLanguage(String language) {
        this.language = language;
        return this;
    }

    public SlideshowBuilder setEmbed(String embed) {
        this.embed = embed;
        return this;
    }
}
