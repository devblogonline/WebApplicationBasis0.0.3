package com.webApplicationBasis.User.Services;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.webApplicationBasis.User.Model.*;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);
    
    @Query("select notes from User where username = ?#{ principal?.username }")
    List<Note> findAllNotesFromCurrentUser();
}