

public class WrongInput extends Exception{

	/**
	 * Custom exception handling class displaying 
	 * any invalid inputs the user may enter.
	 */
	
	public WrongInput(){
		super("Invalid character entered.");
	}
	
	/*
	 * Prints whatever error message the user wants 
	 */
	public WrongInput(String message){
		super(message);
	}
	
	
	/*
	 * Prints out of range message
	 * 
	 */
	public String printOutofRange(){
		
	 return "Your number is out of range. Please try again.";
		
	}
	
	
	
	/*
	 * Handle inputs here 
	 */
	public void printWrongInput(){
		 System.out.println("Please try again.");
	}
	
	
	
}
