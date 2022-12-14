package com.example.LMSBackend.Repository;

import com.example.LMSBackend.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "SELECT * FROM user WHERE email=? AND password=?;" , nativeQuery = true)
    User findUser(String email, String password);
}
