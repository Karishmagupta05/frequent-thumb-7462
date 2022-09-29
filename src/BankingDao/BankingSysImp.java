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
			System.out.println("Login Sucessful From Accountant id ");
			
		}
		else System.out.println("Invalid Crediantials!!");
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
@Override
	public void deleteRecord(int actNo) {
	
	Connection con=	Connections.getConnection();
	
	
	
 try {
	PreparedStatement ps= con.prepareStatement("delete from customer where actNo=?");
	ps.setInt(1, actNo);
	int x=ps.executeUpdate();
	System.out.println(x+" record deleted sucessfully");
} catch (SQLException e) {
	System.out.println("Record not found");
}
	
	
		
	}

	@Override
	public void displayPerticular(int actNo) {
		Connection con=	Connections.getConnection();
		try {
			PreparedStatement ps= con.prepareStatement("select * from customer where actNo=?");
			ps.setInt(1, actNo);
		ResultSet rs=	ps.executeQuery();
		display(rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void display(ResultSet rs) {
		if(rs==null)System.out.println("No record found");
		try {
			while(rs.next()) {
				System.out.println("customer account number- "+rs.getInt("actNo"));
				System.out.println("customer name- "+rs.getString("name"));
				System.out.println("customer email- "+rs.getString("email"));
				System.out.println("customer password- "+rs.getInt("pass"));
				System.out.println("customer balance - "+rs.getString("bal"));
				System.out.print("==========================================");
			}   
			    
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void displayAll() {
		// TODO Auto-generated method stub
		
		Connection con=	Connections.getConnection();
		try {
			PreparedStatement ps= con.prepareStatement("select * from customer ");
			//ps.setInt(1, actNo);
		ResultSet rs=	ps.executeQuery();
		display(rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void editName(int actNo, String name) {
		

		Connection con=	Connections.getConnection();
		try {
			PreparedStatement ps= con.prepareStatement("update customer set name=? where actNo=? ");
			ps.setString(1, name);
			ps.setInt(2, actNo);
		
		int x=ps.executeUpdate();
		if(x>0)System.out.println(x+" row affeted");
		
		} catch (SQLException e) {
		System.out.println("not updated try again");
		}
	}

	@Override
	public void editEmail(int actNo, String email) {
		// TODO Auto-generated method stub

		Connection con=	Connections.getConnection();
		try {
			PreparedStatement ps= con.prepareStatement("update customer set email=? where actNo=? ");
			ps.setString(1, email);
			ps.setInt(2, actNo);
			int x=ps.executeUpdate();
			if(x>0)System.out.println(x+" row affeted");
		
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("not updated try again");
		}
		
		
	}

	@Override
	public void editpass(int actNo, int pass) {
		Connection con=	Connections.getConnection();
		try {
			PreparedStatement ps= con.prepareStatement("update customer set pass=? where actNo=? ");
			ps.setInt(1, pass);
			ps.setInt(2, actNo);
			int x=ps.executeUpdate();
			if(x>0)System.out.println(x+" row affeted");
		
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("not updated try again");
		}
		
	}

	@Override
	public void deposit(int actNo, int rs) {
		Connection con=	Connections.getConnection();
		try {
			PreparedStatement ps1= con.prepareStatement("select bal from customer where actNo=? ");
			ResultSet ans= ps1.executeQuery();
			int rup=rs;
			if(ans!=null) {
				rup=ans.getInt("bal");
				
			}
		
			int finalrs=rup+rs;
			
			
			PreparedStatement ps=con.prepareStatement("update customer set bal=? where ActNo=?");
			ps.setInt(1, finalrs);
			ps.setInt(2, actNo);
			int x=ps.executeUpdate();
			if(x>0) {
				System.out.println(x+" row affeted");
			pre(actNo, rup+rs);
		
			}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		System.out.println(e.getMessage());
		System.out.println("not updated try again");
	}
	}
	
	public void pre(int act,int rs) {
		
		Connection con=	Connections.getConnection();
		try {
			PreparedStatement his=con.prepareStatement("insert into data values(?,?)");
			his.setInt(1, act);
			his.setInt(2, rs);
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
	System.out.println("Transaction successful!!");
		}
	}

	@Override
	public void withdrwal(int actNo, int rs) {
		Connection con=	Connections.getConnection();
		try {
			PreparedStatement ps1= con.prepareStatement("select bal from customer where actNo=? ");
			ResultSet ans= ps1.executeQuery();
			int rup=0;
			if(ans!=null) {
				rup=ans.getInt("bal");
				
			}
			if(rup<rs) {
				System.out.println("Insufficient balance----");
				return;
			}
			
			
			
			PreparedStatement ps= con.prepareStatement("update customer set bal=bal-? where actNo=? ");
			ps.setInt(1, rs);
			ps.setInt(2, actNo);
			int x=ps.executeUpdate();
			if(x>0) {System.out.println(x+" row affeted");
			
		pre(actNo, rup-rs);
			}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		System.out.println("not updated try again");
	}
}

}
