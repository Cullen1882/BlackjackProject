package com.skilldistillery.blackjack.app;

import java.util.Scanner;

import com.skilldistillery.blackjack.entities.BlackJackHand;
import com.skilldistillery.blackjack.entities.Deck;
import com.skilldistillery.blackjack.entities.Player;

public class BlackJackApp {

	public static void main(String[] args) {
		BlackJackApp bJa = new BlackJackApp();
		
		bJa.play();
		
		
	}
	public void play() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Do you want to play a game of Black Jack?");
		String userPlay = sc.next();
		boolean play = true;
		while(play) {
			if(!userPlay.equalsIgnoreCase("YES")) {
				play = false;
			
		}	else {
			
			deal();
			System.out.println("Do you want to play again?");
			String playAgain = sc.next();
			if(playAgain.equalsIgnoreCase("NO")) {
				play = false;
			}
		}
		
		}
	}
	public void deal() {
		Deck deck = new Deck();
		deck.shuffleDeck();
		Player dealer = new Player();
		Player player = new Player();
		
		
		System.out.println(deck.checkDeckSize());
	}

}
