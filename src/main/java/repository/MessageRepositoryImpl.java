package repository;

import model.Message;
import model.Player;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

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
