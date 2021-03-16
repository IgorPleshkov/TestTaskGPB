package ru.example.optionals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.example.service.MessageService;

import java.time.LocalDateTime;

@EnableScheduling
@Component
public class Scheduler {

    private ApplicationContext context;

    @Autowired
    public Scheduler(ApplicationContext context) {
        this.context = context;
    }

    @Scheduled(fixedRate = 1000)
    public void start() {
        context.getBean(MessageService.class).updateMessage();
    }
}




