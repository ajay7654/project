package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import gui.EmployeeFrame;
import gui.PMFrame;

public class EmployeeController {

	public String login(String id, String pass, String role) {
		String message=null;
		try {
			
			        Connection conn=DriverManager.getConnection(id,role,pass);
	         		
	                PreparedStatement ps = conn.prepareStatement("select * from Employee where userid=? and password=? and role=?");
	         		ps.setString(1, id);
	                ps.setString(2, pass);
	                ps.setString(8, role);
	                ResultSet rs = ps.executeQuery();
	                if(rs.next())
	        		{
	        			message="welcome";
	        		}
		}
		
	        catch (SQLException ae1) {
	         ae1.printStackTrace();
	        }

				
			

		return null;
	}

}
