package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class login {

	public static void main(String[] args) {
	   x obj=new x();
	}

}
class x extends JFrame implements ActionListener
{
	JLabel lTitle, lUser,lPassword,lMessage,lrole;
	JTextField tUser,trole;
	JPasswordField tpassword;
	JButton bLogin,bregister;
	JComboBox crole;
	static JDialog dialog;
	public x()
	{
		String[] role= {"N/A","HR","EMP","PM"};
		lTitle=new JLabel("Login Here");
		lTitle.setBounds(180, 20, 150, 25);
		lUser=new JLabel("User Id");
		lUser.setBounds(50, 80, 150, 25);
		lPassword=new JLabel("Password");
		lPassword.setBounds(50, 160, 150, 25);
		lrole=new JLabel("role");
		lrole.setBounds(50, 240, 150, 25);
		tUser=new JTextField();
		tUser.setBounds(200, 80, 150, 25);
		tpassword=new JPasswordField();
		tpassword.setBounds(200, 160, 150, 25);
	    tpassword .setEchoChar('*');

	    crole=new JComboBox(role);
		crole.setBounds(200, 240, 150, 25);
		
		
		bLogin=new JButton("Login");
		bLogin.setBounds(180, 300,150, 25);
		bLogin.addActionListener(this);
		bLogin.setLocation(300,300);
		bregister=new JButton("register");
		bregister.setBounds(180,300,150, 30);
		bregister.setLocation(20,300);
		bregister.addActionListener(this);
		lMessage=new JLabel();
		lMessage.setBounds(120, 320, 320, 25);
		dialog=new JDialog(this,"Login",true);
		
		add(lTitle);
		add(lUser);
		add(lPassword);
		add(lrole);
		add(crole);
		
		add(tUser);
		add(tpassword);
		add(bLogin);
		add(bregister);
		add(lMessage);
		dialog.add(lMessage);
		
		dialog.setSize(350, 200);
		setSize(500,500);
		setLayout(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		JButton b=new JButton("registeration");
	
		bregister.addActionListener(new ActionListener()
		{	
			public void actionPerformed(ActionEvent e)
			{
			   new Addition();
			   
				//new registerform1();
				
				//dispose();
			}
		});
	}

	/*{
		String id=tUser.getText();
 		String pass=tpassword.getText();
 		String role=crole.getSelectedItem().toString();
 		String message=new EmployeeController().login(id,pass,role);
	}
}*/
	@Override
	public void actionPerformed(ActionEvent e) {
	
      try{
				 
				if(e.getSource()==bLogin) {
					
		                String url="jdbc:sqlserver://LAPTOP-SEFV2UJQ\\AJAYSQL//localhost:1433;database=PCS";
		         		String username="sa";
		         		String password="ajay";
		         	
		                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		         		//Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		         		Connection conn=DriverManager.getConnection(url,username,password);
		         		
		         		String userid=tUser.getText();
		         		@SuppressWarnings("deprecation")
						String password1=tpassword.getText();
		         		String role=crole.getSelectedItem().toString();
		         		//String message=new EmployeeController().login(id,pass,role);
			
	

                       //Connection con=DriverManager.getConnection(id,role,pass);
                       PreparedStatement ps = conn.prepareStatement("select * from Employee where userid=? and password=? and role=?");
                      // and active='TRUE'
		         		ps.setString(1, userid);
		                ps.setString(2, password1);
		                ps.setString(3, role);
		                ResultSet rs = ps.executeQuery();
		                if (rs.next())
		                {
		                	String user=tUser.getText();
    		         		@SuppressWarnings("deprecation")
    						String passwords=tpassword.getText();
    		         		
                        if(crole.getSelectedItem().equals("EMP")) {
                        	
                        	employeehome ob1=new employeehome();
    		         		ob1.employeehome(user,passwords);
                        }
   					     if(crole.getSelectedItem().equals("PM")) {
   					    	
   						       pmhome a=new pmhome();
   						       a.pmhome(user,passwords);
   					     }
   					     if(crole.getSelectedItem().equals("HR")) {	    	    
   						        new hrhome();
   					     }
                        JOptionPane.showMessageDialog(null,"LOGIN SUCCESSFULLY");
                        this.dispose();
				        }  
		                else {
		                	
							 JOptionPane.showMessageDialog(null,"unauthorized user");
						}
				}
				
		               
             }			 
	
		        catch (SQLException ae) {
		         ae.printStackTrace();
		        }
			    catch (ClassNotFoundException ae) {
				 ae.printStackTrace();
				}

				
	}

	
}

	
			
