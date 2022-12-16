package com.example.demo.repo;

import com.example.demo.model.Profiles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ProfileRepository extends JpaRepository<Profiles, Integer> {
    @Modifying
    @Query(value = "INSERT INTO profiles VALUES(?1, ?2, ?3, ?4)", nativeQuery = true)
    @Transactional
    void addProfile(String username, String password, int age, String mobileNo);

    @Query(value = "SELECT username FROM profiles WHERE username = ?1 AND password = ?2", nativeQuery = true)
    List<String> validateProfile(String username, String password);
}
