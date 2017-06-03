package de.kraemer.tim.tippspiel.card;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import de.kraemer.tim.tippspiel.cardtype.CardType;
import de.kraemer.tim.tippspiel.player.Player;

@Entity
public class Card {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private String name;
	@ManyToOne
	private Player owner;
	
	@ManyToOne
	private CardType type;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Player getOwner() {
		return owner;
	}
	public void setOwner(Player owner) {
		this.owner = owner;
	}
	
//	@ManyToOne
//	public CardType getType() {
//		return type;
//	}
//	public void setType(CardType type) {
//		this.type = type;
//	}
	
}
