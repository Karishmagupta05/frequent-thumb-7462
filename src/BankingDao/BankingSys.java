package BankingDao;

public interface BankingSys {

	//boolean flag=false;
	abstract void insertCus(int cusId,String name,String cusEmail,int pass,int bal);
	
}
