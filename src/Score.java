
import java.util.ArrayList;

/**
 * This class keeps track of a player's score at the end of each game.
 * @author Jeremiah
 *
 */
public class Score {

	 private static ArrayList<Integer> scores = new ArrayList<Integer>();
	 private static ArrayList<String> names = new ArrayList<String>();
	private String name;
	 Score td;
	 /*
	 * default constructor 
	 */
	public Score(){
		
	
	
	}
	/*
	 * Sets the winner
	 * 
	 */
	public Score(String aname){
		this.name = aname;
		addTable();
	}
	
	
	
	/*
	 * sets table 
	 */
	
	
	public void setTable(String name){
		
		
		 //adds a new player and their score to the list. 
 	
		 td = new Score(name);
	   
		
		
	}
	
	
	public void addTable(){
	
		int counter = 0;
		for(String n:names ){
			//if name is found, update score
			if(n.equalsIgnoreCase(this.name)){
			int index =	names.indexOf(n);
			scores.set(index, scores.get(index)+1);
		    counter++;
			}
		
		}//else add name and score to list. 
		if(counter == 0){
		System.out.println("a new name has been added to the table.");
			names.add(this.name);
			scores.add(1);
		}
		
		
	}
	
	/*
	 * Gets the winner's name 
	 */
	public ArrayList<String>getNames(){
		
		return names;
	}
	
	/*
	 * gets the scores for the winner.
	 * 
	 */
	public ArrayList<Integer>getScores(){
	
		return scores;
	}

	/*
	 * @method - printScores
	 * Prints the score table. 
	 */
	
    public void printScores(){
    	System.out.println("       ***High Scores***   ");
    
    	System.out.println(td.getScores() + " " + td.getNames());
  }
    
    /*
     * Sorts the list 
     */
	
    public  void sort ( )
    {
         int i, next, first, tempScores; 
         String tempNames;
   	   
         
         for ( i = scores.size() - 1; i > 0; i --) 
         {
              first = 0;  
              for(next = 1; next<= i; next ++)  
              {
                   if( scores.get(next) < scores.get(first) )         
                     first = next;
              }
              
              tempScores = scores.get(first);  
            
              
     
              
              //save values for each column
   	       tempNames = names.get(first);
   	      tempScores = scores.get(first);

   	               //move values
   	     names.set(first, names.get(i));
   	      scores.set(first,scores.get(i));
   	               
   	               //move values
   	      names.set(i,tempNames);
   	      scores.set(i, tempScores);
          }           
    }
    


}
