package org.ivankov.technosphere.project.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.ivankov.technosphere.project.model.Message;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.ivankov.technosphere.project.repository.MessageRepository;
import org.ivankov.technosphere.project.repository.PlayerRepository;

import java.lang.invoke.MethodHandles;
import java.util.Collection;

/**
 * @author Igor Ivankov
 */
@Api
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
            path = "send",
            method = RequestMethod.GET)
    @ApiOperation(value = "Send message")
    public void send(@RequestParam Long playerId, @RequestParam String messageString) {
        messageRepository.put(new Message(1, messageString, playerRepository.get(playerId)));
    }

    @RequestMapping(
            path = "messages",
            method = RequestMethod.GET)
    @ApiOperation(value = "Get all messages")
    public Collection<Message> messages() {
//        return messageRepository.getAll().stream().map(Message::getContent).collect(Collectors.toList());
        return messageRepository.getAll();
    }
}
