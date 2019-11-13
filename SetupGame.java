import java.util.*;

public class SetupGame{

	/**
	* Collects inputs sets up the 3-card poker game
	* @param sc a standard input Scanner that retrives input from the user
	*/
	public SetupGame(Scanner sc){
		//Get the number of players
		int num_of_players = Integer.parseInt(sc.nextLine());
		if (num_of_players > 0 && num_of_players < Global.MAX_PLAYERS) {	//Make sure the number of player is between 0 and MAX_PLAYERS
			Player[] players = new Player[num_of_players];
			int i = 0;
			while(i < num_of_players){	//Populates the players array
				String line = sc.nextLine();
				players[i++] = new Player(line);
			}
			//Start game
			Game game = new Game(players);
			System.out.println(game.winners());
		}
	}
}