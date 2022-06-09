package com.auth.authentication.controllers;

import com.auth.authentication.auth.User;
import com.auth.authentication.models.Content;
import com.auth.authentication.models.Profile;
import com.auth.authentication.repositories.ContentRepository;
import com.auth.authentication.repositories.ProfileRepository;
import com.auth.authentication.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/content")
public class ContentController {
    @Autowired
    private ProfileRepository profileRepository;
    @Autowired
    private ContentRepository repository;
    @Autowired
    private UserService userService;

    @GetMapping
    public List<Content> findAllPostedContent() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Content>> findContentByProfileId(@PathVariable Long id) {
        User currentUser = userService.getCurrentUser();

        if (currentUser == null) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        Profile currentProfile = profileRepository.findByUserId(currentUser.getId());

        if (currentProfile == null) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        return ResponseEntity.ok(repository.findByProfileId(currentProfile.getId()));
    }

    @PostMapping
    public ResponseEntity<Content> createNewContent(@RequestBody Content content) {
        User currentUser = userService.getCurrentUser();

        if (currentUser == null) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        Profile profile = profileRepository.findByUserId(currentUser.getId());

        if (profile == null) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        if (content.getBody() == null) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        profile.getContentList().add(content);
        content.setProfile(profile);

        profileRepository.save(profile);

        return new ResponseEntity<>(repository.save(content), HttpStatus.CREATED);
    }

   //Create Delete Mapping
    @DeleteMapping("/{id}")
    public ResponseEntity<String> removeContent(@PathVariable Long id){
        repository.deleteById(id);
        return new ResponseEntity<>("Content has been removed", HttpStatus.OK);
    }
}
