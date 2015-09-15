

import java.util.ArrayList;

/**
 * This class handles all of the gameplay for 
 * the tic tac toe game.
 */
import java.util.InputMismatchException;
import java.util.Scanner;

public class Game extends Grid{
private int turns;
private Scanner keyboard;
private ArrayList<String> storage;


public Game(){

	
	keyboard = new Scanner(System.in);
	storage   = new ArrayList<String>();
}


/*
 * @method - isDraw
 * @precondition - Checks if game is a draw,
 *  if it has a full grid.
 *  @postcondition - returns false if no draw
 *  or grid isn't full. 
 */
public boolean hasDraw(){
		
	if(isfullGrid()==true){
		
		if(checkGrid().equals("Not a match")){
			setWinner(1);
			setWinner(2);
	//game is a draw	
			return true;
	}
			
	}
		return false;
	
	}
	
	
	

/*@method - hasWinner 
 *@precondition - Checks for
 *an individual winner if no draw.
 *@postcondition - returns true if winner
 *else returns false. 
 */
public boolean hasWinner(){
//if no draw game check to make sure there is no winner.

	if(hasDraw()== false){
		
			//check if player 1 has won
		if(checkGrid().equals("XXX")){
			setWinner(1);
			return true;

		
		//check if player 2 has won
	} if(checkGrid().equals("OOO")){
		setWinner(2);
		return true;
		
	}
		
		//has a draw game. 
	}else{
		return true;
	}
	
	
	return false;
	

	
}	
		
	
/*@method - declareWinner
 * Declares the winner of the game. 
 * @precondition - Declares a
 * winner, and sets a point the winner/s.
 * 
 */

public void declareWinner(){
	//if not a draw and has a winner
	if(hasDraw()==false && hasWinner()==true){
	
		System.out.println("Player " + getWinner() + " is the winner");
		//add one point just for winner
		score();
	//if no draw and no winner 
	}else{
		System.out.println("Draw Game. Both players win!");
	
		//add 1 point to each player
		setWinner(1);
		score();
		
		setWinner(2);
		score();
		
		
		
	}
	playAgain();
	
		
}


/*
 * @method -score
 * @Details - This method tallys a winning
 * players score
  (1) Asks for their name
  (2)places their score in a list. 
  (3)If a player has moved up in the list, 
  their method is sorted to effect the changes.
 */
public void score(){
Score endGame = new Score();
	String name = " ";
while(!name.matches("[a-zA-z]*")){
   keyboard = new Scanner(System.in);
	System.out.print("Player " + getWinner() + " enter your name: ");
	System.out.println(" (only letters.)");
	name = keyboard.nextLine();
}
	
	
	//adds name and score to table
	
    endGame.setTable(name);
    endGame.sort();
    endGame.printScores();
	

}

/*
 * @method - playAgain
 * @precondition - Asks if user wants another game
 * @postcondition - Ends game if no, restarts game if yes. 
 * 
 */
public void playAgain(){
	String selection ="";
    keyboard= new Scanner(System.in);
   do{
    	
	System.out.println("Play another game? (Enter Y or N)");
    selection = keyboard.nextLine();
  
    	
try{ 
    switch(selection){
    case "Y":
    case "y":
    	StartGame();
    	break;
    case "N":
    case "n":
    	System.out.print("Thanks for playing!");
    	System.out.println(" ending game...");
    	System.exit(0);
    	break;   	
    }
    throw new WrongInput();
    
}catch(WrongInput e){

  System.out.println(e.getMessage());
  
  printBlankLine();
 }
	  
       
    } while(!selection.matches("[yYnN]*"));
    
 	
}



/*
 * @method - move 
 * @precondition- Asks for
 * a move as long as there is no winner.
 * @postcondition - declares a winner if found. 
 */
public void move(){

	for(turns = 0;hasWinner()==false;turns++){
	//shows whos turn it is.
	 int who = whosTurn();	
	System.out.println("Turn: " + turns); 
	System.out.println("Player " + who + "'s turn");
	//selects a move 
    askMove();
 
   //set symbol
    setPlayerSymbol(grid,who);
    printGrid();
  
	}
	//declare a winner. 
	declareWinner();
}

/*
 *@method -askMove
 *@precondition - Asks the user's to enter in a move.
 * @postcondition - (1) Checks to make sure if move is valid.
 * (2) Checks for duplicate numbers entered.
 */
public void askMove(){
	String choices ="";
boolean validnumber = false;
	do{
		do{
		try{
		System.out.println("Please enter a row: (0, 1, or 2) ");
		choice1= keyboard.nextInt();
		System.out.println("Please enter a column: (0, 1, or 2) " +
				"");
	    choice2= keyboard.nextInt();
	    //convert to string 
		choices =  Integer.toString(choice1) 
 				          + Integer.toString(choice2);
		validnumber = true;
		}catch(InputMismatchException e){
			
			System.out.println(keyboard.next() + " was not valid input.");
	
		}
		
		}while(validnumber == false);

	}while(checkNumbers(choices)==false);
	    
 
}

/*
 * @method - checkNumbers
 * If number is within range and 
 * is not a duplicate return true.
 * else return false. 
 * 
 */

public boolean checkNumbers(String numbers){
	if(isRange() && isNotDup(numbers) == true){
		return true;
	}else{
		return false;
	}
	
}


/*@method - checkDuplicate
 * Checks if a player has entered in 
 * an already marked grid.
 */
public boolean isNotDup(String numbers){
   	//if selected numbers are not in array print false 
	try{
	if(!storage.contains(numbers)){
   		storage.add(numbers);  	
   		return true;
   		
	}else{
		
		throw new WrongInput("Move already used. Please try again.");

	}
	
	
	} catch(WrongInput e){
	
   	 		System.out.println(e.getMessage());
   	 		return false;
   	}
	 
   }


/*
 * @method - isRange
 * Checks if the choices are 
 *  0,1, or 2. 
 */

public boolean isRange(){
	//0 to 2
	try{
		
	if(choice1 < 3 && choice1 > -1){
	
		//return true;	
	if(choice2 < 3 && choice2 > -1){		
		return true;
	
	}
	}
		//0 to 2			
	
			throw new WrongInput();
			

	}catch(WrongInput e){
		
	System.out.println(printOutofRange());
     
	}	
		
 return false;
	
	
}
/*@method - whosTurn
 * Gets a players turn 
 */

public int whosTurn(){
	//player 2 if even
	if(turns %2 ==0){
		return 1;
	}
	else{
		//player one if odd
	return 2;
	
	}	
}


/*
 * @method - startGame
 * Starts the game.
 * 
 */
	public void StartGame(){
    	clearGrid();
    	removeChoices(storage);
    	
		System.out.println("Let's Play a game of Tic Tac Toe!");
		
		printBlankLine();
	 
	
	   printInstructions();
	   

	    printGrid();
	
	    printBlankLine();
    
	    move();
	   
	        
	}
}
	
	
