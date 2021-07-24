package org.sidsri.plugins.bookstoreapi;

import org.sidsri.plugins.bookstoreapi.messages.Message;

import org.springframework.web.bind.annotation.*;


@RestController
public class MessageController {


    @GetMapping("/message")
    Message send() {
        return new Message("first message");
    }

    @PostMapping("/message")
    Message echo (@RequestBody Message message) {
        return message;
    }




}