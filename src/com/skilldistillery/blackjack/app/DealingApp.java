package com.skilldistillery.blackjack.app;

import java.util.Scanner;

import com.skilldistillery.blackjack.entities.Deck;

public class DealingApp {

	public static void main(String[] args) {
		DealingApp dA = new DealingApp();
		
		dA.playGame();
	}
	public void playGame() {
		dealEm();
	}
	public void dealEm() {
		Deck deck = new Deck();
		Scanner scan = new Scanner(System.in);
		deck.shuffleDeck();
		System.out.println("How many cards?");
		int numCardsToDeal = scan.nextInt();
		
		int numCardsDealt = 0;
		
		while(numCardsDealt < numCardsToDeal) {
			System.out.print("Dealt " + deck.dealCard());
			System.out.println(deck.checkDeckSize() + "cards dealt");
			
			numCardsDealt++;
		}
	}

}
