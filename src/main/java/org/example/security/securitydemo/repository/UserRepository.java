package org.example.security.securitydemo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.example.security.securitydemo.model.Users;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<Users, Integer> {

    Optional<Users> findByUsername(String username);

}
