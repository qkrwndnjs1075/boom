package com.example.dmc.domain.user.domain.repository;


import com.example.dmc.domain.user.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends CrudRepository<User, UUID> {

    Optional<User> findByAccountId(String accountId);

    boolean existsByAccountId(String accountId);
}
