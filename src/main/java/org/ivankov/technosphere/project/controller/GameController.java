package org.ivankov.technosphere.project.controller;

import com.google.common.collect.Lists;
import io.swagger.annotations.Api;
import org.ivankov.technosphere.project.model.Game;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.ivankov.technosphere.project.repository.GameRepository;

import java.lang.invoke.MethodHandles;
import java.util.Collection;
import java.util.stream.Collectors;

/**
 * @author Igor Ivankov
 */
@Api
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
