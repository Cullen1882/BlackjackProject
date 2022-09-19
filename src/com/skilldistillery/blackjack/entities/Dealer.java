package com.skilldistillery.blackjack.entities;

public class Dealer extends Player{
	private Deck deck;
	
	public Dealer() {
		deck = new Deck();
	}
	public void dealCard(Player player) {
		player.addCard(deck.dealCard());
		
	}
	public Deck getDeck() {
		return deck;
	}

}
//getter for deck