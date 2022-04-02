package com.auth.authentication.models;

import com.auth.authentication.auth.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String address;
    private String city;
    private String phone;

    @OneToMany(mappedBy = "profile", fetch = FetchType.LAZY)
    private List<Content> contentList;

    @OneToOne
    @JoinColumn(
            name = "users_id",
            referencedColumnName = "id"
    )
    @JsonIgnore
    private User user;

    public Profile() {
    }

    public Profile(String name, String address, String city, String phone, User user) {
        this.name = name;
        this.address = address;
        this.city = city;
        this.phone = phone;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Content> getContentList() {
        return contentList;
    }

    public void setContentList(List<Content> contentList) {
        this.contentList = contentList;
    }
}
