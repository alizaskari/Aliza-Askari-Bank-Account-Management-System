/**
 * Aliza Askari
 * CSE017
 * ala326@lehigh.edu
 * 10/13/23
 * HW_5
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
 * Modify the class BankManager to have three sorting operations: by balance, by owner, 
 * and by account number. The sort by balance should invoke sortAccounts with a comparator 
 * object that has the compare method order bank accounts based on the balance. The sort by 
 * owner should invoke sortAccounts with a comparator object that has the compare method order
 *  bank accounts based on the owner name. The sort by account number should invoke sortAccounts 
 *  with a comparator object that has the compare method order bank accounts based on the account number.
 */
public class BankManager{
	private ArrayList<BankAccount> accounts;
	/**
	 * This method will invoke sortAccounts with a comparator object that has 
	 * the compare method order bank accounts based on the balance. 
	 * @param none
	 * @return none (void)
	 */
	 public void sortByBalance() {
		 Comparator<BankAccount> byBalance = new ComparatorByBalance();
	        sortAccounts(byBalance);
	    }
	 
	 /**
	  * This method will invoke sortAccounts with a comparator object that has the
	  * compare method order bank accounts based on the owner name. 
	  * @param none
	  * @return none (void)
	  */
	 public void sortByOwner() {
	        Comparator<BankAccount> byOwner = new ComparatorByOwner();
	        sortAccounts(byOwner);
	    }
	 
	 /**
	  * This method will  invoke sortAccounts with a comparator object that has the 
	  * compare method order bank accounts based on the account number.
	  * @param none
	  * @return none (void)
	  */
	 public void sortByAccountNumber() {
	        Comparator<BankAccount> byNumber = new ComparatorByNumber();
	        sortAccounts(byNumber);
	    }
	 /**
	  * This method will invoke the method mergeSort, from the class Utility, with 
	  * two arguments: the array list accounts and the comparator object c.
	  * @param comparator
	  * @return none (void)
	  */
	 private void sortAccounts(Comparator<BankAccount> comparator) {
	        Collections.sort(accounts, comparator);
	    }
	/**
	 * main method
	 * @param args
	 * @returns nothing (void)
	 * @throws InvalidAccountNumber
	 */
    public static void main(String[] args) throws InvalidAccountNumber{
        Scanner kbd = new Scanner(System.in);
        Bank myBank = new Bank("accounts.txt");

        //String operation = 0; // arg[0]
        // long number = 0;
        // boolean sort = true;
        double amount = 0;
        boolean op2 = true;
        int choice = 0;

    do{
        System.out.println("\n Select an operation:");
        System.out.println("1: View accounts \n");
        System.out.println("2: Manage account \n");
        System.out.println("3: Sort accounts by  number \n");
        System.out.println("4: Sort accounts by balance \n");
        System.out.println("5: Sort accounts by owner \n");//this
        System.out.println("6: View closeable accounts \n");
        System.out.println("7: Exit");

        choice = kbd.nextInt();

        switch(choice){
            case 1: 
//                System.out.println(myBank.toString());
                printFileContents("accounts.txt");

                break;
            case 2:
                try{
                System.out.println("Enter an account number");
                long accNum = kbd.nextLong();
             
                    if(checkAccountNumber(accNum)){
                        BankAccount bank = myBank.findAccount(accNum);
                        System.out.println("Account found. Balance = " + bank.getBalance());
                        do{
                        System.out.println("\n Select an operation:");
                        System.out.println("1: Withdraw \n");
                        System.out.println("2: Deposit \n");
                        System.out.println("3: Monthly Interest \n");
                        System.out.println("4: Investment profit/loss \n");
                        System.out.println("5: Manage closeable accounts \n");
                        System.out.println("6: Exit \n");

                        kbd.nextLine();

                        int option = kbd.nextInt();

                        switch(option){
                            case 1:
                            System.out.print("Enter an amount: ");
                            amount = kbd.nextDouble();
                                if(bank.withdraw(amount)){
                                    System.out.println("Withdrawal Successful. The new balance: " + bank.getBalance());
                                } else{
                                    System.out.println("Withdrawal failed. The available balance: " + bank.getBalance());
                                }
                                break;
                            case 2:
                                System.out.print("Enter an amount: ");
                                amount = kbd.nextDouble();
                                bank.deposit(amount);
                                System.out.println("Deposit Successful. The new balance: " + bank.getBalance());
                                break; 
                            case 3:
                                if(bank != null){
                                    if(bank instanceof Savings){
                                        double interest = ((Savings)bank).getMonthlyInterest();
                                        System.out.print("Monthly interest = $" + String.format("%.2f", interest));
                                        System.out.println("The new balance: $" + String.format("%.2f", bank.getBalance()));
                                    }
                                    else{
                                        System.out.println("Cannot get the monthly interest. Not a savings account.");
                                    }
                                }
                                break;
                            case 4:
                                    if(bank instanceof Investment){
                                        double profit = ((Investment)bank).getProfitOrLoss();
                                        if (profit > 0){
                                            System.out.print("Loss = $" + String.format("%.2f", (profit)));
                                            System.out.println(". The new balance: $" + String.format("%.2f",bank.getBalance() ));
                                        }
                                        else{
                                            System.out.print("Profit = $" + String.format("%.2f", profit));
                                            System.out.println(". The new balance: $" + String.format("%.2f", bank.getBalance()));
                                        }
                                    }
                                    else{
                                        System.out.println("Cannot get the profit/loss. Not an investment account.");
                                    }
                                break;
                            case 5:
                            	myBank.checkCloseable();
                            	break;
                            case 6:
                                op2 = false;
                                break;
                            
                            }
                        }while(op2);
                    
                    }else{
                        System.out.println("Account not found.");
                    }
                }
                catch(InvalidAccountNumber e){
                    System.out.println(e.getMessage());
                }
                break;
                        
            case 3:
                myBank.sortAccounts(true);
                System.out.println(myBank.toString());
                break;
            case 4:
            
            case 5:
            	//Modify the class BankManager to add the operation sorting by owner. 
            	//For this operation, the main method should invoke the method mergeSort on the Bank instance to sort the bank accounts by owner.
            	myBank.mergeSort();
                System.out.println(myBank.toString());
                break;
            case 6: 
                myBank.sortAccounts(false);
                System.out.println(myBank.toString());
                break;
            case 7:
            	System.out.println("Goodbye.");
            	System.exit(choice);
                break;
            }
        }while(choice != 5);
    }
    /**
     * This method will print the file contents of account.txt to the console
     * @param filename
     * @return nothing (void)
     */
    public static void printFileContents(String filename) {
        File file = new File(filename);

        try {
            Scanner scanner = new Scanner(file);

            System.out.println("Contents of " + filename + ":");
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
        }
    }
    /**
     * this method will check account number of the bank accounts
     * @param long accNumber
     * @return true
     * @throws InvalidAccountNumber
     */
    public static boolean checkAccountNumber(long accNumber) throws InvalidAccountNumber{
        
        if(String.valueOf(accNumber).matches("\\d{10}")){
            return true;
        }else{
            throw new InvalidAccountNumber("Invalid account number. Account Number must be 10 digits long.");
        }
    }
}