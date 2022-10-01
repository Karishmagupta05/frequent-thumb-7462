package Accountant;

import java.util.Scanner;
import FunctionBanking.CustomerAccountantImp;

public class Main {
	

	public static void main(String[] args) {
		Scanner sc= new Scanner (System.in);
		CustomerAccountantImp objectBank= new CustomerAccountantImp();
		

		System.out.println("--Welcome to my Online Banking System--");
		System.out.println("Select 1 for Accountant Login");
		System.out.println("Select 2 for Customer Login");
		System.out.println("Select 3 for Exit");
    	System.out.println("---------------------------");



		int optionmain=sc.nextInt();
		
		 if(optionmain==1) {

		System.out.println("Enter email id : ");
		String email=sc.next();
		System.out.println("Enter password : ");
		int pass=sc.nextInt();
		objectBank.checkAct(email,pass);
		
		
		while(objectBank.getFlag()) {
		System.out.println("***************************");
	    System.out.println("Enter your choice: ");
		System.out.println("***************************");
    	System.out.println("1.Adding new account for customer");
		System.out.println("2.Editing already available account");
		System.out.println("3.Removing the account");
		System.out.println("4.Viewing particular account ");
		System.out.println("5.Viewing all the account details");
	    System.out.println("6. Deposit");
		System.out.println("7.Withdrawl");
		System.out.println("8.Exit");
		System.out.println("***************************");


        int choice=sc.nextInt();
        if(choice==7)break;
        else if(choice==1) {


	           System.out.println("Enter Account Number");
	           int act=sc.nextInt();

	           System.out.println("Enter Customer Name :  ");
	           sc.nextLine();
	           String name= sc.nextLine();
	
	           System.out.println("Enter Customer Email : ");
	           String emai=sc.next();

        	   System.out.println("Enter Customer Password : ");
	           int ps=sc.nextInt();

	           System.out.println("Enter Customer Balance : ");
	           int bal=sc.nextInt();

	           objectBank.insertCustomer(act, name, emai, ps, bal);
	

}


else if(choice==2) {
	
	System.out.println("Enter Account number For Edit :");
	int actNo=sc.nextInt();
	System.out.println("Choose Edit Options : ");
	
	System.out.println("1.Customer Name : ");

	System.out.println("2.Customer Email :");
	
	System.out.println("3.Customer Password :");


	int option=sc.nextInt();
	System.out.println("---------------------------");

	if(option ==1) {
		System.out.println("Enter New Customer Name : ");
		sc.nextLine();
		String naam=sc.nextLine();
		objectBank.editName(actNo, naam);
	}
	else if(option==2) {
		System.out.println("Enter New Customer Email : ");
		sc.nextLine();
		String naam=sc.nextLine();
		objectBank.editEmail(actNo, naam);
		
	}else if(option==3){
		System.out.println("Enter New Customer password : ");
	
		int naam=sc.nextInt();
		objectBank.editpass(actNo, naam);
		
	}
	else System.out.println("Invalid option , Please Enter correct option");
	
	
}
else if(choice==3) {
	System.out.println("For Delete-->");
	System.out.println("Enter Customer Account number: ");
	int act=sc.nextInt();
	objectBank.deleteRecord(act);
	
}
else if(choice==4) {
	System.out.println("For Perticular Detail-->");
	System.out.println("Enter customer Account number : ");
	int act=sc.nextInt();
	objectBank.displayPerticular(act);
	
}
else if(choice==5)objectBank.displayAll();
	
else if(choice==6) {
	System.out.println("------------------------");
	
		System.out.println("Enter Account number :");
		int act=sc.nextInt();
		System.out.println("Enter Amount for Deposit :");
		int rupees=sc.nextInt();
		objectBank.deposit(act, rupees);
	System.out.println("Successfully Deposited Money...");
	
}
else if(choice==7) {
	
	System.out.println("------------------");

		
		System.out.println("Enter account number : ");
		int act=sc.nextInt();
		System.out.println("Enter amount for withdrawl : ");
		int rupees=sc.nextInt();
		objectBank.withdrwal(act, rupees);
	System.out.println("Successfully Withdrawl Money...");
	
}
		// System.out.println("Thanks you for Choosing us...");
	}
		 }
else if(optionmain==2) {
				
				System.out.println("Enter Your Email Id : ");
				String email=sc.next();
				System.out.println("Enter Your password : ");
				int pass=sc.nextInt();
				objectBank.loginCustomer(email, pass);
				
				while(objectBank.getFlag()) {
					System.out.println("Please Select For ");
					System.out.println("1.Transfer Money");
					System.out.println("2.Show History");
					System.out.println("3.For Exit Account");
					
					int choice=sc.nextInt();

			
					if(choice==1) {
						System.out.println("Enter the Account no.");
						int act2=sc.nextInt();
						System.out.println("Enter the Amount");
						int mon=sc.nextInt();
						objectBank.withdrwal(objectBank.getAct(), mon);
						objectBank.deposit(act2, mon);
						
						
						
					}
				
					
					else if(choice==2) {

						objectBank.showtrans(objectBank.getAct());
					}
					else if(choice==3)
						{ 
						System.out.println("Thanks you for Choosing us...");
						break;
						}
					else System.out.println("Invalid Choice");
					
					
				}
			
				
				
			}
		 else if(optionmain==3) {
	   
	   System.out.println("Thanks you for Choosing us...");
	   
             }
		else System.out.println("Invalid choice , Please Enter Correct Choice..");
		


}
}