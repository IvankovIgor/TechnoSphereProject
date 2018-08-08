package repository;

import model.Message;
import model.Player;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface MessageRepository {
    Collection<Message> getAll();
    void put(Message message);
}
