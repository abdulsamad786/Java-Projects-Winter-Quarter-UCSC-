package midterm_java;


//import Validator;
//If any import Validator or import Savings or import Checking or import Account appears on screen , please discard/remove them
// Eclipse put them by default
import java.util.Scanner;

public class BankAccountApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String ch  = "y";
		int count_1= 0; //count for checking account
		int count_2 = 0; // count for saving account
		
		//Arguments values for Checking class constructor ($1000 initial balance , $1 fee)
		Checking c = new Checking(1000, 1.0);
		Savings  s = new Savings(1000, 0.01);
		//Arguments values for Savings class constructor ($1000 initial balance , 1% interest)
		
		//Printing Starting Balances
		System.out.println( "Welcome to the Account application \n"  + "\n"
							+ "Starting Balances\n" + "Checking: " + c.getFormattedCheckBalance() + "\n"
							+ "Saving:   " + s.getFormattedSavingsBalance() + "\n\n" 
							+ "Enter the transactions for the month \n");
		
		//While Loop to iterate withdraw and deposit transactions in checking and savings classes
		while(ch.equalsIgnoreCase("y"))
		{
			//User input in String from Validator class is used here to ask 
			//user to enter w for withdraw and d for deposit
			String wdType = Validator.getChoiceString(sc, "Withdrawal or deposit? (w/d): ", "w", "d");
			System.out.println();
			
			if (wdType.equalsIgnoreCase("w"))
				{
				//When the desired input is selected the module asks the user 
				//to choose either c for checking account and s for saving account			
					String accType = Validator.getChoiceString(
							sc, "Checking or savings? (c/s): " ,"c" , "s");
					
					if (accType.equalsIgnoreCase("c"))
						
					{ 
						//ask user to withdraw money > 0 but less than 1000
						System.out.println();
						double amount_withdrawn = Validator.getDoubleWithinRange(sc,"Amount?: ", 0 , 1000);
						
						//calls the method to withdraw
						System.out.println();
						double withdrawchecking =  c.getWithDrawChecking(amount_withdrawn);
						count_1++;
					}
						
								
					
					
					else if(accType.equalsIgnoreCase("s"))
					{
						//ask user to withdraw money > 0 but less than 1000
						System.out.println();
						double amount_withdrawnsaving = Validator.getDoubleWithinRange(sc, "Amount: ", 0, 1000);
							
						//calls the method to withdraw
						System.out.println();
						double amount_withdrawn_saving = s.getWithDrawSavings(amount_withdrawnsaving);
						count_2++;
						
					}
					
				else					
					System.out.println("Wrong Entry! Try again");

				}
			// if user choose to deposit, then following happens:
			else if (wdType.equalsIgnoreCase("d"))
				{
					String acc1  = Validator.getRequiredString(sc, "Checking or savings? (c/s): ");
											
						if(acc1.equalsIgnoreCase("s"))
						{
							System.out.println();
							
							double amount_deposit = Validator.getDouble(sc, "Amount?: ");
							
							// depositing money in savings account
							double amount_deposit_saving = s.getDepositSavings(amount_deposit);
							count_2++;
						}
						
						
						else if(acc1.equalsIgnoreCase("c"))
						{
							System.out.println();
							double amount_deposit_in_checking = Validator.getDouble(sc, "Amount: ");
							
							//depositing money in savings account			
							double amount_added_in_checking = c.getDepositChecking(amount_deposit_in_checking);
							
							count_1++;
						 
						}
					}
			else
			{
				 System.out.println("Try Again! Wrong entry");
			}
			//Asking user to continue in yes or no
			System.out.println();
			String cont =  Validator.getChoiceString(sc, "Continue (y/n)?: ", "y" , "n");
			System.out.println();
			
			if (cont.equalsIgnoreCase("y"))
			{
				System.out.println();
				continue;
			}
			else
				 //When 'n' is returned by user, it comes out of while loop and prints the following
			{
				//Combinations of counts are used to make different combinations of outputs
				if (count_1 == 0 && count_2 != 0 )
				{
					//if count_1 is 0 and count_2 ! = 0 prints the transactions (withdraw and deposit) of saving account/class only
					System.out.println("Monthly Payments and Fees\n"
							+ "Checking :		   " + c.getFormattedNoFee() + "\nSavings interest payment :  "  + s.getFormattedSavingInterest());
					
					System.out.println("\nFinal Balances" + "\nChecking: " + c.getFormattedCheckBalance() 
							+"\nSaving: " + s.getAddInterestInSavingTransaction());
					
				}
				
				else if (count_2 == 0 && count_1 !=0 )
				{
					//count_2 == 0 && count_1 !=0 prints the transactions (withdraw and deposit) of checking account/class only
					System.out.println("Monthly Payments \n"
							+ "Checking 		  : " + c.getFormattedCheckBalance() + "\nSavings interest payment : "  + s.getFormattedNoInterest());
					
					System.out.println("\nFinal Balances\n"
							+ "Checking :   	" + c.getFeeDeductedFromTransaction() + "\nSavings interest payment :  "  +  s.getFormattedSavingsBalance());
				}
				
				else 
				{
					//print the transactions of both (checking and savings) accounts 
					System.out.println("Monthly Payments and Fees\n"
							+ "Checking :		  " + c.getFormattedFee() + "\nSavings interest payment : "  + s.getFormattedSavingInterest());
				
						System.out.println("\nFinal Balances" + "\nChecking: " + c.getFeeDeductedFromTransaction() 
								+"\nSaving:  " + s.getAddInterestInSavingTransaction());
				}
				
				break;
				
			}
				
		}//while
	
	}//main

}//class
