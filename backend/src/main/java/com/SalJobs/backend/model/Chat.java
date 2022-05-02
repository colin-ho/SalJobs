package com.SalJobs.backend.model;

import javax.persistence.*;

@Entity
@Table(name = "Chats")
public class Chat {
	
	 public Chat(long id, String applicant, String recruiter, String status) {
		super();
		this.id = id;
		this.applicant = applicant;
		this.recruiter = recruiter;
		this.status = status;
	}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "applicant")
    private String applicant;

	@Column(name = "recruiter")
    private String recruiter;
    
    @Column(name = "status")
    private String status;

    public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getApplicant() {
		return applicant;
	}

	public void setApplicant(String applicant) {
		this.applicant = applicant;
	}

	public String getRecruiter() {
		return recruiter;
	}

	public void setRecruiter(String recruiter) {
		this.recruiter = recruiter;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
    
}