package com.TaskManager.Assessment.Repository;

import com.TaskManager.Assessment.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}