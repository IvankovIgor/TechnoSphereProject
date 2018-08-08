package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Igor Ivankov
 */
@Entity
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final long id;
    private final String content;
    private final Player author;

    public Message(long id, String content, Player author) {
        this.id = id;
        this.content = content;
        this.author = author;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public Player getAuthor() {
        return author;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Message))
            return false;
        return content.equals(((Message) obj).content) && id == ((Message) obj).id && author.equals(((Message) obj).author);
    }
}
