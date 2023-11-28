/**
 * Aliza Askari
 * CSE017
 * ala326@lehigh.edu
 * 10/13/23
 * HW_5
 */
public class Investment extends BankAccount{ 
    private String type;

     /**
     * This is our Investment constructor with params
     * @param long number, String owner, double balance, String type
     * @return nothing
     */
    public Investment(long number, String owner, double balance, String type){
        super(number, owner, balance);
        this.type = type;
    }

    /**
     * This is our second constructor which has no params 
     * @param none
     * @return type
     */
    public String getType(){ 
        return type;
    }

    /**
     * This method is our setter method for type
     * @param String type
     * @return nothing (void)
     */
    public void setType(String type){
        this.type = type;
    }

    /**
     * This method gets profit or loss
     * @param none
     * @return balance*0.05
     */
    public double getProfitOrLoss(){
        double probNum = (Math.random());
        //double pol = (balance * 0.05);

        if(probNum < 0.5){
           return balance * 0.05 ;
        } else {
            return balance * 0.05;
        }
    }

    /**
     * @override 
     * This is our toString method 
     * @param none
     * return "Investment: " + super.toString() + " " + type ;
     */
    public String toString(){
        return "Investment: " + super.toString() + " " + type ;
    }
    /**
     * This is our compareTo method
     * @param o
     * @return 0;
     */
	public int compareTo(Closeable o) {
			return 0;
	}
    
}
