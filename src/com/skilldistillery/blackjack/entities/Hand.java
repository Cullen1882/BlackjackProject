package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.List;

public abstract class Hand {
	protected List<Card> hand;

	public abstract int getHandValue();

	public Hand() {
		hand = new ArrayList<>();
	}

	public void addCard(Card card) {
		hand.add(card);
	}

	public void clear() {
		
	}

	@Override
	public String toString() {
		return "Hand [hand=" + hand + "]";
	}
	
	

}
