import java.util.*;
import java.io.*;


/**
* Holds all of the global variables used in making the game
*/
public class Global{
	public static final String HIGHCARD = "HighCard";
	public static final String PAIR = "Pair";
	public static final String FLUSH = "Flush";
	public static final String STRAIGHT = "Straight";
	public static final String THREEOFAKIND = "ThreeOfAKind";
	public static final String STRAIGHTFLUSH = "StraightFlush";
	public static final int MAX_PLAYERS = 24;

	public static final Map<Character, Integer> suits = new HashMap<>(){{
		put('h', 1);
		put('d', 2);
		put('s', 3);
		put('c', 4);
	}};

	public static final Map<Character, Integer> ranks = new HashMap<>(){{
		put('2', 2);
		put('3', 3);
		put('4', 4);
		put('5', 5);
		put('6', 6);
		put('7', 7);
		put('8', 8);
		put('9', 9);
		put('T', 10);
		put('J', 11);
		put('Q', 12);
		put('K', 13);
		put('A', 14);
	}};

	public static final Map<String, Integer> hands = new HashMap<>(){{
		put(HIGHCARD, 1);
		put(PAIR, 2);
		put(FLUSH, 3);
		put(STRAIGHT, 4);
		put(THREEOFAKIND, 5);
		put(STRAIGHTFLUSH, 6);
	}};
}









