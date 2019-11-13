import java.util.*;
import java.io.*;

public class Card{
	public char rank, suit;

	/**
	* Creates a card
	* @param card a two character string where the first character is the card's rank and the second is the card's suit
	*/
	public Card(String card){
		this.rank = card.charAt(0);
		this.suit = card.charAt(1);
	}


	public String toString(){
		return ""+this.rank+this.suit;
	}
}