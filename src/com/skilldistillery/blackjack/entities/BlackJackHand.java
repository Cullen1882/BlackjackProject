package com.skilldistillery.blackjack.entities;

public class BlackJackHand extends Hand {

	@Override
	public int getHandValue() {
		int sum =0;
		for (Card card : hand) {
			sum += card.getValue();
			
		}
		return sum;
		
		
		
//		
//		Rank[] cards = Rank.values();
//		int sum = 0;
//		for (Rank rank : cards) {
//			sum += rank.getValue();
//		
//		}
//		return sum;
		
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
