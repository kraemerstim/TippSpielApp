package de.kraemer.tim.tippspiel.repositories;

import org.springframework.data.repository.CrudRepository;

import de.kraemer.tim.tippspiel.Player;

public interface PlayerRepository extends CrudRepository<Player, Integer> {

}