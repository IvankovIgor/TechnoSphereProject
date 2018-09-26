package org.ivankov.technosphere.project.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
public class MessageRepositoryImplTest {
    @TestConfiguration
    static class MessageRepositoryImplTestContextConfiguration {
        @Bean
        public MessageRepository messageRepository() {
            return new MessageRepositoryImpl();
        }
    }

    @SuppressWarnings("SpringJavaAutowiredMembersInspection")
    @Autowired
    private MessageRepository messageRepository;

    @Test
    public void getMessage() {
//        Message expected = new Message(1, "hey hou lets go, Desire", author);
//        Message actual = messageRepository.getMessage("Desire");
//        assertEquals(expected, actual);
    }
}