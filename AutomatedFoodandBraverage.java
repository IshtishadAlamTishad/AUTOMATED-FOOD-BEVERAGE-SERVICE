package classes;
import java.lang.*;
import interfaces.*;
import java.util.*;
public class AutomatedFoodandBraverage implements IStudents			//associated class of Student class implemented by IStudent
{												//every regestered student has a AutomatedFoodandBraverage service provider (has a relation)
	private Student students[]=new Student [10];

	public void insertStudent(Student s)						//implemented through IStudent
	{
		int flag=0;
		for(int i=0;i<students.length;i++)
		{
			if(students[i]==null)
			{
				students[i]=s;
				flag=1;
				break;
			}
		}
		
		if(flag==1)
		{
			System.out.println("Student Information Added!");
		}
		else
		{
			System.out.println("Student Can Not Register.");
		}
	}

	public void removeStudent(Student s)						//implemented through IStudent
	{
		int flag=0;
		for(int i=0; i<students.length; i++)
		{
			if(students[i] == s)
			{
				students[i] = null;
				flag=1;
				break;
			}
		}
		
		if(flag == 1)
		{
			System.out.println("Registration Cancelled!");
		}
		else
		{
			System.out.println("Try Again!");
		}
	}

	public void showAllStudents()								//implemented through IStudent
	{
		for(Student s : students)
		{
			if(s != null)
			{
				System.out.println("**************************************************");
				System.out.println("Student Name: "+ s.getName());
				System.out.println("Student ID: "+ s.getId());
				System.out.println("**************************************************");
				s.showAllRegisters();
			}
		}
	}

	public Student getStudent(String id)
	{
		Student s=null;
		for(int i=0; i<students.length; i++)
		{
			if(students[i]!=null)
			{
				if(students[i].getId().equals(id))
				{
					s=students[i];
					break;
				}
			}
		}
		
		if(s!=null)
		{
			System.out.println("Student is Registered.");
		}
		else
		{
			System.out.println("Student is Not Registered.");
		}
		return s;
	}
}