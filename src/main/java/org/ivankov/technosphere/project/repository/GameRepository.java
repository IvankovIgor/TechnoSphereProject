package org.ivankov.technosphere.project.repository;

import org.ivankov.technosphere.project.model.Game;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Igor Ivankov
 */
@Repository
public interface GameRepository extends CrudRepository<Game, Long> {

    List<Game> findByName(String name);
}
