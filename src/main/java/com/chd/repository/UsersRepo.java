package com.chd.repository;

import com.chd.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UsersRepo extends JpaRepository<Users, Integer> {
}
