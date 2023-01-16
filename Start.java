import java.lang.*;
import classes.*;
import interfaces.*;
import java.util.*;
import fileio.*;
public class Start
{
	public static void main(String args[])
	{
		boolean choice = true;
		Scanner sc = new Scanner(System.in);		//created an object reference of Scanner class
		Student s=new Student();			//created an object reference of child class
		AutomatedFoodandBraverage afb=new AutomatedFoodandBraverage();		//created an object reference of an associated class of the child class
		FileReadWrite frw=new FileReadWrite();		//created an object reference of an IO class

		while(choice)
		{
			System.out.println("Welcome to AIUB Automated Food & Braverage Service!\n");
			System.out.println("1. Read Terms And Condition.");
			System.out.println("2. Student Registration.");
			System.out.println("3. AIUB Automated Food & Braverage Service: ");
			System.out.println("4. Show All Registered Students				");
			System.out.println("5. EXIT\n");

			int first=0;		//expected ineger values
			boolean t1=false;
			
			while(!t1)		//while loop when true
			{
				try		//if user is not inputing an integer
				{
					System.out.print("	Please Select An Option: ");
					first=sc.nextInt();
					t1=true;
				}
				catch(InputMismatchException e)		//found runtime exception : InputMismatchException
				{
					String str1=sc.nextLine();
					System.out.println("	Invaild Input!\n");
				}
			}
			switch(first)
			{
				case 1:					
					System.out.println("Terms & Conditions:\n");
					System.out.println("1. This service is only for the students who register AIUB Automated Food & Beverage Service.");
					System.out.println("2. Registration cost is 4500tk per semester.");
					System.out.println("3. Registered person can take several meals in a day. (per meal cost will be deducted from 4500tk every time)");
					System.out.println("4. If registered person avoid a meal no cost will deduct from finaltial account.");
					System.out.println("5. Deduction will occur after taking any optional items.");
					System.out.println("6. A Registered student can spend all 4500tk. However if any balance left then that will be adjusted in the following semester.");
					System.out.println("7. If a registered student's balance is less than 100tk before completing the semester then, 500tk will be credited in the finaltial account.");			
					System.out.println("8. After completing a semester the students do not need to re-register for the AIUB Automated Food & Beverage Service.");
					System.out.println("9. A registered student can not cancel registration at any random time.");
					System.out.println("10. There will be 2 slots of registration or registration cancellation,\n 	a) at the begining of a semester,\n 	b) after the mid-terms.\n");
				break;	
				
				case 2:
					System.out.println("Welcome to Student Registration. \n");
					System.out.println("1. Register New Student.");
					System.out.println("2. Cancel Registration.");
					System.out.println("3. Back.\n");
					int second=0;
					boolean t2=false;
					while(!t2)
					try
					{
						System.out.print("Please Select An Option: ");
						second=sc.nextInt();
						t2=true;
					}
					catch(InputMismatchException e)
					{
						String str2=sc.nextLine();
						System.out.println("Invaild Input!\n");
					}

					switch(second)
					{
						case 1:
							s=new Student();
							System.out.println("Provide Student Information To Register.\n");
							System.out.print("Enter Student Name: ");
							String name = sc.next();
							System.out.print("Enter Student ID: ");
							String id=sc.next();
							System.out.print("Create A Password: ");
							String p=sc.next();
							s.setId(id);
							s.setName(name);
							s.setPassword(p);
							s.setBalance(4500);		//according to terms and condition the default balance value of a registered student is 4500TK
							afb.insertStudent(s);
							afb.getStudent(id);
							afb.showAllStudents();
						break;
						
						case 2:
							System.out.print("Enter Student ID: ");
							id=sc.next();
							afb.removeStudent(afb.getStudent(id));
							System.out.println("Mr. "+s.getName() +" Has Cancelled His Registration.\n");
							System.out.println("The Remaining Balance "+s.getBalance()+"TK Will Be Adjusted During Next Semester Course Registration.\n");
						break;
							
						case 3:
						break;
						
						default:
							System.out.println("Invalid Input.");
						break;
					}
				break;
										
				case 3:
					if(s.getId()!=null)
					{
						System.out.print("Enter Student ID: ");
						String id=sc.next();
						System.out.print("Enter Password: ");
						String p=sc.next();
						String id1=s.getId();
						String p1=s.getPassword();		//as child class has inherited the only abstract class
						int b1=s.getBalance();
						{
							if(id.equals(id1)&&p.equals(p1))
							{
								System.out.println("Food & Braverage Menu:\n");
								System.out.println("1. Breakfast Items.");
								System.out.println("2. Lunch Items.");
								System.out.println("3. Braverage Items.");
								System.out.println("4. Balance Information.");
								System.out.println("5. View Transaction Histrory.");
								System.out.println("6. Back.\n");
								int third=0;
								boolean t3=false;
								while(!t3)
								try
								{
									System.out.print("Please Select An Option: ");
									third=sc.nextInt();
									t3=true;
								}			
								catch(InputMismatchException e)
								{
									String str3=sc.nextLine();
									System.out.println("Invaild Input!\n");
								}

								switch(third)
								{
									case 1:
										System.out.println("You Have Chosen Breakfast Items. \n");
										System.out.println("1. Shingara.(10tk)");
										System.out.println("2. Cream Bread.(10tk)");
										System.out.println("3. Back.\n");
										int bfi=0;
										boolean t4=false;
										while(!t4)
										try
										{
											System.out.print("Please Select An Option: ");
											bfi=sc.nextInt();
											t4=true;
										}
										catch(InputMismatchException e)
										{
											String str4=sc.nextLine();
											System.out.println("Invaild Input!\n");
										}

										if(bfi==1)
										{
											afb.getStudent(id1).buyAnItem(10);
											frw.writeInFile("Deducted "+10+"TK for Buying Singara from: "+id);
											System.out.println("Please collect your Singara.\n");
										}
										else if(bfi==2)
										{
											afb.getStudent(id1).buyAnItem(10);
											frw.writeInFile("Deducted "+10+"TK for Buying Cream Bread from: "+id);
											System.out.println("Please collect your Cream Bread.\n");
										}
										else if(bfi==3)
										{
											continue;
										}
										else
										{
											System.out.println("Please Enter Correct Option!\n");
										}
									break;	
									
									case 2:
										System.out.print("You Have Chosen Lunch Items. \n");
										System.out.println("1. Plain Rice with Chicken Curry.(60tk)");
										System.out.println("2. Plain Rice with Fish Curry.(60tk)");
										System.out.println("3. Chicken Biriani.(70tk)");
										System.out.println("4. Egg Fried Rice with Fried Chicken.(80tk)");
										System.out.println("5. Back.\n");
										int li=0;
										boolean t5=false;
										while(!t5)
										try
										{
											System.out.print("Please Select An Option: ");
											li=sc.nextInt();
											t5=true;
										}
										catch(InputMismatchException e)
										{
											String str5=sc.nextLine();
											System.out.println("Invaild Input!\n");
										}

										if(li==1)
										{
											afb.getStudent(id1).buyAnItem(60);
											frw.writeInFile("Deducted "+60+"TK for Buying Plain Rice with Chicken Curry from: "+id);
											System.out.println("Please collect your Plain Rice with Chicken Curry.\n");
										}
										else if(li==2)
										{
											afb.getStudent(id1).buyAnItem(60);
											frw.writeInFile("Deducted "+60+"TK for Buying Plain Rice with Fish Curry from: "+id);
											System.out.println("Please collect your Plain Rice with Fish Curry.\n");
										}
										else if(li==3)
										{
											afb.getStudent(id1).buyAnItem(70);
											frw.writeInFile("Deducted "+70+"TK for Buying Chicken Biriani from: "+id);
											System.out.println("Please collect your Chicken Biriani.\n");
										}
										else if(li==4)
										{
											afb.getStudent(id1).buyAnItem(80);
											frw.writeInFile("Deducted "+80+"TK for Egg Fried Rice with Fried Chicken from: "+id);
											System.out.println("Please collect your Egg Fried Rice with Fried Chicken.\n");
										}
										else if(li==5)
										{
											break;
										}
										else
										{
											System.out.println("Please Enter Correct Option!");
										}
										System.out.println("");
									break;
									
									case 3:
										System.out.println("You Have Chosen beverage items.\n");
										System.out.println("1. Water.(15tk)");
										System.out.println("2. CocaCola.(20tk)");
										System.out.println("3. Back.\n");
										int bi=0;
										boolean t6=false;
										while(!t6)
										try
										{
											System.out.print("Please Select An Option: ");
											bi=sc.nextInt();
											t6=true;
										}
										catch(InputMismatchException e)
										{
											String str6=sc.nextLine();
											System.out.println("Invaild Input!\n");
										}

										if(bi==1)
										{
											afb.getStudent(id1).buyAnItem(15);
											frw.writeInFile("Deducted "+15+"TK for Water from: "+id);
											System.out.println("Please collect your Water.\n");
										}
										else if(bi==2)
										{
											afb.getStudent(id1).buyAnItem(20);
											frw.writeInFile("Deducted "+20+"TK for CocaCola from: "+id);
											System.out.println("Please collect your CocaCola.\n");
										}
										else if(bi==3)
										{
											break;
										}
										else
										{
											System.out.println("Please Enter Correct Option!");
										}
										System.out.println("");
									break;

									case 4:
										System.out.println("You Chose Balance Information.\n");
										System.out.println("1. Check Your Current Balance.");
										System.out.println("2. Request For Credit.\n");
										int bic=0;
										boolean t7=false;
										while(!t7)
										try
										{
											System.out.print("Please Select An Option: ");
											bic=sc.nextInt();
											t7=true;
										}
										catch(InputMismatchException e)
										{
											String str7=sc.nextLine();
											System.out.println("Invaild Input!\n");
										}

										if(bic==1)
										{
											System.out.println("Your Current Balance is: "+afb.getStudent(id1).getBalance()+"TK");
										}
										else if(bic==2)
										{
											afb.getStudent(id1).addMoney(500);
										}
										else
										{
											System.out.println("Invalid Input.");
										}
									break;

									case 5:
										frw.readFromFile();
									break;

									case 6:
										System.out.println("Have a nice day!");
									break;
																
									default:
										System.out.println("Invalid Input");
									break;
								}
							}
							else
							{
								System.out.println("Wrong Password!");
							}
						break;
						}
					}
					else
					{
						System.out.println("Please Register to AIUB Automated Food & Braverage Service First!\n");
					}
				break;
				
				case 4:
					System.out.println("This Students registered the Service ");
					afb.showAllStudents();
				break;					

				case 5:
					System.out.println("Thank you for Using AIUB Food & Braverage Service!\n");
					System.exit(0);
									
				default:				
					System.out.println("Invalid Input!\n");
				break;
			}
		}
	}
}