package game;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.invoke.MethodHandles;

/**
 * @author Igor Ivankov
 */

@Controller
@RequestMapping("/game")
public class GameController {
    private static final Logger log = LogManager.getLogger(MethodHandles.lookup().lookupClass());

    @Autowired
    private GameRepository gameRepository;
}
