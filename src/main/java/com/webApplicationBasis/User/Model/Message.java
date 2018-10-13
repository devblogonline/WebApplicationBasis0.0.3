package com.webApplicationBasis.User.Model;

/**
 * Created by lauda on 10.10.2018.
 */

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
public class Message {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String subject;
    private String body;

    @OneToOne
    @NotNull
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
