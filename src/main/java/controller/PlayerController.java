package controller;

import model.Player;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import repository.PlayerRepository;

import java.lang.invoke.MethodHandles;
import java.util.Collection;
import java.util.stream.Collectors;

/**
 * @author Igor Ivankov
 */
@RestController
@RequestMapping("/player")
public class PlayerController {
    private static final Logger LOGGER = LogManager.getLogger(MethodHandles.lookup().lookupClass());

    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerController(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @RequestMapping(
            path = "list",
            method = RequestMethod.GET)
//            produces = MediaType.TEXT_PLAIN_VALUE)
    public Collection<String> list(@RequestParam(value="name", required=false, defaultValue="World") String name) {
        LOGGER.info("Games list request");
        return playerRepository.getAll().stream().map(Player::getName).collect(Collectors.toList());
    }

    @RequestMapping(
            path = "login",
            method = RequestMethod.GET)
    public void say(@RequestParam String name) {
        playerRepository.save(new Player(name));
    }
}
