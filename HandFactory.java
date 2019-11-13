/**
* Design pattern that return different types of Hand 
* depending on the cards given
*/
public class HandFactory{

	/**
	* Creates a hand according to the card given
	* @param cards a player's card
	* @return a type of hand
	*/
	public Hand makeHand(Card[] cards){
		if(cards == null || cards.length == 0)
			return null;

		this.sort(cards);	// Sorts the given cards by ranks

		if(isStraightFlush(cards)){
			return new StraightFlush(cards);
		}

		if(isThreeOfAKind(cards)){
			return new ThreeOfAKind(cards);
		}

		if(isStraight(cards)){
			return new Straight(cards);
		}

		if(isFlush(cards)){	
			return new Flush(cards);
		}

		if(isPair(cards)){
			return new Pair(cards);
		}

		return new HighCard(cards);
	}

	/**
	* Checks if the given card is a Pair
	* @param cards a list of sorted(by ranks) cards
	* @return true if cards is a Pair, else false
	*/
	private boolean isPair(Card[] cards){
		return cards[0].rank == cards[1].rank || cards[1].rank == cards[2].rank;
	}

	/**
	* Checks if the given card is a Flush
	* @param cards a list of sorted(by ranks) cards
	* @return true if cards is a Flush, else false
	*/
	private boolean isFlush(Card[] cards){
		return cards[0].suit == cards[1].suit && cards[1].suit == cards[2].suit;
	}


	/**
	* Checks if the given card is a Straight
	* @param cards a list of sorted(by ranks) cards
	* @return true if cards is a Straight, else false
	*/
	private boolean isStraight(Card[] cards){
		// if Initially there is a case of 2-3-A or Q-K-A
		if( (cards[2].rank == 'A' && cards[1].rank == '3' && cards[0].rank == '2') || (cards[2].rank == 'A' && cards[1].rank == 'K' && cards[0].rank == 'Q') ){
			return true;
		}
		// if the ranks form n, n+1, n+2
		return (Global.ranks.get(cards[1].rank) == Global.ranks.get(cards[0].rank) + 1) &&  (Global.ranks.get(cards[2].rank) == Global.ranks.get(cards[0].rank) + 2);
	}


	/**
	* Checks if the given card is a Three Of A Kind
	* @param cards a list of sorted(by ranks) cards
	* @return true if cards is a Three Of A Kind, else false
	*/
	private boolean isThreeOfAKind(Card[] cards){
		return cards[0].rank == cards[1].rank && cards[1].rank == cards[2].rank;
	}


	/**
	* Checks if the given card is a Straight Flush
	* @param cards a list of sorted(by ranks) cards
	* @return true if cards is a Straight Flush, else false
	*/
	private boolean isStraightFlush(Card[] cards){
		return isStraight(cards) && isFlush(cards);
	}


	/**
	* Sorting cards by rank using Selection sort
	* @param cards the cards to be sorted by rank
	*/
	public void sort(Card[] cards){
		for(int i = 0; i < cards.length - 1; i++){
			for(int j = i + 1; j < cards.length; j++){
				if(Global.ranks.get(cards[j].rank) < Global.ranks.get(cards[i].rank)){
					Card temp = cards[j];
					cards[j] = cards[i];
					cards[i] = temp;
				}
			}
		}

	}
}