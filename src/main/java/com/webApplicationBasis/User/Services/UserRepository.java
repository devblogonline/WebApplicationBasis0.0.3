package com.webApplicationBasis.User.Services;

import org.springframework.data.repository.CrudRepository;

import com.webApplicationBasis.User.Model.*;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);

    User findById(Long id);
}