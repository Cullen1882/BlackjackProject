package com.skilldistillery.blackjack.entities;


public class Player {
	private String name;
	private Hand hand;
	
	public Player() {
		
	}
	public Player(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	@Override
	public String toString() {
		return "Player [name=" + name + "]";
	}
	public void addCard(Card card) {
		hand.addCard(card);
	}
	
	
	
	
	
	
	
}
