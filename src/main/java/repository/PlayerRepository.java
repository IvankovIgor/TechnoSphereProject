package repository;

import model.Player;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.List;

public interface PlayerRepository {
    Collection<Player> getAll();
    void save(Player player);
    Player get(long id);
}
