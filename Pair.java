public class Pair extends HighCard{
	public int winningPair;
	public int otherCard;

	/**
	* Creates a Pair hand
	* @param cards	rank sorted cards that make a Pair hand
	*/
	public Pair(Card[] cards){
		super(cards);
		this.type = Global.PAIR;
		this.setWinningPair();
	}

	//Sets the winning pair rank
	private void setWinningPair(){
		//Assuming that this hand's card are already sorted and it is already a pair, check if the first two cards are the same
		//Then set the winning hand
		if(Global.ranks.get(this.cards[0].rank) == Global.ranks.get(this.cards[1].rank) ){ 
			this.winningPair = Global.ranks.get(this.cards[1].rank);
			this.otherCard = Global.ranks.get(this.cards[2].rank);
		}
		//If the first two cards are not the same then the next two must be same
		else{
			this.winningPair = Global.ranks.get(this.cards[1].rank);
			this.otherCard = Global.ranks.get(this.cards[0].rank);
		}
	}

}