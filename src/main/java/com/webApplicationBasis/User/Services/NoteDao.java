package com.webApplicationBasis.User.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webApplicationBasis.User.Model.Note;

@Service
public class NoteDao {

	@Autowired
	NoteRepository noteRepository;
	
    public void addNote(Note note) {
    		noteRepository.save(note);
      }
}
