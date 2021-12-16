package mainGame;

import java.util.Random;

public class Deck {
	
	private Cards[] deck;
	private int counter;
	private static final int NUMBER_OF_CARDS = 52; //The amount of cards in the Normal Deck
	private static final Random rand = new Random(); //the Cards will always be random
	
	
	//
	public Deck() {
		String[] faces = {"Ace","2","3","4","5","6","7","8","9","10","Jack","Queen","King"}; //All the cards in a normal deck 
		deck = new Cards[NUMBER_OF_CARDS];
		counter = 0;
		
		//A for loop to make sure that the length of the cards is always random 
		for(int i=0; i<deck.length; i++) {
			deck[i] = new Cards(faces[i%13]);
		}
	}
	
	//This line is making sure that all the players have shuffled cards and not repeated 
	public void Shuffle() {
		counter=0;
		
		for(int i=0; i<deck.length; i++) {
			int random = rand.nextInt(NUMBER_OF_CARDS);
			Cards t = deck[i];
			deck[i] = deck[random];
			deck[random]=t;
		}
	}
	
	//This batch of code is for the dealer to give the cards to the players 
	public String dealCards() {
		
		if(counter <deck.length) {
			return deck[counter++].toString();
		}
		else {
			return null;
		}
	}




}
