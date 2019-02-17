package com.webApplicationBasis.User.Services;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.webApplicationBasis.User.Model.Note;

@Repository
public interface NoteRepository extends CrudRepository<Note, Long> {
    
}
