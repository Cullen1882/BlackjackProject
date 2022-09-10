package com.skilldistillery.blackjack.entities;

public class BlackJackHand extends Hand {

	@Override
	public int getHandValue() {
		Rank[] cards = Rank.values();
		int sum = 0;
		for (Rank rank : cards) {
			
		}
		return 0;
	}
	public boolean isBlackJack() {
		boolean isBj = false;
		return isBj;
	}
	public boolean isBust() {
		boolean isBust = false;
		return isBust;
	}
	
}
