package com.auth.authentication.models;

import com.fasterxml.jackson.annotation.JsonIncludeProperties;

import javax.persistence.*;

@Entity
public class Content {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String body;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "profile_id",
            referencedColumnName = "id"
    )
    @JsonIncludeProperties("content")
    private Profile profile;

    public Content() {
    }

    public Content(String body, Profile profile) {
        this.body = body;
        this.profile = profile;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }
}
