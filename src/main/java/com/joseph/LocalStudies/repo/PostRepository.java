package com.joseph.LocalStudies.repo;

import com.joseph.LocalStudies.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Integer> {
}
