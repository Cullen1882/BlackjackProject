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
	public boolean isBlackJack(int[]playerTotal) {
		boolean isBj = false;
		int[] playTot = playerTotal;
		if(playTot[0] == 21) {
			isBj = true;
			System.out.println("BlackJack!");
		}
		return isBj;
	}
	public boolean isBust(int[] playerTotal) {
		boolean isBust = false;
		int[] playTot = playerTotal;
		if(playTot[0] > 21) {
			isBust = true;
			System.out.println("Bust!");
		}
		return isBust;
	}
	
}
