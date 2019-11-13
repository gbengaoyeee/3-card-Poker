public class Straight extends HighCard{

	/**
	* Creates a Straight hand
	* @param cards	rank sorted cards that make a Straight hand
	*/
	public Straight(Card[] cards){	//Takes an array or sorted(By ranks) cards
		super(cards);
		this.type = Global.STRAIGHT;
		//Handle if you have a run of A-2-3
		//Initially a 2-3-A
		this.handleStartA();
	}

	/*
		This tries to handle the case where there is a run of 2-3-A
		Highest card should be a 3
	*/
	private void handleStartA(){
		if(this.cards[2].rank == 'A' && this.cards[0].rank == '2'){
			Card temp = this.cards[2]; 		// A
			this.cards[2] = this.cards[0];	// 2-3-2
			this.cards[0] = temp;			// A-3-2
			temp = this.cards[2];
			this.cards[2] = this.cards[1];	// A-3-3
			this.cards[1] = temp;			// A-2-3

			// Reset the highest to lowest ranks
			this.highest = Global.ranks.get(this.cards[2].rank);
			this.secondHighest = Global.ranks.get(this.cards[1].rank);
			this.thirdHighest = Global.ranks.get(this.cards[0].rank);
		}
	}
}