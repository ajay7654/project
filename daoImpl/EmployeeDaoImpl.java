package daoImpl;

import java.sql.*;


import dao.EmployeeDao;
import model.Employee;
import Config.JDBCConnection;


public class EmployeeDaoImpl implements EmployeeDao{

	Connection conn=null;
	@Override
	public void getAllEmployees() {
		try {
			
			
			Connection conn=null;
			conn= JDBCConnection.getJDBCConnection();
			Statement stmt=conn.createStatement();
			ResultSet rst=stmt.executeQuery("select * from Employer");
			if(rst!=null) {
				Employee emp=new Employee();
				while(rst.next()) {
					emp.setEmpid(rst.getInt(1));
					emp.setFirstName(rst.getString(2));
					emp.setLastName(rst.getString(3));
					emp.setUserid(rst.getString(4));
					emp.setPassword(rst.getString(5));
					emp.setRole(rst.getString(6));
					emp.setGender(rst.getString(7));
					emp.setActive(rst.getString(8));
					System.out.println(emp);
				}
			}
			conn.close();
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public void addEmployee(Employee emp) {
		try {
			conn=JDBCConnection.getJDBCConnection();
			PreparedStatement pst=conn.prepareStatement("insert into Employer values(?,?,?,?,?,?,?)");
			pst.setString(1, emp.getFirstName());
			pst.setString(2, emp.getLastName());
			pst.setString(3, emp.getUserid());
			pst.setString(4, emp.getPassword());
			pst.setString(5, emp.getGender()); 
			pst.setString(6, emp.getRole());
			pst.setString(7, emp.getActive());
			int i=pst.executeUpdate();
			if(i==1)
				System.out.println("1 record inserted...");
			else
				System.out.println("insertion failed...");
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		
		
	}
	
	@Override
	public Employee getEmployeeById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateEmployee(Employee emp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deactivateEmployee(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void employeedetail() {
		// TODO Auto-generated method stub
		
	}
	

	
}