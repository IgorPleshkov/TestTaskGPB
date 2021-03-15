package ru.example.service;

import ru.example.entity.Message;
import ru.example.entity.Status;
import ru.example.exception.MessageException;
import ru.example.repository.MessageRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MessageService {

    @Getter
    private final MessageRepository repository;

    @Autowired
    public MessageService(MessageRepository repository) {
        this.repository = repository;
    }

    public Message add() {
        Message message = new Message();
        message.setStatus(Status.CREATED);
        message.setDateTime(LocalDateTime.now());
        return repository.save(message);
    }

    public Optional<Message> getByUUID(UUID uuid) {
        Optional<Message> optionalMessage = repository.findById(uuid);
        //if (optionalMessage.isEmpty()) throw new MessageException("Такой задачи нет");
        return optionalMessage;
    }

    public void updateMessage(){
        List<Message> messages = repository.findByStatusMessage(Status.CREATED, Status.RUNNING);
        if (messages.size() > 0){
            for (Message m:messages) {
                if (m.getStatus() == Status.CREATED) {
                    m.setStatus(Status.RUNNING);
                    m.setDateTime(LocalDateTime.now());
                    repository.save(m);
                } else if (m.getStatus() == Status.RUNNING && m.getDateTime().plusMinutes(2).isBefore(LocalDateTime.now())){
                    m.setStatus(Status.FINISHED);
                    m.setDateTime(LocalDateTime.now());
                    repository.save(m);
                }
            }
        }
    }
}
