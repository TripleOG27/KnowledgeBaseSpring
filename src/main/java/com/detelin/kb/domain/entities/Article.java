package com.detelin.kb.domain.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "articles")
public class Article extends BaseEntity{
    private String title;
    private String author;
    private String description;
    private String longText;
    private String workaround;

    public Article() {
    }
    @Column(name = "title",nullable = false)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    @Column(name = "user_id")
    @OneToMany(targetEntity = User.class,mappedBy = "user_id")
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    @Column(name = "description",nullable = true)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    @Column(name = "title",columnDefinition = "TEXT",nullable = true)
    public String getLongText() {
        return longText;
    }

    public void setLongText(String longText) {
        this.longText = longText;
    }
    @Column(name = "workaround",columnDefinition = "TEXT",nullable = true)
    public String getWorkaround() {
        return workaround;
    }

    public void setWorkaround(String workaround) {
        this.workaround = workaround;
    }
}
