package Accountant;

import java.util.Scanner;
//day2

import BankingDao.BankingSys;
import BankingDao.BankingSysImp;

public class AccountantAcess {
	

	public static void main(String[] args) {
		Scanner sc= new Scanner (System.in);
		BankingSysImp ban= new BankingSysImp();
		

			System.out.println("Choose your profession ");
	    System.out.println("1.Customer");
		System.out.println("2.Accountant");
		
		int res=sc.nextInt();
		
		
		if(res==2) {
			
			System.out.println("Enter email id---");
			String email=sc.next();
			System.out.println("Enter pass---");
			int pass=sc.nextInt();
			ban.loginCus(email, pass);
			
			while(ban.getFlag()) {
				System.out.println("Enter you choice----");
				System.out.println("1.Transfer money to another account");
				System.out.println("2.Show history");
				System.out.println("3.Exit");
				
				int choice=sc.nextInt();
				
				if(choice==1) {
					System.out.println("Enter the account no. in which you want to transfer the money");
					int act2=sc.nextInt();
					System.out.println("Enter the amount");
					int mon=sc.nextInt();
					ban.withdrwal(ban.getAct(), mon);
					ban.deposit(act2, mon);
					
					
					
				}
				else if(choice==2) {
					//System.out.println(ban.getAct());
					ban.showhis(ban.getAct());
				}
				else if(choice==3)break;
				else System.out.println("Invalid choice please select valid choice");
				
				
			}
		
			
			
		}
		else if(res==1) {

		System.out.println("Enter email id : ");
		String email=sc.next();
		System.out.println("Enter password : ");
		int pass=sc.nextInt();
		ban.checkAct(email,pass);
		
		
		while(ban.getFlag()) {
			
	    System.out.println("Enter your choice: ");
		System.out.println("***************************");
		System.out.println("1.Adding new customer");
		System.out.println("2.Editing existing account");
		System.out.println("3.Remove existing account");
		System.out.println("4.Viewing particular account detai by giving account number");
		System.out.println("5.Viewing all accounts");
		System.out.println("6. deposit or withdrawl");
		System.out.println("7.Exit");
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
	System.out.println("Set Customer Password : ");
	int ps=sc.nextInt();
	System.out.println("Set Customer Balance : ");
	int bal=sc.nextInt();
	ban.insertCus(act, name, emai, ps, bal);
	

}

//day3
else if(choice==2) {
	
	System.out.println("Give the account number of person which you want to edit");
	int actNo=sc.nextInt();
	System.out.println("What you want to change-----");
	
	System.out.println("1.Customer name");
//	sc.nextLine();
//	String name=sc.nextLine();
	System.out.println("2.Customer email----");
//	String em=sc.next();
	
	System.out.println("3.Customer pass");
	
	int option=sc.nextInt();
	if(option ==1) {
		System.out.println("Enter new name====");
		sc.nextLine();
		String naam=sc.nextLine();
		ban.editName(actNo, naam);
	}
	else if(option==2) {
		System.out.println("Enter new email====");
		sc.nextLine();
		String naam=sc.nextLine();
		ban.editEmail(actNo, naam);
		
	}else if(option==3){
		System.out.println("Enter new pass====");
	
		int naam=sc.nextInt();
		ban.editpass(actNo, naam);
		
	}
	else System.out.println("Please enter correct option");
	
	
}
else if(choice==3) {
	System.out.println("Enter the account number of customer which you want to delete");
	int act=sc.nextInt();
	ban.deleteRecord(act);
	
}
else if(choice==4) {
	System.out.println("Enter the account number of customer which you want to see the detail");
	int act=sc.nextInt();
	ban.displayPerticular(act);
	
}
else if(choice==5)ban.displayAll();
	
else if(choice==6) {
	System.out.println("1.for deposit");
	System.out.println("2.for withdrawl");
	
	int ch=sc.nextInt();
	
	if(ch==1) {
		System.out.println("Enter account number---");
		int act=sc.nextInt();
		System.out.println("Enter amount for deposit-------");
		int rupees=sc.nextInt();
		ban.deposit(act, rupees);
	}
	
  }	
}
		System.out.println("Thank you=======");
	}
}
}