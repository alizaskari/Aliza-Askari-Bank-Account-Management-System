/**
 * Aliza Askari
 * CSE017
 * ala326@lehigh.edu
 * 10/6/23
 * HW_4
 */
 /**
 * This abstract method will implement interface Comparable and closeable
 */
public abstract class BankAccount implements Comparable<BankAccount>, Closeable{ 
    
    private long number;
    private String owner;
    protected double balance;

    /**
     * This is our default constructor with params
     * @param long number, String owner, double balance
     * @return none
     */
    public BankAccount(long number, String owner, double balance){
        this.number  = number;
        this.owner = owner;
        this.balance = balance;

    }

    /**
     * this method gets the account number
     * @param none
     * @return number
     */
    public long getNumber(){ return number; }
    
    /**
     * This is our setter method for number
     * @param long number
     * @return none
     */
    public void setNumber(long number){}

    /**
     * This method is our getter method for owner
     * @param none
     * @return owner
     */
    public String getOwner(){return owner;}

    /**
     * This method is our getter for bank account balance
     * @param none
     * @return balance
     */
    public double getBalance(){return balance;}

    /**
     * This method lets user deposit money into account which changes the balance
     * @param double amount
     * @return nothing (void)
     */
    public void deposit(double amount){
        balance += amount;
    }

    /**
     * This method lets user withdraw money from the account
     * @param amount
     * @return true or false
     */
    public boolean withdraw(double amount){

        if( amount <= balance){
            balance -= amount;
            return true;
        }else{
            return false;
        }
    }
    /**
     * This method is our compareTo which orders the objects of the class BankAccount based on the balance.
     * @param BankAccount b
     * @return 1 or 0
     */
    @Override
    public int compareTo(BankAccount b) {
        if (this.balance < b.balance) {
            return -1;
        } else if (this.balance > b.balance) {
            return 1;
        }
        return 0;
    }
    /**
     * This method will check if the bank account is able to be closed
     * @param none
     * @return balance
     */
    public boolean isCloseable() {
    	return balance <200.0;//The method isCloseable should return true if the balance of the bank account is below $200.

    }

     /**
     * This method is an accessor for the BankAccount attributes
     * @param none
     * @return String.format("%-10d\t%-30s\t%-10.2f",
                              number, owner, balance);
     */
    public String toString(){
        return String.format("%-10d\t%-30s\t%-10.2f",
                              number, owner, balance);
     }

}