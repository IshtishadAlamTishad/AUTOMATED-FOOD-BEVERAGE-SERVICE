package  classes;
import java.lang.*;
import interfaces.*;
public abstract class Register implements ITransactions		//decleared as abstract (we can not create object of this class/ we do not need this class object to invoke any methods)
{											//implements interface ITransactions
	protected String password;
	protected int balance;
	public Register()
	{
		
	}
	public Register(String password,int balance)
	{
		this.password=password;
		this.balance=balance;
	}

	public void setPassword(String password)
	{
		this.password=password;
	}

	public void setBalance(int balance)
	{
		this.balance=balance;
	}

	public String getPassword()
	{
		return password;
	}

	public int getBalance()
	{
		return balance;
	}

	public abstract void showInfo();						//declared an abstract method (no body created as abstract method do not have a body)

	public void buyAnItem(int amount)						//method declared in interface ITransactions deduct money after any purchase
	{
		if(amount>0)
		{
			System.out.println("Previous Balance: "+balance+"TK");
			System.out.println("Purchase Cost: "+amount+"TK");
			balance -= amount;
			System.out.println("New Balance: "+balance+"TK");
		}
	}

	public void addMoney(int amount)
	{
		if(balance<100)
		{
			System.out.println("Your Request Has Been Accepted.");
			System.out.println("Previous Balance: "+balance+"TK");
			System.out.println("You Got Credit: "+amount+"TK");
			balance += amount;
			System.out.println("New Balance: "+balance+"TK");
		}
		else
		{
			System.out.println("Your Balance is not Less Than 100TK.");
		}
	}
}