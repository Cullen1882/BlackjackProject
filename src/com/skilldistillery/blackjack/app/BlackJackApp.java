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
import com.skilldistillery.blackjack.entities.Rank;

public class BlackJackApp {
	Scanner sc = new Scanner(System.in);
	BlackJackHand bJh = new BlackJackHand();
	Player dealer = new Dealer();
	Player player = new Player("player");
	Deck deck = new Deck();
	public static void main(String[] args) {
		BlackJackApp bJa = new BlackJackApp();

		bJa.play();

	}

	public void play() {

		System.out.println("Do you want to play a game of Black Jack? YES or NO: ");
		String userPlay = sc.next();
		boolean play = true;
		while (play) {
			if (!userPlay.equalsIgnoreCase("YES")) {
				play = false;

			} else {

//			deal();
				deal();

				playerChoice();
				dealerPlay();
				compare();
				
			
				System.out.println("Do you want to play again?");
				String playAgain = sc.next();
				if (playAgain.equalsIgnoreCase("NO")) {
					play = false;
				}
				else if (playAgain.equalsIgnoreCase("YES")) {
					player.getHand().clear();
					dealer.getHand().clear();
					
				}
			}

		}
	}

//	Scanner sc = new Scanner(System.in);
//	Deck deck = new Deck();
//	Hand new bj hand
//	List<Card> p1 = new ArrayList<>();
//	List<Card> d = new ArrayList<>();

	public void deal() {
//		bJh.clear();
//		int totalValuePlay = 0;
//		int totalValueDeal = 0;
		deck.shuffleDeck();
		for (int i = 0; i < 4; i++) {
			Card p = deck.dealCard();
//					((Dealer)dealer).dealCard(player);
			if (i == 0 || i == 2) {
//				((Dealer) dealer).dealCard(player);
				player.addCard(p);
//				totalValuePlay += p.getValue();
				
			} else if (i == 1 || i == 3) {
//				((Dealer) dealer).dealCard(dealer);

				dealer.addCard(p);
//				totalValueDeal += p.getValue();
			}

		}
		System.out.println("Your hand is: \n" + player.getHand() + " Hand total: " + player.getHand().getHandValue());
		System.out.println("Dealer shows: \n" + dealer.getHand());
//		int[] handTotals = new int[2];
//		handTotals[0] = totalValuePlay;
//		handTotals[1] = totalValueDeal;
//		System.out.println(handTotals[0]);
//		System.out.println(handTotals[1]);
//		return handTotals;
	}

	public void playerChoice() {
		System.out.println("Do you want to Hit or Stand?");
		String playerDec = sc.next();
//		int[] playerTotals = playerTot;
		while (playerDec.equalsIgnoreCase("Hit")) {

				Card p = ((Dealer)dealer).getDeck().dealCard();
				player.addCard(p);
//				playerTotals[0] += p.getValue();
				System.out.println("Your hand: " + player.getHand());
				
			if(bJh.isBust(player.getHand())) {
				break;
			}else if (bJh.isBlackJack(player.getHand())) {
				break;
			}
			System.out.println("Do you want to Hit or Stand?");
			playerDec = sc.next();
		}
//		return playerTotals[0];
	}
	public void dealerPlay() {
//		System.out.println("Dealer shows: " + dealerTotal[1]);
//		int [] dealerTotal = dealerTot;
		while(dealer.getHand().getHandValue() < 17) {
			Card p = ((Dealer)dealer).getDeck().dealCard();
			dealer.addCard(p);
			if (dealer.getHand().getHandValue() > 21) {
				System.out.println("Dealer Busts");
				break;
			}
			else if (dealer.getHand().getHandValue() == 21) {
				System.out.println("Dealer has BlackJack");
				break;
			}
//			dealer.getHand().getHandValue() += p.getValue();
			System.out.println("Dealer shows: " + dealer.getHand().getHandValue());
			
		}
	}
	public void compare() {
		if(player.getHand().getHandValue() > dealer.getHand().getHandValue()) {
			System.out.println("You win");
		}
		else if (player.getHand().getHandValue() < dealer.getHand().getHandValue() && dealer.getHand().getHandValue() < 22) {
			System.out.println("Dealer wins");
		}
		else {
			System.out.println("Its a tie");
		}
	}
	
}
