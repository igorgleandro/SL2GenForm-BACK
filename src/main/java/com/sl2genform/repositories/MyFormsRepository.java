package com.sl2genform.repositories;

import com.sl2genform.entities.MyForms;
import org.springframework.data.repository.CrudRepository;

public interface MyFormsRepository extends CrudRepository<MyForms, Integer> {
}
