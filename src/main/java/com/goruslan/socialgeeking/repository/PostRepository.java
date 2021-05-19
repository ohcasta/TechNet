package com.goruslan.socialgeeking.repository;

import com.goruslan.socialgeeking.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PostRepository extends JpaRepository<Post, Long> {

}
