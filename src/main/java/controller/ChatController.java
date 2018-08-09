package controller;

import model.Message;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import repository.MessageRepository;
import repository.PlayerRepository;

import java.lang.invoke.MethodHandles;
import java.util.Collection;
import java.util.stream.Collectors;

/**
 * @author Igor Ivankov
 */
@RestController
@RequestMapping("/chat")
public class ChatController {
    private static final Logger LOGGER = LogManager.getLogger(MethodHandles.lookup().lookupClass());

    private final MessageRepository messageRepository;
    private final PlayerRepository playerRepository;

    @Autowired
    public ChatController(MessageRepository messageRepository, PlayerRepository playerRepository) {
        this.messageRepository = messageRepository;
        this.playerRepository = playerRepository;
    }

    @RequestMapping(
            path = "say",
            method = RequestMethod.GET)
    public void say(@RequestParam Long playerId, @RequestParam String messageString) {
        messageRepository.put(new Message(1, messageString, playerRepository.get(playerId)));
    }

    @RequestMapping(
            path = "messages",
            method = RequestMethod.GET)
    public Collection<String> messages() {
        return messageRepository.getAll().stream().map(Message::getContent).collect(Collectors.toList());
    }
}
