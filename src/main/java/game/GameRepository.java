package game;

import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author Igor Ivankov
 */
@Repository
public class GameRepository {
    private final AtomicLong counter = new AtomicLong();
    List<String> getAll() {
        return Arrays.asList("dsaf", "heyhey", "okeyaaaa");
    }
    Message getMessage(String name) {
        return new Message(counter.incrementAndGet(), "hey hou lets go, " + name);
    }
}
