package ru.example.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.example.entity.Message;
import org.springframework.data.repository.PagingAndSortingRepository;
import ru.example.entity.Status;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface MessageRepository extends PagingAndSortingRepository<Message, UUID> {
    @Query(value = "SELECT m FROM Message m WHERE m.status = :status1 OR m.status = :status2")
    List<Message> findByStatusMessage(@Param("status1") Status status1, @Param("status2") Status status2);
}

