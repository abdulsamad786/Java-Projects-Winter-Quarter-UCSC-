package midterm_java;

//Checking is a subclass of the parent class Account
public class Checking extends Account
{
	private double fee; // fee to deducted from checking account after a transaction
	
	//constructor with arguments
	public Checking(double init_balance, double fee) 
	{
		super(init_balance); // calling constructor of parent class account
		this.fee = fee; 
	}	
	
	
	// returning fee
	public double getFee()
	{
		return fee;
	}
	
	// returning formattedFee
	public String getFormattedFee()
	{
		String formFee = this.formatCurrency(this.getFee());
		return formFee;
	}
	// returning Fee = $0.00
	public String getFormattedNoFee()
	{
		String noFee = this.formatCurrency(0);
		return noFee;
	}
	//returning formatted initial balance in the checking account
	public String getFormattedCheckBalance()
	{
		String s =  super.getFormattedInItBalance();
		return s;
		
	}
	
	
	// inheriting formatCurrency from Account parent class to checking subclass
	public String formatCurrency(double x)
	{
		return super.formatCurrency(x);
	}
	
	// withdrawing money from checking class
	public double getWithDrawChecking(double amount)
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
	
	//  depositing money to the checking class
	public double getDepositChecking(double amount)
	{
			double deposit_nodeduct  = super.getDeposit(amount);
			init_balance = deposit_nodeduct;
			return init_balance;
		}
	
	// deducting fee after the transaction
	public String getFeeDeductedFromTransaction()
	{
			init_balance -= fee;
			String formTransaction = this.formatCurrency(init_balance);
			return formTransaction;
	}
		
		
}

