/**
 * Aliza Askari
 * CSE017
 * ala326@lehigh.edu
 * 10/13/23
 * HW_5
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * public class bank
 * implements Closeable
 */
public class Bank implements Closeable{//The class Bank should be modified to implement the interface Closeable
    //use arrayList and modify all methods as needed
    private ArrayList<BankAccount> accounts;
    private int count = 0;
   
     /**
     * This is our default constructor which has been modified to use ArrayList
     * @param none
     * @return none
     * time complexity: O(1)
     */
    public Bank(){
        accounts = new ArrayList<>();
    }

    /**
     * This is our constructor which holds one param
     * This constructor throws InvalidAccountNumber
     * @param filename
     * @return none
     * time complexity: O(n) because we are adding values to the accounts array
     */
    public Bank(String filename) throws InvalidAccountNumber{
    	accounts = new ArrayList<>();
        count = readAccounts("accounts.txt");
    }
    
    //TODO Merge Sort
    /**
     * This method will split our array for the merge sort algorithm
     * @param accounts
     * @return none(void)
     * time complexity: O(n log n )-N
     */
    public static void mergeSort(ArrayList<BankAccount> accounts) {
    	 if (accounts.size() > 1) {
             int mid = accounts.size() / 2;
             ArrayList<BankAccount> firstHalf = new ArrayList<>(accounts.subList(0, mid));
             ArrayList<BankAccount> secondHalf = new ArrayList<>(accounts.subList(mid, accounts.size()));

             mergeSort(firstHalf);
             mergeSort(secondHalf);

             merge(firstHalf, secondHalf, accounts);
         }
    }

    //TODO Merge Sort
    /**
     * this method will use merge sort algorithm to sort bank account by owner
     * @param none(void)
     * @return none
     * time complexity O(n log n)
     */
    public void mergeSort() {
    	if (count > 1) {
            int mid = count / 2;
            ArrayList<BankAccount> firstHalf = new ArrayList<>(accounts.subList(0, mid));
            ArrayList<BankAccount> secondHalf = new ArrayList<>(accounts.subList(mid, count));

            mergeSort(firstHalf);
            mergeSort(secondHalf);

            merge(firstHalf, secondHalf, accounts);
        }
    }

    //TODO Merge
    /**
    * This method is our merge method whic will aid our merge sort algortithm
    * @param list
    * @param list1 
    * @param list2 
    * @return none (void)
    * time complexity: O(n log n)-N
    */ 
    public static void merge(ArrayList<BankAccount> list1, ArrayList<BankAccount> list2, ArrayList<BankAccount> list) {
    	 int list1Index = 0;
         int list2Index = 0;
         int listIndex = 0;

         while (list1Index < list1.size() && list2Index < list2.size()) {
             if (list1.get(list1Index).getOwner().compareTo(list2.get(list2Index).getOwner()) <= 0) {
                 list.set(listIndex++, list1.get(list1Index++));
             } else {
                 list.set(listIndex++, list2.get(list2Index++));
             }
         }

         while (list1Index < list1.size()) {
             list.set(listIndex++, list1.get(list1Index++));
         }

         while (list2Index<list2.size()) {
             list.set(listIndex++,list2.get(list2Index++));
         }
    }

    /**
     * This method will be implemented as our recursive method.
     * @param number
     * @param startIndex
     * @param endIndex
     * @return findAccountR(number, startIndex, midIndex - 1);/null
     * time complexity: O(log n)
     */
    //TODO RECURSION SOLUTION
    //public BankAccount findAccount(long number){
   // return findAccount(number, 0); }
    
    //helper method:
    //public BankAccount findAccount(long number, int index){
    // if(index<count){
    //if(accounts[index].getNumber()==number){
    // return accounts[index];}
    //else{
    //return findAccount(number, index+1);} (OR returns null)
    
    private BankAccount findAccountR(long number, int startIndex, int endIndex) {
        if (startIndex <= endIndex) {
            int midIndex = (startIndex + endIndex) / 2;
            BankAccount midAccount = accounts.get(midIndex);
            
            //to find the account 
            if (midAccount.getNumber() == number) {
                return midAccount;
               
            } else if (midAccount.getNumber() < number) {
                return findAccountR(number, midIndex + 1, endIndex);
            } else {
                return findAccountR(number, startIndex, midIndex - 1);
            }
        }
        return null;
    }

    /**
     * This method will read the bank account information
     * @param filename 
     * @return count or -1
     * time complexity: O(n)
     */
    private int readAccounts(String filename){
        int count = 0; //
        File file = new File(filename);

        try {
            Scanner readFile = new Scanner(file);
            while (readFile.hasNext()) {
                String input = readFile.nextLine();
                String jia[] = input.split("\\|");
                long number = Long.parseLong(jia[1]);
                String owner = jia[2];
                double balance = Double.parseDouble(jia[3]);
                if (jia[0].equals("Investment")) {
                    String type = jia[4];
                    Investment inv = new Investment(number, owner, balance, type);
                    accounts.add(inv);
                    count++;
                } else if (jia[0].equals("Savings")) {
                    double yInterest = Double.parseDouble(jia[4]);
                    Savings save = new Savings(number, owner, balance, yInterest);
                    accounts.add(save);
                    count++;
                } else {
                    Checking check = new Checking(number, owner, balance);
                    accounts.add(check);
                    count++;
                }
            }
            readFile.close();
            return count;
        } catch (FileNotFoundException e) {
            System.out.println("File does not exist");
            return -1;
        } catch (InvalidAccountNumber e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }

   /**
    * This method writes the list of bank accounts from array to the file
    * @param fileName
    * @return nothing (void)
    * time complexity: O(n)
    */
    public void saveAccount(String fileName){
        File file = new File(fileName);
        try{
            PrintWriter writeFile = new PrintWriter(file);
            //for arraysz
//            for(int i = 0; i<accounts.length; i++){
//                writeFile.print(accounts[i] + " "); 
//                writeFile.println();
            //for ArrayList
            for(BankAccount ba: accounts){
                writeFile.print(ba + " "); 
                writeFile.println();
            }
            writeFile.close();
        }
        catch(FileNotFoundException e){
            System.out.println("Unable to write to file");
        }
    }
    /**
     * Method saves the bank account ba in the array accounts at index count and increments count.
     * @param BankAccount ba
     * @return nothing (void)
     * time complexity: O(1)
     */
    public void addAccount(BankAccount ba) {
        accounts.add(ba);
    }

    /**
     * This method finds an account by number 
     * @param long number
     * @return null or accounts[i] 
     * time complexity: O(n)
     */
    public BankAccount findAccount(long number) {
        for (BankAccount account : accounts) {
            if (account.getNumber() == number) {
                return account;
            }
        }
        return null;
    }

    /**
     * This method sorts the array by balance
     * @param Comparator<BankAccount> c
     * @return void (nothing)
     * time complexity: O(n^2)
     */
    /**
     * The method sortAccounts accepts an object of type Comparator<BankAccount> c 
     * and should invoke the method mergeSort, from the class Utility, with two arguments: 
     * the array list accounts and the comparator object c.
     */
    public void sortAccounts(Comparator<BankAccount> c) {
        Utility.mergeSort(accounts, c);
    }
    /**
     * The method removeAccount takes a bank account number as a parameter. If a bank account with the account number is found, the method removes
     * the account from the array accounts, decrements count, and returns true. 
     * If no bank account matches the account number, the method returns false.
     * @param number
     * @return true or false
     * time complexity: O(n)
     */
    public boolean removeAccount(long number) {
        BankAccount accountToRemove = null;
        for (BankAccount account : accounts) {
            if (account.getNumber() == number) {
                accountToRemove = account;
                break;
            }
        }

        if (accountToRemove  !=null) {
            accounts.remove(accountToRemove);
            return true;
        }
        return false;
    }

    /**
     * //The method sortAccounts sorts the bank accounts by balance only
     *  and invokes java.util.Arrays.sort() to sort the array
     *  @param none
     *  @return nothing (void)
     *  time complexity: O(n log n)
     */
    public void sortAccounts(boolean numberOrBalance) {
        if (numberOrBalance) {
            Collections.sort(accounts, new ComparatorByNumber());
        } else {
            Collections.sort(accounts, new ComparatorByBalance());
        }
    }
    
    /**
     * This method will sort accounts using collections.sort
     * @param none
     * @return none (void)
     */
    public void sortAccounts() {
        Collections.sort(accounts, new ComparatorByBalance());
    }

    
    /**
     * This method returns an array of bank accounts that are closeable
     * @param none
     * @return Arrays.copyOf(closeableAccounts, closeableCount);
     * time complexity: O(n)
     */
    public ArrayList<BankAccount> getCloseableAccounts() {
        ArrayList<BankAccount> closeableAccounts = new ArrayList<>();
        for (BankAccount account : accounts) {
            if (account.isCloseable()) {
                closeableAccounts.add(account);
            }
        }
        return closeableAccounts;
    }
    
    /**
     * This method will check if the bank accounts can be closeable or not
     * @param none
     * @return totalFunds <= 2000000.0; or false
     * time complexity: O(n)
     */
    public boolean isCloseable() {//The method isCloseable returns true if the bank has less than 100 bank accounts and the total funds do not exceed $2,000,000.
    	 if (count < 100) {
             double totalFunds = getTotalFunds();
             return totalFunds <= 2000000.0;
         }
         return false;
     }
    /**
     * This method is a getter that gets the tot funds and returns it in the bank accounrs
     * @param none
     * @return totalFunds
     * time complexity: O(n)
     */
    public double getTotalFunds() {
    	double totalFunds = 0.0;
        for (BankAccount account:accounts) {
            totalFunds += account.getBalance();
        }
        return totalFunds;
    }
    
    /**
     * This method is a getter of the data member count
     * @param none
     * @return count
     * time complexity: O(1)
     */
    public int size() {
    	return accounts.size();
    }
    /**
     * This method checks for all closeable accounts 
     * @param none
     * @return none (void)
     * time complexity: O(n)
     */
    public void checkCloseable() {
        System.out.println("Closeable Accounts: ");
        for (BankAccount account : accounts) {
            if (account.isCloseable()) {
                System.out.println(account.getNumber() + " - Balance: $" + account.getBalance());
            	}
        }
        Scanner scanner = new Scanner(System.in);
        System.out.print("Remove closeable accounts?: ");
        String response = scanner.nextLine().trim().toLowerCase();

        if (response.equals("yes")) {
            ArrayList<BankAccount> accountsToRemove = new ArrayList<>();
            for (BankAccount account : accounts) {
                if (account.isCloseable()) {
                    accountsToRemove.add(account);
                }
            }
            accounts.removeAll(accountsToRemove);
            System.out.println("Removed closeable accounts successfully");
        } else {
            System.out.println("Unable to remove closeable accounts.");
        }
    }
     /**
     * This method is our toString which is an accessor for the BankAccount attributes
     * @param none
     * @return String.format("%-5s\t%-10s\t%-25s\t%-10s\t%-10s\n", "Type", "Number", "Owner", "Balance",
        "Interest/Type"); or out
     *time complexity: O(n)
     */
    public String toString() {
        String out = String.format("%-10s\t%-15s\t%-30s\t%-15s\t%-15s\n", "Type", "Number", "Owner", "Balance", "Interest/Type");
        for (BankAccount account : accounts) {
            out += account.toString() + "\n";
        }
        return out;
    }

}