package de.kraemer.tim.tippspiel.repositories;

import org.springframework.data.repository.CrudRepository;

import de.kraemer.tim.tippspiel.Entities.Card;

public interface CardRepository extends CrudRepository<Card, Integer> {

}
