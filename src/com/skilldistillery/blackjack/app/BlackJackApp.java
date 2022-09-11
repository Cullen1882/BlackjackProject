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
	Scanner sc = new Scanner(System.in);
	BlackJackHand bJh = new BlackJackHand();

	public static void main(String[] args) {
		BlackJackApp bJa = new BlackJackApp();

		bJa.play();

	}

	public void play() {

		System.out.println("Do you want to play a game of Black Jack?");
		String userPlay = sc.next();
		boolean play = true;
		while (play) {
			if (!userPlay.equalsIgnoreCase("YES")) {
				play = false;

			} else {
				p1.clear();
				d.clear();

//			deal();
				int[] playerTotal = deal();

				playerChoice(playerTotal);
				dealerPlay(playerTotal);
				compare(playerTotal);
				
			
				System.out.println("Do you want to play again?");
				String playAgain = sc.next();
				if (playAgain.equalsIgnoreCase("NO")) {
					play = false;
				}
			}

		}
	}

//	Scanner sc = new Scanner(System.in);
	Deck deck = new Deck();
	List<Card> p1 = new ArrayList<>();
	List<Card> d = new ArrayList<>();

	public int[] deal() {
		
		Player dealer = new Dealer();
		Player player = new Player();
//		bJh.clear();
		int totalValuePlay = 0;
		int totalValueDeal = 0;
		deck.shuffleDeck();
		for (int i = 0; i < 4; i++) {
			Card p = deck.dealCard();
			if (i == 0 || i == 2) {
				p1.add(p);
				totalValuePlay += p.getValue();

			} else if (i == 1 || i == 3) {

				d.add(p);
				totalValueDeal += p.getValue();
			}

		}
		System.out.println("Your hand is: \n" + p1 + " Hand total: " + totalValuePlay);
		System.out.println("Dealer shows: \n" + d.get(1));
		int[] handTotals = new int[2];
		handTotals[0] = totalValuePlay;
		handTotals[1] = totalValueDeal;
//		System.out.println(handTotals[0]);
//		System.out.println(handTotals[1]);
		return handTotals;
	}

	public int playerChoice(int[] playerTot) {
		System.out.println("Do you want to Hit or Stand?");
		String playerDec = sc.next();
		int[] playerTotals = playerTot;
		while (playerDec.equalsIgnoreCase("Hit")) {

				Card p = deck.dealCard();
				p1.add(p);
				playerTotals[0] += p.getValue();
				System.out.println("Your hand: " + p1 + playerTotals[0]);
				
			if(bJh.isBust(playerTotals)) {
				break;
			}else if (bJh.isBlackJack(playerTotals)) {
				break;
			}
			System.out.println("Do you want to Hit or Stand?");
			playerDec = sc.next();
		}return playerTotals[0];
	}
	public int dealerPlay(int [] dealerTot) {
//		System.out.println("Dealer shows: " + dealerTotal[1]);
		int [] dealerTotal = dealerTot;
		while(dealerTotal[1] < 17) {
			Card p = deck.dealCard();
			d.add(p);
			if (dealerTotal[1] > 21) {
				System.out.println("Dealer Busts");
				break;
			}
			else if (dealerTotal[1] == 21) {
				System.out.println("Dealer has BlackJack");
				break;
			}
			dealerTotal[1] += p.getValue();
			System.out.println("Dealer shows: " + dealerTotal[1]);
			
		}return dealerTotal[1];
	}
	public void compare(int[] totals) {
		if(totals[0] > totals[1]) {
			System.out.println("You win");
		}
		else if (totals[0] < totals[1] && totals[1] < 22) {
			System.out.println("Dealer wins");
		}
		else {
			System.out.println("Its a tie");
		}
	}
	
}
