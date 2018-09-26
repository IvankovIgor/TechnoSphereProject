package org.ivankov.technosphere.project.repository;

import org.ivankov.technosphere.project.model.Message;
import org.springframework.stereotype.Repository;

import java.util.*;

/**
 * @author Igor Ivankov
 */
@Repository
public class MessageRepositoryImpl implements MessageRepository {
    private static ArrayList<Message> messages = new ArrayList<>();

    @Override
    public Collection<Message> getAll() {
        return messages;
    }

    @Override
    public void put(Message message) {
        messages.add(message);
    }
}
