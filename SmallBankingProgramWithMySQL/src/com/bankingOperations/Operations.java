package com.bankingOperations;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.sqlOps.AccountOperations;
import com.userAccount.UserAccount;
public class Operations
{
    private AccountOperations ao;
    private UserAccount ua = new UserAccount();
    Scanner scanner ;
    private void withdraw(float balance) throws InputMismatchException
    {
	System.out.println("Please enter the amount you want to withdraw");
	float withdrawAmount = scanner.nextFloat();
	System.out.println(ao.withdrawMoney(ua.getId(), withdrawAmount));
    }
    
    private void deposit(float balance) throws InputMismatchException
    {
	System.out.println("please enter the amount you want to depoist");
	float depositAmount = scanner.nextFloat();
	System.out.println(ao.depositMoney(ua.getId(), depositAmount));
    }
    
    private void showBalance()
    {
	ao=new AccountOperations();
	
	System.out.println("Your account balance is "+ao.showBalance(ua.getId()));
    }
    
    public void operationsMenu()
    {
	scanner = new Scanner(System.in);
	boolean continueLoop = true;
	while(continueLoop)
	{
	    System.out.println("Press 1 to check your balance"
	    	+ "\nPress 2 to withdraw cash"
	    	+ "\nPress 3 to deposit funds"
	    	+ "\nPress 4 to exit.");
	    try
	    {
		int choice=scanner.nextInt(16);
		switch(choice)
		{
	    		case 1:
	    		{
	    		    showBalance();
	    		    break;
	    		}
	    		case 2:
	    		{
	    		    withdraw(ua.getAccountBalance());
	    		    break;
	    		}
	    		case 3:
	    		{
	    		    deposit(ua.getAccountBalance());
	    		    break;
	    		}
	    		case 4:
	    		{
	    		    System.out.println("Goodbye!");
	    		    continueLoop = false;
	    		    break;
	    		}
	    		default:
	    		{
	    		    System.out.println("invalid choice, please try again");
	    		    break;
	    		}
		}
	    }
	    catch(InputMismatchException ime)
	    {
		System.out.println("Invalid Input");
		scanner.nextLine();
	    }
	    
	}
	
    }
}
