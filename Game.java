import java.util.*;

public class Game{

	/**
	* 3-card poker game
	* @param players players in the game
	*/
	private Player[] players;
	public Game(Player[] players){
		this.players = players;

	}

	/**
 	* Shows the winner(s) of the game.
 	* @param
 	* @return A string of space-seperated winners' id in increasing order.
 	*/
	public String winners(){	// Assume players' size is 1 or more
		HashSet<Integer> ws = new HashSet<>();
		Player currWinner = this.players[0];	//Assign winner to be the first player in the list(at least for now)
		ws.add(currWinner.id);

		for(int i = 1; i < this.players.length; i++){
			Player next = this.players[i];
			//Check if the next player's hand at index i has a higher hierarchy than current winner
			if (Global.hands.get(next.hand.type) > Global.hands.get(currWinner.hand.type)) {
				ws.clear();
				ws.add(next.id);
				currWinner = next;
			}

			if(currWinner.hand.type.equals(next.hand.type)){	//the player at index i has the same hand as the current winner
				if(currWinner.hand.type.equals(Global.PAIR)){	//If the player at index i has the same hand as the current winner and it is a pair
					currWinner =  handleSamePair(currWinner, next, ws);
				}
				else{
					currWinner =  handleSameExceptPair(currWinner, next, ws);
				}
			}
		}
		return displayWinners(ws);
	}

	/**
 	* Places the winner(s) of a game in a String format.
 	* @param ws A set of Player(winners) ids.
 	* @return A string of space-seperated winners' id in increasing order.
 	*/
	private String displayWinners(HashSet<Integer> ws){
		if(ws.size() < 1)
			return "";

		List<Integer> wl = new ArrayList<Integer>(ws);
		Collections.sort(wl);
		String ret = "";
		for(int i = 0; i < wl.size() - 1; i++){	//Adds every winner in the list apart from the last one
			ret += String.format("%d ", wl.get(i));
		}
		//Add the last winner
		return ret + wl.get(wl.size()-1);
	}

	/**
	* Handles the case of two players having same hand except the Pair hand.
	* Puts one player's id in the set if there is a winner or 
	* both players' id if both players' cards have the same ranks.
	* @param currWinner the current winner
	* @param next 		the player to compare with current winner
	* @param ws 		the set containing all winner(s)
	* @return 			the winner out the two players
	*/
	private Player handleSameExceptPair(Player currWinner, Player next, HashSet<Integer> ws){
		Hand p1h = currWinner.hand;
		Hand p2h = next.hand;

		//Comparing both highest ranks 
		if (p1h.highest > p2h.highest) {
			ws.clear();
			ws.add(currWinner.id);
			return currWinner;
		}
		else if(p2h.highest > p1h.highest){
			ws.clear();
			ws.add(next.id);
			return next;
		}

		//Comparing both second highest ranks 
		else if (p1h.secondHighest > p2h.secondHighest) {
			ws.clear();
			ws.add(currWinner.id);
			return currWinner;
		}
		else if (p2h.secondHighest > p1h.secondHighest){
			ws.clear();
			ws.add(next.id);
			return next;
		}

		//Comparing both third highest ranks
		else if (p1h.thirdHighest > p2h.thirdHighest) {
			ws.clear();
			ws.add(currWinner.id);
			return currWinner;
		}
		else if (p2h.thirdHighest > p1h.thirdHighest){
			ws.clear();
			ws.add(next.id);
			return next;
		}

		//At this point they both the same card ranks
		else{
			ws.add(currWinner.id);
			ws.add(next.id);
			return next;
		}
	}

	/**
	* Handles the case of two players having same hand(Pair).
	* Puts one player's id in the set if there is a winner or 
	* both players' id if both players' cards have the same ranks.
	* @param currWinner the current winner
	* @param next 		the player to compare with current winner
	* @param ws 		the set containing all winner(s)
	* @return 			the winner out the two players
	*/
	private Player handleSamePair(Player currWinner, Player next, HashSet<Integer> ws){
		Pair p1p = (Pair) currWinner.hand;
		Pair p2p = (Pair) next.hand;
		if (p1p.winningPair > p2p.winningPair) {	// if one has a bigger pair rank, clear the winning set and add just this winner
			ws.clear();
			ws.add(currWinner.id);
			return currWinner;
		}
		else if(p2p.winningPair > p1p.winningPair){
			ws.clear();
			ws.add(next.id);
			return next;
		}
		else{	//this case they both have same winning pair rank, so check who has higher remaining card
			if (p1p.otherCard > p2p.otherCard) {	// if one has a bigger remaining rank, clear the winning set and add just this winner
				ws.clear();
				ws.add(currWinner.id);
				return currWinner;
			}
			else if(p2p.otherCard > p1p.otherCard){
				ws.clear();
				ws.add(next.id);
				return next;

			}
			else{	//they both have same rank cards so add both to the winning set
				ws.add(currWinner.id);
				ws.add(next.id);
				return next;
			}
		}
	}
}









