/**
* An abstract class the parents all other Hand subclasses
*/
public abstract class Hand{	//Might implement sort strategy
	public String type;
	public int highest, secondHighest, thirdHighest;
	public Card[] cards;
	//Ac 4c 8c = A
	//Qh Ad Ks = Q
	//2h 6d As = A

	

	public String toString(){
		return this.cards[0].toString() + " " + this.cards[1].toString() + " " + this.cards[2].toString();
	}

}