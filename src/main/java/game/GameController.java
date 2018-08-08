package game;

import model.Message;
import model.Player;
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
@RequestMapping("/game")
public class GameController {
    private static final Logger LOGGER = LogManager.getLogger(MethodHandles.lookup().lookupClass());

    private final MessageRepository messageRepository;
    private final PlayerRepository playerRepository;

    @Autowired
    public GameController(MessageRepository messageRepository, PlayerRepository playerRepository) {
        this.messageRepository = messageRepository;
        this.playerRepository = playerRepository;
    }

    @RequestMapping(
            path = "player/list",
            method = RequestMethod.GET)
//            produces = MediaType.TEXT_PLAIN_VALUE)
    public Collection<String> list(@RequestParam(value="name", required=false, defaultValue="World") String name) {
        LOGGER.info("Games list request");
        return playerRepository.getAll().stream().map(Player::getName).collect(Collectors.toList());
    }

    @RequestMapping(
            path = "player/say",
            method = RequestMethod.GET)
    public void say(@RequestParam Long playerId, @RequestParam String messageString) {
        messageRepository.put(new Message(1, messageString, playerRepository.get(playerId)));
    }

    @RequestMapping(
            path = "player/login",
            method = RequestMethod.GET)
    public void say(@RequestParam String name) {
        playerRepository.save(new Player(name));
    }

    @RequestMapping(
            path = "player/messages",
            method = RequestMethod.GET)
    public Collection<String> messages() {
        return messageRepository.getAll().stream().map(Message::getContent).collect(Collectors.toList());
    }
}
