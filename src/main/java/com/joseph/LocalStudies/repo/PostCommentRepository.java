package com.joseph.LocalStudies.repo;

import com.joseph.LocalStudies.entity.PostComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostCommentRepository extends JpaRepository<PostComment,Integer> {
}
