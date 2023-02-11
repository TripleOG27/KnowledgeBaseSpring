package com.detelin.kb.domain.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "articles")
public class Article extends BaseEntity{
    private String title;
    private User author;
    private String description;
    private String longText;
    private String workaround;
    private LocalDate createdDate;

    public Article() {
    }
    @Column(name = "title",nullable = false)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @JoinColumn( name= "user_id",referencedColumnName = "id")
    @ManyToOne(targetEntity = User.class,fetch = FetchType.EAGER)
    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }
    @Column(name = "description",nullable = true)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    @Column(name = "steps",columnDefinition = "TEXT",nullable = true)
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
    @Column(name = "created_date",columnDefinition = "DATE",nullable = false)
    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }
}
