package de.kraemer.tim.tippspiel.repositories;

import org.springframework.data.repository.CrudRepository;

import de.kraemer.tim.tippspiel.Account;

public interface AccountRepository extends CrudRepository<Account, Integer> {

}
