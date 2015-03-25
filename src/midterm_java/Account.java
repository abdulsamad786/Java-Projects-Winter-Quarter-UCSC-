package midterm_java;

import java.text.NumberFormat;

public class Account 
{
	protected double init_balance; //default balance is protected so that it can be inherited by sub classes  i.e. Checking class and Savings class 
	private double amount; // amount to be deposited or withdrawn by the user
	private double withdraw;// to withdraw from account
	private double deposit; // to deposit in account
	
	//constructor
	public Account(double init_balance)
	{
		this.init_balance = init_balance;
			
	}
	//set amount
	public void setAmount(double amount)
	{
		this.amount = amount;
	}
	
	//get amount
	public double getAmount()
	 {
		 return amount;
	 }
	
	//get initial balance
	public double getInitBalance()
	 {
		 return init_balance;
	 }
	
	//Formatting initial balance into a currency
	public String getFormattedInItBalance()
	{
		String f_Init = this.formatCurrency(this.init_balance);
		return f_Init;
		
	}
	// a method that calls Currency instance from imported class NumberFormat 
	public String formatCurrency(double x) {
		
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		currency.setMaximumFractionDigits(2);
		return currency.format(x);
	}
	
	// set withdrawal 
	public void setWithDraw( double withdraw)
	{
		this.withdraw = withdraw;
	}
	

	//get withdrawal transaction / returns initial balance (which is subtracted from original balance) after amount is withdrawn 
	public double getWithDraw(double amount)
	{
		
		init_balance = init_balance - amount;
		return init_balance; 
	}
	
	//set Deposit 
	public void setDeposit( double deposit)
	{
		this.deposit = deposit;
	}
	
	//get Deposit transaction / returns initial balance (which is added to the original balance) when amount is withdrawn 
	public double getDeposit(double amount)
	{
		
		init_balance = init_balance + amount;
		return init_balance; 
	}
	

   
	
	
}     

