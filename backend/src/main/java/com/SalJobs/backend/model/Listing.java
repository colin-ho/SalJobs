package com.SalJobs.backend.model;

import javax.persistence.*;

/*
 * Class for the listing. Add the constructor, getters and setter. The @ stuff
 * corresponds to SQL notation, i.e. @ID == primary key, @Column == attribute. 
 * For other stuff like foreign keys, search up JPA annotations, jpa foreign key etc.
 */

@Entity
@Table(name = "Listings")
public class Listing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    /* add more shit*/
    
}