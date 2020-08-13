//config,model,dao.daoimpl,test

package Config;

import java.sql.*;

public class JDBCConnection {
	public static void main (String[] args)throws ClassNotFoundException, SQLException{
		
		String url="jdbc:sqlserver://LAPTOP-SEFV2UJQ\\AJAYSQL//localhost:1433;database=PCS";
		String username="sa";
		String password="ajay";
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection conn=DriverManager.getConnection(url,username,password);
		if(conn!=null)
		   System.out.println("connected");
		else
			System.out.println("not connected");
		
		
  }

	public static Connection getJDBCConnection() {
		// TODO Auto-generated method stub
		return null;
	}

}
	


