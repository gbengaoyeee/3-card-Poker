public class ThreeOfAKind extends HighCard{

	/**
	* Creates a Three Of A Kind hand
	* @param cards	rank sorted cards that make a Three Of A Kind hand
	*/
	public ThreeOfAKind(Card[] cards){	
		super(cards);
		this.type = Global.THREEOFAKIND;
	}
}