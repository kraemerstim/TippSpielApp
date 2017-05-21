package de.kraemer.tim.tippspiel.repositories;

import org.springframework.data.repository.CrudRepository;

import de.kraemer.tim.tippspiel.Entities.Player;

public interface PlayerRepository extends CrudRepository<Player, Integer> {

}
