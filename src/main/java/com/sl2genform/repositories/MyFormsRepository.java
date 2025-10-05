package com.sl2genform.repositories;

import com.sl2genform.entities.MyForms;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface MyFormsRepository extends CrudRepository<MyForms, Integer> {

    @Query("SELECT m FROM MyForms m WHERE m.nameInsured = :nameInsured")
    Optional<MyForms> getByNameInsured(@Param("nameInsured") String nameInsured);

    @Query("SELECT m FROM MyForms m WHERE m.user.user_id = :userId")
    List<MyForms> findByUser_UserId(@Param("userId") Long userId);

}
