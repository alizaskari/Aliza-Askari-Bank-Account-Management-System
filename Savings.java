/**
 * Aliza Askari
 * CSE017
 * ala326@lehigh.edu
 * 10/13/23
 * HW_5
 */
public class Savings extends BankAccount {
    private double YearlyInterestRate;
     /**
     * This is our constructor which holds 4 params
     * @param long number, String owner, double balalnce, double yInterestRate
     * @throws InvalidAccountNumber
     * @return nothing 
     */
    public Savings(long number, String owner, double balance, double yInterestRate) throws InvalidAccountNumber{
        super(number, owner, balance);
        this.YearlyInterestRate = yInterestRate;
    }

    /**
     * This is our getter method for the yearly interest rate
     * @param none 
     * @return YearlyInterestRate
     */
    public double getYearlyInterest(){ 
        return YearlyInterestRate;
    }

    /**
     * This is our setter method for yearly interest rate
     * @param double y
     * @return nothing (void)
     */
    public void setYearlyInterest(double y){
        YearlyInterestRate = y;
    }

     /**
     * This is our getter method for monthly interesr rate
     * @param none
     * @return interest
     */
    public double getMonthlyInterest(){ 

        double interest = balance * (YearlyInterestRate / 12)/100;
        balance += interest;
        return interest; 
    }

    /**
     * @override 
     * This is our toString method
     * @param none
     * return "Savings: " + super.toString() +  " " + YearlyInterestRate;
     */
    public String toString(){
        return "Savings: " + super.toString() +  " " + YearlyInterestRate;
    }
    
    /**
     * This is our compareTo method 
     * @param BankAccount o 
     * @return 0
     */
	@Override
	public int compareTo(BankAccount o) {
		// TODO Auto-generated method stub
		return 0;
	}

}