package com.example.mybank.repository;
 
import org.springframework.data.jpa.repository.JpaRepository;
 
import com.example.mybank.model.*;

public interface UserRepository extends JpaRepository<User, Long> {
 
}
