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
 * and define the method compare to order BankAccount objects based on the owner respectively.
 * @author askar
 *
 */
public class ComparatorByOwner implements Comparator<BankAccount> {
    @Override
    
    /**
     * This method uses compareTo to compare by owner
     * @param account 1
     * @param account2
     * @return account1.getOwner().compareTo(account2.getOwner());
     */
    public int compare(BankAccount account1, BankAccount account2) {
    	//comparing by owner
        return account1.getOwner().compareTo(account2.getOwner());
    }
}