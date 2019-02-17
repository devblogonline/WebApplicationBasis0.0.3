package com.webApplicationBasis.User.Model;


import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;


@Entity
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    
    @NotEmpty(message = "Name is required.")
    private String name;
    
    @NotEmpty(message = "Lastname is required.")
    private String lastName;
    
    @Email(message = "Please provide a valid email address.")
    @NotEmpty(message = "Email is required.")
    private String email;
 
    private String company;

    @NotEmpty(message = "Username is required.")
    private String username;
    
    @NotEmpty(message = "Password is required.")
    private String password;
    
    @Enumerated(EnumType.STRING)
    private Role role;
    
    
    @OneToMany(mappedBy="owner")
    private List<Note> notes;

	public List<Note> getNotes() {
		return notes;
	}

	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}

	public User() {}

    public User(String username){
        this.username = username;
    }

    public User(String username, String password){
        this.username = username;
        this.password = password;
    }
    
    public User(String username, String password, Role role){
        this.username = username;
        this.password = password;
        this.role = role;
    }
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getCompany() {
        return company;
    }
    public void setCompany(String company) {
        this.company = company;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}

}