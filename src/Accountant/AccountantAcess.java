package Accountant;

import java.util.Scanner;
//day2

import BankingDao.BankingSys;
import BankingDao.BankingSysImp;

public class AccountantAcess {
	

	public static void main(String[] args) {
		Scanner sc= new Scanner (System.in);
		BankingSysImp ban= new BankingSysImp();
		
		System.out.println("Enter email id---");
		String email=sc.next();
		System.out.println("Enter pass---");
		int pass=sc.nextInt();
		ban.checkAct(email,pass);
		
		
		while(ban.getFlag()) {
	System.out.println("Enter your choice----");
		System.out.println("1.Adding new customer");
		System.out.println("2.Editing existing account");
		System.out.println("3.Remove existing account");
		System.out.println("4.Viewing particular account detai by giving account number");
		System.out.println("5.Viewing all accounts");
		System.out.println("6.Exit");
		
int choice=sc.nextInt();
if(choice==6)break;
else if(choice==1) {
	System.out.println("Enter account number");
	int act=sc.nextInt();
	System.out.println("Enter customer name-- ");
	sc.nextLine();
	String name= sc.nextLine();
	
	System.out.println("Enter customer email ---");
	String emai=sc.next();
	System.out.println("Set customer pass----");
	int ps=sc.nextInt();
	System.out.println("Set customer balance----");
	int bal=sc.nextInt();
	ban.insertCus(act, name, emai, ps, bal);
	

}

	
	
	}
		System.out.println("Thank you=======");
	}
}
