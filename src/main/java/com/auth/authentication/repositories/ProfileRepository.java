package com.auth.authentication.repositories;

import com.auth.authentication.models.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {
    Profile findByUserId(Long id);
    Optional<Profile> findByName(String name);
    List<Profile> findAllByPhone(String phone);

    @Query(value = "SELECT * FROM profile WHERE city = :userCity", nativeQuery = true)
    List<Profile> findAllAllByCity(@Param("userCity") String userCity);
}
