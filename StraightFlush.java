public class StraightFlush extends HighCard{

	/**
	* Creates a Straight Flush hand
	* @param cards	rank sorted cards that make a Straight Flush hand
	*/
	public StraightFlush(Card[] cards){
		super(cards);
		this.type = Global.STRAIGHTFLUSH;
	}
}