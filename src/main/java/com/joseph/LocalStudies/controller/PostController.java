package com.joseph.LocalStudies.controller;

import com.joseph.LocalStudies.repo.PostRepository;
import jakarta.persistence.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/posts")
public class PostController {
    Logger logger = LoggerFactory.getLogger(PostController.class);

    @PersistenceContext
    EntityManager entityManager;
    @Autowired
    PostRepository postRepository;

    @GetMapping("/tess")
    public void savePost(){
     /*   EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
        EntityManager entityManager = entityManagerFactory.createEntityManager();*/

        List<Tuple> comments = entityManager.createNativeQuery("""
    SELECT
        pc.id AS id,
        pc.review AS review,
        pc.post_id AS postId
    FROM post_comment pc
    """, Tuple.class)
                .getResultList();


        for (Tuple comment : comments) {
            String review = (String) comment.get("review");
            Long postId = ((Number) comment.get("postId")).longValue();

            String postTitle = (String) entityManager.createNativeQuery("""
        SELECT
            p.title
        FROM post p
        WHERE p.id = :postId
        """)
                    .setParameter("postId", postId)
                    .getSingleResult();

            logger.info(
                    "The Post '{}' got this review '{}'",
                    postTitle,
                    review
            );
        }
    }

}
