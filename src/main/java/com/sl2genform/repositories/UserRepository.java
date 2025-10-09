package com.sl2genform.repositories;


import com.sl2genform.entities.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer> {

    @Query("SELECT u FROM User u WHERE u.email = :email")
    Optional<User> findByEmail(@Param("email") String email);

    @Modifying
    @Transactional
    @Query("""
        UPDATE User u
        SET 
            u.name = :name,
            u.surname = :surname,
            u.email = :email,
            u.password = :password,
            u.role = :role,
            u.avatar = :avatar
        WHERE u.user_id = :id
    """)
    int updateUser(
            @Param("id") Integer id,
            @Param("name") String name,
            @Param("surname") String surname,
            @Param("email") String email,
            @Param("password") String password,
            @Param("role") String role,
            @Param("avatar") String avatar
    );
}

