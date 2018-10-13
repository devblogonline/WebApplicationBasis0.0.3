package com.webApplicationBasis.User.Services;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.stereotype.Repository;

import com.webApplicationBasis.User.Model.Message;

@Repository
public interface MessageRepository extends CrudRepository<Message, Long> {

	//@Query("select DISTINCT(u.username) from ActiveWebSocketUser u where u.username != ?#{principal?.username}")
	
    @Query("select m from Message m where m.owner.username = ?#{ principal?.username }")
    Iterable<Message> findAllMessagesToCurrentUser();
    
 //   @Query("select m from Message m where m.user.id = 1")
 //   Iterable<Message> findAllMessagesToCurrentUser();
    
    //@PostAuthorize("hasPermission(returnObject,'read')")
    Message findOne(Long id);
}
