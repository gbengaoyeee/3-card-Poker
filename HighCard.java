public class HighCard extends Hand{

	/**
	* Creates a High Card hand
	* @param cards	rank sorted cards that make a High Card hand
	*/
	public HighCard(Card[] cards){	//Takes an array or sorted(By ranks) cards
		this.type = Global.HIGHCARD;
		this.cards = cards;
		this.highest = Global.ranks.get(this.cards[2].rank);
		this.secondHighest = Global.ranks.get(this.cards[1].rank);
		this.thirdHighest = Global.ranks.get(this.cards[0].rank);
	}

}