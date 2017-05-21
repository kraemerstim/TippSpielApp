package de.kraemer.tim.tippspiel.repositories;

import org.springframework.data.repository.CrudRepository;

import de.kraemer.tim.tippspiel.Entities.CardType;

public interface CardTypeRepository extends CrudRepository<CardType, Integer> {

}
