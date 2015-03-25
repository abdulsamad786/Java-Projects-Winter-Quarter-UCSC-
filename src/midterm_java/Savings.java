package midterm_java;

//Saving is a subclass of the parent class Account
public class Savings extends Account 
{
	private double interest;
	
	//constructor with arguments
	public Savings(double init_balance, double interest)
	{
		super(init_balance);
		this.interest = interest;
	}

	public double getInterest()
	{
		return interest;
	}
	public String getFormattedNoInterest()
	{
		String noInterest = this.formatCurrency(0);
		return noInterest;
	}
	// to format Savings initial Balance
	public String getFormattedSavingsBalance()
	{
		return super.getFormattedInItBalance();
	
		
	}
	
	// returns Interest
	public double getSavingInterest()
	{
		double savingbalance = super.getInitBalance();
		
		double savinginterest =	interest * (savingbalance) ;
		savinginterest = savinginterest *100/100; // to get interest to 2 decimal places
		return savinginterest;
		
	}
	
	// to format Saving Interest into Currency ($)
	public String getFormattedSavingInterest()
	{
		String forminterest = this.formatCurrency(this.getSavingInterest());
		return forminterest;
	} 
	
	//
	public double getWithDrawSavings(double amount)
	{
		double withdrawamount;
		if (amount < init_balance)
		{
			withdrawamount = super.getWithDraw(amount);
			init_balance = withdrawamount;
		}
		else
		{
			System.out.println("Insufficient balance in the account. Please try again!");
		}
		
		return init_balance;
	}
	
	public double getDepositSavings(double amount)
	{
		double deposit_nodeduct  = super.getDeposit(amount);
		init_balance = deposit_nodeduct;
		return init_balance;
	}
	
	public String getAddInterestInSavingTransaction()
	{
		init_balance = init_balance + this.getSavingInterest();
		String formTransaction = this.formatCurrency(init_balance);
		return formTransaction;
	}
	
	
}
