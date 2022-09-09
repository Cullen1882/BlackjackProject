package com.skilldistillery.blackjack.entities;

public enum Suit {

	HEARTS("Hearts"),
	SPADES("Spades"),
	DIAMONDS("Diamonds"),
	CLUBS("Clubs");

private String name;

private Suit(String name) {
	this.name = name;
}

public String getSuit() {
	return name;
}
@Override
public String toString() {
	return name;
}



}














