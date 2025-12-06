package com.example.SupportIQ.Controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SupportIQ.service.AIService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/v1/helpdesk")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:5173")
public class AiController {


    private  final AIService service;

    @PostMapping
    public ResponseEntity<String >  getResponse(@RequestBody  String query, @RequestHeader("ConversationId") String conversationId){
        return ResponseEntity.ok(service.getResponseFromAssistant(query,conversationId));
    }


    @PostMapping(value = "/stream")
    public Flux<String> streamResponse(@RequestBody  String query, @RequestHeader("ConversationId") String conversationId){
        return this.service.streamResponseFromAssistant(query,conversationId) ;
    }



}