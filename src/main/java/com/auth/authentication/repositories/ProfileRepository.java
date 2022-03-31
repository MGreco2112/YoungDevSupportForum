package com.auth.authentication.repositories;

import com.auth.authentication.models.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
    Profile findByUserId(Long id);
    Profile findByName(String name);
    List<Profile> findAllByPhone(String phone);

    @Query("SELECT * FROM profile WHERE city = 1?")
    List<Profile> findAllAllByCity(String city);
}
