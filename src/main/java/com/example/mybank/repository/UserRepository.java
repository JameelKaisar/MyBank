package com.example.mybank.repository;
 
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.mybank.model.*;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE u.email = ?1")
    public User findByEmail(String email);

    @Query("SELECT u FROM User u")
    public List<User> findAllUsers();

    @Query("SELECT u FROM User u WHERE u.name like %?1%")
    public List<User> findUsersByName(String query);

    @Query("SELECT u FROM User u WHERE u.aadhar LIKE %?1%")
    public List<User> findUsersByAadhar(String query);

    @Query("SELECT u FROM User u WHERE u.phone LIKE %?1%")
    public List<User> findUsersByPhone(String query);
}
