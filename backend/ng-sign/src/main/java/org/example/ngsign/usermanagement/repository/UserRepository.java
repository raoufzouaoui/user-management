package org.example.ngsign.usermanagement.repository;

import org.example.ngsign.usermanagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

     Optional<User> findUserByEmail(@Param("email") String email);

    Optional<User> findUserByPhone(String phone);
}
