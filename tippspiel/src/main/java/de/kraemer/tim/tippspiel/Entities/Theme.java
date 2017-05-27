package de.kraemer.tim.tippspiel.Entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Theme {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String description;
	private String title;
	
	@OneToMany(mappedBy="theme")
	private Set<Room> rooms;
	
	@OneToMany(mappedBy="theme")
	private Set<CardType> cardTypes;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Set<Room> getRooms() {
		return rooms;
	}
	public void setRooms(Set<Room> rooms) {
		this.rooms = rooms;
	}
	public Set<CardType> getCardTypes() {
		return cardTypes;
	}
	public void setCardTypes(Set<CardType> cardTypes) {
		this.cardTypes = cardTypes;
	}
}
