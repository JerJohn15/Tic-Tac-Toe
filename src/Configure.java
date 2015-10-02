

import java.util.ArrayList;
import java.util.HashMap;

public abstract class Configure extends WrongInput{

	protected int choice1;
	protected int choice2;
	private String symbol;
	private int player;
	
	

/** 
 * 
 * This class sets the player's symbols, the winner,
 * and removes both player's choices. It also prints the game instructions
 * 	
 */
public Configure(){
	choice1= 0;
	choice2 = 0;

}


/*
 * sets the winner of the game
 */
public void setWinner(int number){

	if(number == 1){
		player = 1;
	}else{
		player = 2;
	}
}


public int getWinner(){
	return player;
}

/*
 * @method - clearStorage
 * @postcondition - Removes all 
 * choices from the storage array
 * 
 */

public void removeChoices(ArrayList<String>aList){
	
	aList.clear();
}


/*
 * Sets a player's symbol 
 */
  public void setPlayerSymbol(String[][]grid,int player){
        if(player == 1)
            grid[choice1][choice2] = "X";
        else
            grid[choice1][choice2] = "O";
    }

  
  
  /*
   * Sets a player's symbol 
   */
public void setSymbols(String asymbol){
	symbol = asymbol;
}


/*
 * gets a symbol 
 * 
 */

public String getSymbols(){
	return symbol;
}
  


/*
 * prints blank line 
 */
	public void printBlankLine(){
		
		System.out.println();
		
	}
	

	/*
	 * 
	 * Prints instructions 
	 */
	
	public void printInstructions(){
		//instructions kept just in case another player joins in. 
		 System.out.println("***Key***");
		System.out.println("User 1 -> Player 1  --> symbol -> X");
	    System.out.println("User 2 -> Player 2  --> symbol ->  O");
		
	    	 printBlankLine();
	  
	    	 System.out.println("***Instructions***");

	    	 printBlankLine();
	    	 
		 System.out.println("How-to-Move:\n");
		 System.out.println("For each turn the current player");
		 System.out.println("must enter a 0,1, or 2 on a row and column ");
		 System.out.println("to place their symbol on the grid (X or O). ");
	
		 printBlankLine();
		 
		 System.out.println("Determining a Winning Game:\n");
		 System.out.println("The game ends when a player has three ");
		 System.out.println("X's or O's in a row, column or diagonal (left or right)");
		 System.out.println("A tie is when the grid is filled and no winning move exists.");
		
		 printBlankLine();
		 
		 System.out.println("After a winner is determined, they are prompted with entering "
		 		+ "their name into a scoreboard which then gets displayed. ");
		 
		 printBlankLine();

	}
	
	
}
