package com.taroid.slideshare4j;

import java.util.Date;

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

    public Slideshow(
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

    public long getID() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getUsername() {
        return username;
    }

    public String getDescription() {
        return description;
    }

    public String getURL() {
        return url;
    }

    public String getThumbnailURL() {
        return thumbnailURL;
    }

    public Date getCreated() {
        return created;
    }

    public Date getUpdated() {
        return updated;
    }

    public String getLanguage() {
        return language;
    }

    public String getEmbed() {
        return embed;
    }
}