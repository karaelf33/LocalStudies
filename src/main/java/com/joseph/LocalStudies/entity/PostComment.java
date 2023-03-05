package com.joseph.LocalStudies.entity;

import jakarta.persistence.*;

import java.util.Set;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "post_comment")
public class PostComment {

    @Id
    @GeneratedValue(strategy = SEQUENCE)
    private int id;

    private String review;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post postId;

    public PostComment() {
    }
}
