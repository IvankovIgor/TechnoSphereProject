package game;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.lang.invoke.MethodHandles;

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
            path = "list",
            method= RequestMethod.GET)
//            produces = MediaType.TEXT_PLAIN_VALUE)
    public Message list(@RequestParam(value="name", required=false, defaultValue="World") String name) {
        LOGGER.info("Games list request");
        return gameRepository.getMessage(name);
    }
}
