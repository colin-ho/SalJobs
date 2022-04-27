package com.SalJobs.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * Class for the User. Add the constructor, getters and setter. The @ stuff
 * corresponds to SQL notation, i.e. @ID == primary key, @Column == attribute. 
 * For other stuff like foreign keys, search up JPA annotations, jpa foreign key etc.
 */

@Entity
@Table(name = "Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "email")
    private String email;
    
    @Column(name = "name")
    private String name;

	@Column(name = "password")
    private String password;
    
    @Column(name = "authToken")
    private String authToken;

    
}
