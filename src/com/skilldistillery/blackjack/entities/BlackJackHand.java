package com.skilldistillery.blackjack.entities;

public class BlackJackHand extends Hand {


	@Override
	public int getHandValue() {
		int sum =0;
		for (Card card : hand) {
			sum += card.getValue();
			
		}
		return sum;
		
		
	}
	public boolean isBlackJack(Hand hand) {
		boolean isBj = false;
		if(hand.getHandValue() == 21) {
			isBj = true;
			System.out.println("BlackJack!");
		}
		return isBj;
	}
	public boolean isBust(Hand hand) {
		boolean isBust = false;
		
		if(hand.getHandValue() > 21) {
			isBust = true;
			System.out.println("Bust!");
		}
		return isBust;
	}
	
}
