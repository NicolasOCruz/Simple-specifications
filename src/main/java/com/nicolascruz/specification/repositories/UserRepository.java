package com.nicolascruz.specification.repositories;

import com.nicolascruz.specification.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID>,
        JpaSpecificationExecutor<User> {
}
