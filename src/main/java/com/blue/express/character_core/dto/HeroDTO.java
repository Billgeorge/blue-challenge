package com.blue.express.character_core.dto;

import com.blue.express.character_core.constant.Constant;

import java.time.LocalDateTime;

public class HeroDTO {

    private String detail;

    private long id;

    private String name;

    private String description;

    private long likes;

    private long dislikes;

    private String imageUrl;

    private LocalDateTime updateDateTime;

    public String getDetail() {
        return detail;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setDetail(Long id) {
        this.detail = Constant.CHARACTER_PATH+id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getLikes() {
        return likes;
    }

    public void setLikes(long likes) {
        this.likes = likes;
    }

    public long getDislikes() {
        return dislikes;
    }

    public void setDislikes(long dislikes) {
        this.dislikes = dislikes;
    }

    public LocalDateTime getUpdateDateTime() {
        return updateDateTime;
    }

    public void setUpdateDateTime(LocalDateTime updateDateTime) {
        this.updateDateTime = updateDateTime;
    }
}
