package repository;

import model.Player;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

@Repository
public class PlayerRepositoryImpl implements PlayerRepository {
    private static HashMap<Long, Player> players = new HashMap<>();

    @Override
    public Collection<Player> getAll() {
//        try (Connection con = DbConnector.getConnection();
//            Statement stm = con.createStatement();) {
//        }
        return players.values();
    }

    @Override
    public void save(Player player) {
        players.put(player.getId(), player);
    }

    @Override
    public Player get(long id) {
        return players.get(id);
    }
}
