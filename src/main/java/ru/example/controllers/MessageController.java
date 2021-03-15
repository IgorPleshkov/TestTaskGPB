package ru.example.controllers;

import ru.example.entity.Message;
import ru.example.exception.MessageException;
import ru.example.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/task")
public class MessageController {

    @Autowired
    private MessageService service;

    @GetMapping("/{uuid}")
    public Message getByUUID(@PathVariable UUID uuid) {
        Optional<Message> optionalMessage;
        try {
            optionalMessage = service.getByUUID(uuid);
        } catch (MessageException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
        return optionalMessage.get();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public UUID addMessage() {
        try {
            return service.add().getUuid();
        } catch (MessageException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, e.getMessage(), e);
        }
    }
}

