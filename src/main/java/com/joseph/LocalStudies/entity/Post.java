package com.joseph.LocalStudies.entity;

import jakarta.persistence.*;

import java.util.Set;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = SEQUENCE)
    private int id;

    @Column(name = "title")
    private String title;

    @OneToMany(fetch = FetchType.LAZY)
    private Set<PostComment> postComments;

    public Post() {
    }




}