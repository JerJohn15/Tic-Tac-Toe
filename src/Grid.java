

import java.util.Scanner;

/**
 * This class handles the grid creation and deletion, as well
 * as checking for a winning move on the grid.
 * @author Jeremiah
 *
 */
public class Grid extends Configure
{
	
protected String[][]grid;



	public Grid(){
	
		grid = new String[3][3];
	
	}
	


	/*
	 * Clears the grid 
	 */
	public void clearGrid(){
		 for(int row=0 ; row<3 ; row++){
			 for(int column=0 ; column<3 ; column++){
				 grid[row][column]=" ";
			 }
	               
		 }
	            
	}
	

	/*
	 *Prints the grid.
	 * 
	 */
	
	public void printGrid(){
		for(int row=0 ; row<3 ; row++){
			for(int col=0 ; col<3 ; col++){
			
				if(grid[row][col]==null){
			    System.out.print("  ");
			}else{
				//prints x and o
				System.out.print(grid[row][col]);
			
			}
	        
	        if(col==0 || col==1){
                System.out.print(" | ");
	        }
	        
	        
			}
			printBlankLine();
		}

	}
	
	

    /*
     * Checks a winning horizontal line
     */
    public String checkRow(){
        for(int row=0 ; row<3 ; row++){
        	//if a line has 3 X's player 1 wins
            if( (grid[row][0] + grid[row][1] + grid[row][2]).equals("XXX")){
            	return "XXX";
            }
            //player 2 wins if 3 O's are found.  
            else if( (grid[row][0] + grid[row][1] + grid[row][2]).equals("OOO"))
            {	

            	return "OOO";
            }   
        }
        
        return "Not a match";
                
    }
    /*
     * Checks a winning column
     */
    public String checkColumn(){
        for(int column=0 ; column<3 ; column++){
        	//if a line has 3 X's player 1 wins
            if( (grid[0][column] + grid[1][column] + grid[2][column]).equals("XXX"))
            return "XXX";
            
            	
        	//if a line has 3 O's player 2 wins
            if( (grid[0][column] + grid[1][column] + grid[2][column]).equals("OOO"))
             return "OOO";
            
            	
        }
        
        return "Not a match";
                
    }
    /*
     * Checks for a winning diagonal line 
     */
    public String checkDiagonal(){

    	//if a line has 3 X's, player 1 wins
        if( (grid[0][0] + grid[1][1] + grid[2][2]).equals("XXX"))
        	  return "XXX";
    
        //if a line has 3 O's, player 2 wins
        if((grid[0][0] + grid[1][1] + grid[2][2]).equals("OOO"))
        	  return "OOO";
    	
        //**reverse side**
    	//if a line has 3 X's player 1 wins
        if( (grid[0][2] + grid[1][1] + grid[2][0]).equals("XXX"))
        	  return "XXX";
    	
        //if a line has 3 O's player 2 wins
        if( (grid[0][2] + grid[1][1] + grid[2][0]).equals("OOO"))	
        	  return "OOO";
        
        return "Not a match";
    }

    /*
     * Checks if the board is full 
     * (1) If an empty position is detected
     * board is not yet full.
     *(2) Else board is full. 
     */
    public boolean isfullGrid(){
    	//if grid is full and not a match, bot
        for(int row=0 ; row<3 ; row++){
            for(int column=0 ; column<3 ; column++){
                //if entire grid is not full return false. 
            	if(!grid[row][column].matches("[XO]*"))
                 
                	return false;
                
            }
            }
        return true;
    }
    
  
    /*
     * @method - checkGrids
     * @precondition - Checks for diagonal, vertical, and horizontal grids
     * @postcondition  - If not a match then the player's symbol is 
     * set  and returned
     */
    public String checkGrid(){
    
         if(!checkRow().equals("Not a match")){
        	 setSymbols(checkRow());
    		return getSymbols();   	
         }
           	
         if(!checkColumn().equals("Not a match")){
        	 setSymbols(checkColumn());
        		return getSymbols();
         }
      
         
         if(!checkDiagonal().equals("Not a match")){
        	 setSymbols(checkDiagonal());
        		return getSymbols();
        }
   	          
    	return "Not a match";
    }

    
	
 
}