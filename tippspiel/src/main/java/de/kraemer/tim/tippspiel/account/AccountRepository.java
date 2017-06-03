package de.kraemer.tim.tippspiel.account;

import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, Integer> {
	Account findFirstByUsername(String username);
}
