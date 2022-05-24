package com.auth.authentication.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Set;

@Entity
public class Post {
    /*
    fields:
    Long id
    String body
    String Title
    String topic (if null, post is head post)
    Set<Post> replies (other posts)
     */

    //TODO create relationship with Collector, One Collector to Many Posts

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String body;
    private String title;
    private String topic;
    private Set<Post> replies;

    public Post() {
    }

    public Post(Long id, String body, String title, String topic) {
        this.id = id;
        this.body = body;
        this.title = title;
        this.topic = topic;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public Set<Post> getReplies() {
        return replies;
    }

    public void setReplies(Set<Post> replies) {
        this.replies = replies;
    }
}
