package com.auth.authentication.controllers;

import com.auth.authentication.models.Profile;
import com.auth.authentication.repositories.ProfileRepository;
import com.auth.authentication.repositories.UserRepository;
import com.auth.authentication.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/profile")
public class ProfileController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    ProfileRepository repository;

    @GetMapping
    public List<Profile> getAllProfiles() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Profile> getProfileById(@PathVariable Long id) {
        Profile profile = repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        return ResponseEntity.ok(profile);
    }

    @GetMapping("/phone/{phone}")
    public ResponseEntity<List<Profile>> getProfileByPhone(@PathVariable String phone) {
        List<Profile> profiles = repository.findAllByPhone(phone);

        if (profiles.size() == 0) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(profiles);
    }

    @GetMapping("/{name}")
    public ResponseEntity<Profile> getProfileByName(@PathVariable String name) {
        Optional<Profile> profile = repository.findByName(name);

        if (profile.isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(profile.get());
    }

    @PostMapping
    public ResponseEntity<Profile> createNewProfile(@RequestBody Profile profile) {

    }



}
