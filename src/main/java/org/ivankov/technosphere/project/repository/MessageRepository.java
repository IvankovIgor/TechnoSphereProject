package org.ivankov.technosphere.project.repository;

import org.ivankov.technosphere.project.model.Message;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface MessageRepository {
    Collection<Message> getAll();
    void put(Message message);
}
