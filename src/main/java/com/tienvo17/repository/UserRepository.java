package com.tienvo17.repository;

import com.tienvo17.models.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User,Long> {
   User findByUserName(String username);
}
