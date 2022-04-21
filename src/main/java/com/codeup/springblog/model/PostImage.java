package com.codeup.springblog.model;
import javax.persistence.*;

@Entity
@Table(name = "post_images")
public class PostImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String path;

    @Column(nullable = false)
    private String description;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    public PostImage() {
    }

    public PostImage(String path, String description, Post post) {
        this.path = path;
        this.description = description;
        this.post = post;
    }

    public PostImage(long id, String path, String description, Post post) {
        this.id = id;
        this.path = path;
        this.description = description;
        this.post = post;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}