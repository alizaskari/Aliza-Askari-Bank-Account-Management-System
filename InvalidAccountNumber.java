/**
 * Aliza Askari
 * CSE017
 * ala326@lehigh.edu
 * 10/13/23
 * HW_5
 */
public class InvalidAccountNumber extends Exception{

    /**
     * This is our constructor with no params that invokes super
     * @param none
     * @return none
     */
    public InvalidAccountNumber(){
        super();
    }

    /**
     * This is our constructor which holds one param 
     * @param String message
     * @return nothing
     */
    public InvalidAccountNumber(String message){
        super(message);
    }
    
}
