package com.SalJobs.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.SalJobs.backend.model.Chat;
import com.SalJobs.backend.model.Listing;
import com.SalJobs.backend.model.Message;
import com.SalJobs.backend.repository.ChatRepository;
import com.SalJobs.backend.repository.ListingRepository;

import java.util.List;

/*
 * API methods go here. @PostMapping means it's a post method, @GetMapping means
 * get method. etc. etc. 
 */

@CrossOrigin("*")
@RestController
@RequestMapping("/chats")
public class ChatController {

    @Autowired
    private ChatRepository chatRepository;

    @GetMapping("/getChats")
    public List<Chat> getAllChats(@RequestBody String userId){
    	List<Chat> result = chatRepository.findByRecruiter(userId);
        return result;
    }

    @PostMapping("/create")
    public String createListing(@RequestBody Chat chat) {
        chatRepository.save(chat);
        return "ok";
    }
}

