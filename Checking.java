/**
 * Aliza Askari
 * CSE017
 * ala326@lehigh.edu
 * 10/6/23
 * HW_4
 */

public class Checking extends BankAccount {
    
     /**
     * this is our constructor which invludes three params 
     * @param long number, String owner, double balance
     * @return nothing
     */
    public Checking(long number, String owner, double balance){
        super(number, owner, balance);
    }

    /**
     * @override 
     * This is our toString method which formats our output
     * @param none
     * @return "Checking: " + super.toString();
     */
    public String toString(){
        return "Checking: " + super.toString();
    }
    /**
     * This is our compareTo method
     * @param BankAccount o
     * @return 0
     */
	@Override
	public int compareTo(BankAccount o) {
		return 0;
	}

	
}