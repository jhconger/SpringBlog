package com.codeup.springblog.model;
import org.hibernate.engine.internal.Cascade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;

@Entity
@Table(name = "posts")
public class Post {
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String body;

    @OneToOne
    private User user;
    public Post() {}

    public Post(String title, String body) {
        this.title = title;
        this.body = body;

    }
    public Post(String title, String body, User user) {
        this.title = title;
        this.body = body;
        this.user = user;
    }



    // getters & setters
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return this.body;
    }
    public void setBody(String body) {
        this.body = body;
    }

    public User getUser() {return this.user;}
    public void setUser(User user){this.user = user;}
}