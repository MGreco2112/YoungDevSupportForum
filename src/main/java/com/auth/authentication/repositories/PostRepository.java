package com.auth.authentication.repositories;

import com.auth.authentication.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {

}
