package com.auth.authentication.controllers;

import com.auth.authentication.models.Post;
import com.auth.authentication.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/post")
public class PostController {

    @Autowired
    private PostRepository repository;

    @GetMapping
    public List<Post> findAllPosts() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> findPostById(@PathVariable Long id) {
        Post post = repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        return ResponseEntity.ok(post);
    }

    @PostMapping("/new")
    public ResponseEntity<Post> createNewPost(@RequestBody Post newPost) {
        return new ResponseEntity<>(repository.save(newPost), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Post> updatePost(@RequestBody Post updates) {
        Post selPost = repository.findById(updates.getId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        if (updates.getTitle() != null) {
            selPost.setTitle(updates.getTitle());
        }
        if (updates.getBody() != null) {
            selPost.setBody(updates.getBody());
        }
        if (updates.getTopic() != null) {
            selPost.setTopic(updates.getTopic());
        }
        if (updates.getReplies() != null) {
            selPost.setReplies(updates.getReplies());
        }

        return ResponseEntity.ok(repository.save(selPost));
    }

    @DeleteMapping
    public ResponseEntity<String> deletePost(@RequestBody Post deleted) {
        Post delPost = repository.findById(deleted.getId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        repository.delete(delPost);

        return ResponseEntity.ok("Deleted Post");
    }
}
