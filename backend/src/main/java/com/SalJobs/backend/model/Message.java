package com.SalJobs.backend.model;

import javax.persistence.*;

@Entity
@Table(name = "Messages")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "sender")
    private String sender;

	@Column(name = "body")
    private String body;
	
	@Column(name = "chatId")
    private String chatId;
    
}