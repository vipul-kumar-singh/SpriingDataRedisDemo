package com.vkstech.SpringDataRedis.repository;

import com.vkstech.SpringDataRedis.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
