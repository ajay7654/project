package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import dao.EmployeeDao;
import daoImpl.EmployeeDaoImpl;
import model.Employee;

class EmployeeTest{
	public Employee acceptEmployee() {
		Employee emp=new Employee();
		try {
			BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("Enter Firstname:");
			emp.setFirstName(reader.readLine());
			System.out.println("Enter Lastname:");
			emp.setLastName(reader.readLine());
			System.out.println("Enter UserId:");
			emp.setUserid(reader.readLine());
			System.out.println("Enter password:");
			emp.setPassword(reader.readLine());
			System.out.println("Enter Gender:");
			emp.setGender(reader.readLine());
			System.out.println("Enter Role:");
			String role=reader.readLine();
			emp.setRole(role);
			if(role.equals("HRA"))
				emp.setActive("true");
			else
				emp.setActive("false");
			
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
		}
		return emp;
	}
}

public class TestClass {

	public static void main(String[] args) {
		EmployeeTest emp=new EmployeeTest();
		EmployeeDao empDao=new EmployeeDaoImpl();
		empDao.addEmployee(emp.acceptEmployee());
		empDao.getAllEmployees();

	}

}
