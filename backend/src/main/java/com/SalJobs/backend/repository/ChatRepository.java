package com.SalJobs.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SalJobs.backend.model.Chat;

public interface ChatRepository extends JpaRepository<Chat, Long> {
	List <Chat> findByRecruiter(String recruiter);
	List <Chat> findByApplicant(String applicant);
}