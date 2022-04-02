package com.auth.authentication.controllers;

import com.auth.authentication.repositories.ContentRepository;
import com.auth.authentication.repositories.ProfileRepository;
import com.auth.authentication.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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



}
