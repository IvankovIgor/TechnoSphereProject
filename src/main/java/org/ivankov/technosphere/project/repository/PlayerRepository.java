package org.ivankov.technosphere.project.repository;

import org.ivankov.technosphere.project.model.Player;

import java.util.Collection;

public interface PlayerRepository {
    Collection<Player> getAll();
    void save(Player player);
    Player get(long id);
}
