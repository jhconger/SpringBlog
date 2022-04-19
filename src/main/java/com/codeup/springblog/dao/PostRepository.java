package com.codeup.springblog.dao;

import com.codeup.springblog.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {

    Post findPostById(long id);

    Post findPostByTitle(String title);

}