package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.xdevapi.Statement;

public class AuthModel {
	
	public AuthModel()
	{
		
	}
	//usuario:ehileen
	//contraseña:pan
	public boolean login(String user, String pwd)
	{
//		if(user.equals("Admin")&&pwd.equals("123"))
//		{
//			System.out.println("Se logró");
//		}
//		else
//		{
//			System.out.println("No se logró");
//		}
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");  
			try {
				Connection con=DriverManager.getConnection("jdbc:mysql://sql.freedb.tech:3306/freedb_dataSql1","freedb_ehileenr_22","X8F3fC74nRn*T5@"); 
				
				java.sql.Statement stmt=con.createStatement();  
				ResultSet rs=stmt.executeQuery("select * from users");  
				
				while(rs.next())
				{
					System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+ "  "+rs.getString(4) );  
					if(user.equals(rs.getString(3))&&pwd.equals(rs.getString(4)))
					{
						System.out.println("Se logró");
						return true;
					}
					else
					{
						System.out.println("No se logró");
						return false;
					}
				}
					
				
				con.close();  
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		  
	}
	

}
