package com.SalJobs.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.web.bind.annotation.*;

import com.SalJobs.backend.model.Message;
import com.SalJobs.backend.repository.MessageRepository;

import java.util.List;

/*
 * API methods go here. @PostMapping means it's a post method, @GetMapping means
 * get method. etc. etc. 
 */

@CrossOrigin("*")
@RestController
@RequestMapping("/messages")
public class MessageController {

    @Autowired
    private MessageRepository messageRepository;

    @GetMapping("/getMessages")
    public List<Message> getAllMessages(@RequestBody String chatId){
    	List<Message> result = messageRepository.findByChatId(chatId);
        return result;
    }
    
    @MessageMapping("/{chatId}/send")
    public Message sendMessage(@DestinationVariable String chatId, Message message) throws Exception {
    	messageRepository.save(message);
    	return message;
    }

}

