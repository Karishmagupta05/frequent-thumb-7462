package BankingDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Dbc.Connections;

public class BankingSysImp implements BankingSys {
	 boolean flag=false;
	int count=0;
	
	
public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

public boolean getFlag() {
	return flag;
}
	
	public  void checkAct(String em,int ps) {
		count++;
		
		Connection con=Connections.getConnection();
		try {
			PreparedStatement act=con.prepareStatement("select * from Accountant");
			ResultSet rs= act.executeQuery();
			
			while(rs.next()) {
				
			String email=	rs.getString("email");
			
		int password=	rs.getInt("pass");
		
		
		if(em.equalsIgnoreCase(email)&& password==ps) {
			flag= true;
			System.out.println("login sucessful from accountant id ");
			
		}
		else System.out.println("invalid crediantials!!");
	}
		}
		catch(SQLException ex) {
			ex.getMessage();
	}
	
		
	}

	@Override
	public void insertCus(int cusId,String name, String cusEmail, int pass, int bal) {
		System.out.println(count);
	 if(flag) {
		 Connection con=Connections.getConnection();
		 try {
			PreparedStatement act=con.prepareStatement("insert into customer values(?,?,?,?,?)");
			act.setInt(1, cusId);
			act.setString(2, name);
			act.setString(3, cusEmail);
			act.setInt(4, pass);
			act.setInt(5, bal);
			
			int x=act.executeUpdate();
			System.out.println(x+"record added successfully");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 else System.out.println("kindly login first!!!!");
	 
		
	}

}
