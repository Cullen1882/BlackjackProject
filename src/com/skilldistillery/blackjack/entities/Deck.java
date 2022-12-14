package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

	private List<Card> cards;
	
	public Deck() {
		cards = createDeck();
	}
	
	public List<Card> createDeck(){
		List<Card> deck = new ArrayList<>();
		for (Suit s : Suit.values()) {
			for (Rank r : Rank.values()) {
				deck.add(new Card(r, s));
			}
		}
		return deck;
	}
	
	public int checkDeckSize() {
		return cards.size();
	}
	public Card dealCard() {
		return cards.remove(0);
	}
	public void shuffleDeck() {
		Collections.shuffle(cards);
	}
}
