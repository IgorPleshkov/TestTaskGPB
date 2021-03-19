package ru.example.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class Message {

    @Id
    @Getter
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID uuid;

    @Getter
    @Setter
    @Enumerated(EnumType.STRING)
    private Status status;

    @Getter
    @Setter
    @Column(nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
    private LocalDateTime dateTime;
}



