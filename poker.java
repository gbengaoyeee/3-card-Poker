import java.util.*;
import java.io.*;

public class poker{
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		if(sc.hasNextLine()){
			try{
				new SetupGame(sc);
				
			}catch (Exception e){
				System.out.println("Invalid input.");
			}
		}
	}

}










