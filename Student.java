package  classes;
import java.lang.*;
import interfaces.*;
public class Student extends Register implements ITransactions			//child class (we can create object of this class)
{													//a student is a registered user of our service (is a relation)
	private String name;
	private String id;

	public Student()
	{
		
	}

	public Student(String password,int balance,String name,String id)
	{
		super(password,balance);									//inherited data (password will be created by user.)
		this.id=id;
		this.name=name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public void setId(String id)
	{
		this.id = id;
	}
	
	public String getName()
	{
		return name;
	}

	public String getId()
	{
		return id;
	}
	
	public void showInfo()
	{
		System.out.println("Name: "+name);
		System.out.println("ID: "+id);
	}

	public void showAllRegisters()
	{
		System.out.println("Name: "+name);
		System.out.println("ID: "+id);
		System.out.println("Password: "+password);
		System.out.println("Balance: "+balance+"TK");
		System.out.println("**************************************************");
		System.out.println("The Service is now Activated for Mr."+name+"!\n");
	}
}