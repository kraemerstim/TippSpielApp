package de.kraemer.tim.tippspiel.repositories;

import org.springframework.data.repository.CrudRepository;

import de.kraemer.tim.tippspiel.Entities.Room;

public interface RoomRepository extends CrudRepository<Room, Integer> {

}
