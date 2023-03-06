package com.joseph.LocalStudies.controller;

import com.joseph.LocalStudies.entity.Post;
import com.joseph.LocalStudies.entity.PostComment;
import com.joseph.LocalStudies.repo.PostCommentRepository;
import com.joseph.LocalStudies.repo.PostRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("api/posts")
public class PostController {
    Logger logger = LoggerFactory.getLogger(PostController.class);
    @Autowired
    PostRepository postRepository;

    @Autowired
    PostCommentRepository postCommentRepository;

    @PostMapping("/")
    public void savePosts(){
        Post post=new Post("firstPost");
        postRepository.save(post);

        PostComment postComment=new PostComment(post.getId()+" first review",post);
        PostComment postComment2=new PostComment(post.getId()+" second review",post);

        List<PostComment> postCommentList=new ArrayList<>();

        postCommentList.add(postComment2);
        postCommentList.add(postComment);
        postCommentRepository.saveAll(postCommentList);
        post.setPostComments(postCommentList);
        postRepository.save(post);


    }

    @GetMapping("/infos")
    public void getInfos(){

        postRepository.findAll();

        logger.trace("Detect->" );


    }
}
