package org.ivankov.technosphere.project.repository;

import org.ivankov.technosphere.project.model.Player;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;

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
