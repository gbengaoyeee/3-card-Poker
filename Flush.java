public class Flush extends HighCard{

	/**
	* Creates a Flush hand
	* @param cards	rank sorted cards that make a Flush hand
	*/
	public Flush(Card[] cards){	
		super(cards);
		this.type = Global.FLUSH;
		this.sortBySuit();
	}

	
	/**
	* Sorting cards by suits using Selection sort
	* @param cards the cards to be sorted by suits
	*/
	public void sortBySuit(){
		for(int i = 0; i < this.cards.length-1; i++){
			for(int j= i + 1; j < this.cards.length; j++){
				if(Global.suits.get(this.cards[j].suit) < Global.suits.get(this.cards[i].suit)){
					Card temp = this.cards[j];
					this.cards[j] = this.cards[i];
					this.cards[i] = temp;
				}
			}
		}
	}
}