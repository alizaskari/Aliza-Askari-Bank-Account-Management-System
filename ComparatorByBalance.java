/**
 * Aliza Askari
 * CSE017
 * ala326@lehigh.edu
 * 10/13/23
 * HW_5
 */

import java.util.Comparator;

/**
 * This method implements the interface Comparator for type BankAccount 
 * and define the method compare to order BankAccount objects based on the balance respectively.
 * @author askar
 */
public class ComparatorByBalance implements Comparator<BankAccount> {
	
	/**
     * This method uses compareTo to compare by balance
     * @param account 1
     * @param account2
     * @return Double.compare(account1.getBalance(), account2.getBalance());
     */
    @Override
    public int compare(BankAccount account1, BankAccount account2) {
        return Double.compare(account1.getBalance(), account2.getBalance());
    }
}