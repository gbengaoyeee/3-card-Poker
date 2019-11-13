import java.util.*;
import java.io.*;

public class Player{
	public int id;
	public Card[] cards = new Card[3];
	public Hand hand;

	/**
	* Creates a player with an id and cards
	* @param id_cards a String conatining a player's id, and three space-seperated two-characters representing the player's cards respectively
	*/
	public Player(String id_cards){
		String[] split = id_cards.split(" ");
		if(split.length == 4){
			this.id = Integer.parseInt(split[0]);
			this.cards[0] = new Card(split[1]);
			this.cards[1] = new Card(split[2]);
			this.cards[2] = new Card(split[3]);
			//Set Hand upon creation of Player
			this.hand = new HandFactory().makeHand(this.cards);
		}
	}


	public String toString(){
		return String.format("ID: %d\nCards: %s %s %s\nHand: %s", this.id, this.cards[0].toString(), 
																	this.cards[1].toString(), this.cards[2].toString(), this.hand.type); 
	}
}










