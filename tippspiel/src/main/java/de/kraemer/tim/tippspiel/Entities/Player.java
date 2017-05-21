package de.kraemer.tim.tippspiel.Entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Player {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private int coins;
	
	@ManyToOne
	private Room room;
	
	@ManyToOne
	private Account account;
	
	@OneToMany(mappedBy="owner", cascade={CascadeType.ALL})
	private Set<Card> cards;
	
	public Player() {
		super();
		cards = new HashSet<Card>();
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public int getCoins() {
		return coins;
	}
	public void setCoins(int coins) {
		this.coins = coins;
	}
	public Room getRoom() {
		return room;
	}
	public void setRoom(Room room) {
		this.room = room;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}

	public Set<Card> getCards() {
		return cards;
	}
}
