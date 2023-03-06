package com.joseph.LocalStudies.entity;

import jakarta.persistence.*;

import java.util.Set;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "post_comment")
public class PostComment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String review;

    @ManyToOne
    private Post post;

    public PostComment() {
    }


    public PostComment(String review, Post post) {
        this.review = review;
        this.post = post;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    @Override
    public String toString() {
        return "PostComment{" +
                "id=" + id +
                ", review='" + review + '\'' +
                '}';
    }
}
