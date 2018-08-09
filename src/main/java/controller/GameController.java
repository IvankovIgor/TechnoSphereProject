package controller;

import com.google.common.collect.Lists;
import model.Game;
import model.Message;
import model.Player;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import repository.GameRepository;
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

    private final GameRepository gameRepository;

    @Autowired
    public GameController(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @RequestMapping(
            path = "new",
            method = RequestMethod.GET)
    public void createGame(@RequestParam String gameName) {
        gameRepository.save(new Game(gameName));
    }

    @RequestMapping(
            path = "list",
            method = RequestMethod.GET)
    public Collection<String> gameList() {
        return Lists.newArrayList(gameRepository.findAll()).stream().map(Game::getName).collect(Collectors.toList());
    }
}
