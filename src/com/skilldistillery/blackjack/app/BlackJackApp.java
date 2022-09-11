package com.skilldistillery.blackjack.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.blackjack.entities.BlackJackHand;
import com.skilldistillery.blackjack.entities.Card;
import com.skilldistillery.blackjack.entities.Dealer;
import com.skilldistillery.blackjack.entities.Deck;
import com.skilldistillery.blackjack.entities.Hand;
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
	public int[] deal() {
		Player dealer = new Dealer();
		Player player = new Player();
		Deck deck = new Deck();
		List<Card> p1 = new ArrayList<>();
		List<Card> d = new ArrayList<>();
	      int totalValuePlay = 0;
	      int totalValueDeal = 0;
	      int [] handTotals = new int[2];
	      handTotals[0] = totalValuePlay;
	      handTotals[1] = totalValueDeal;
	      deck.shuffleDeck();
	      for(int i = 0; i < 4; i++) {
	        Card p = deck.dealCard();
	        if(i == 0 || i == 2) {
	        	p1.add(p);
	        	totalValuePlay += p.getValue();
	        	
	        }else if (i == 1 || i == 3){
	        	
	        	d.add(p);
	        	totalValueDeal += p.getValue();
	        }
	        
	      }
	      System.out.println("Your hand is: \n" + p1 + " Hand total: " + totalValuePlay);
	      System.out.println("Dealer shows: \n" + d.get(1));
	    return handTotals;
	}

}
