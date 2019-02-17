package com.webApplicationBasis.User.Model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;


@Entity
public class Note {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    
    @NotEmpty(message = "Subject is required.")
    private String subject;
    
    @NotEmpty(message = "Textbody is required.")
    private String body;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="OWNER_ID")
    private User owner;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getSubject() {
        return subject;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }
    public String getBody() {
        return body;
    }
    public void setBody(String body) {
        this.body = body;
    }
    public User getOwner() {
        return owner;
    }
    public void setOwner(User user) {
        this.owner = user;
    }
}
