package de.kraemer.tim.tippspiel.repositories;

import org.springframework.data.repository.CrudRepository;

import de.kraemer.tim.tippspiel.Entities.Theme;

public interface ThemeRepository extends CrudRepository<Theme, Integer> {

}
