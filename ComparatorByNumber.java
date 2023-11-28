/**
 * Aliza Askari
 * CSE017
 * ala326@lehigh.edu
 * 10/13/23
 * HW_5
 */
import java.util.Comparator;

/**
 * This method implement the interface Comparator for type BankAccount 
 * and defines the method compare to order BankAccount objects based on the account number respectively.
 * @author askar
 */
public class ComparatorByNumber implements Comparator<BankAccount> {
    
	/**
     * This method uses compareTo to compare by account number
     * @param account 1
     * @param account2
     * @return return Long.compare(account1.getNumber(), account2.getNumber());
     */
	@Override
    public int compare(BankAccount account1, BankAccount account2) {
        return Long.compare(account1.getNumber(), account2.getNumber());
    }
}