package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class registerform {

	public static void main(String[] args) {
		Addition obj=new Addition();

	}

}
class Addition extends JFrame implements ActionListener
{
	

	JLabel lTitle, lUser,lPassword,lfirstname,llastname,lrole,lgender,lMessage,lmobileno,lemail;
	JTextField tUser,tfirstname,tlastname,tmobileno,temail,tgender,tmobilno,trole;
	JPasswordField tpassword;
	JComboBox vrole;
	JButton breset,bregister;
	private static JDialog dialog;
	public Addition() {
		String[] role= {"HR","EMP","PM"};
		lTitle=new JLabel("Register Here");
		lTitle.setBounds(180, 20, 150, 25);
		lUser=new JLabel("User Id");
		lUser.setBounds(50, 80, 150, 25);
		lPassword=new JLabel("Password");
		lPassword.setBounds(50, 140, 150, 25);
		lfirstname=new JLabel("FirstName");
		lfirstname.setBounds(50, 200, 150, 25);
		llastname=new JLabel("LastName");
		llastname.setBounds(50, 260, 150, 25);
		lgender=new JLabel("gender");
		lgender.setBounds(50, 320, 150, 25);
		lmobileno=new JLabel("mobileno");
		lmobileno.setBounds(50, 380, 150, 25);
	    lemail=new JLabel("email");
		lemail.setBounds(50, 440, 150, 25);
		lrole=new JLabel("role");
		lrole.setBounds(50, 500, 150, 25);
		tUser=new JTextField();
		tUser.setBounds(200, 80, 150, 25);
		tpassword=new JPasswordField();
		tpassword.setEchoChar('*');
		tpassword.setBounds(200, 140, 150, 25);
		tfirstname=new JTextField();
		tfirstname.setBounds(200, 200, 150, 25);
		tlastname=new JTextField();
		tlastname.setBounds(200,260, 150, 25);
		tgender=new JTextField();
		tgender.setBounds(200, 320, 150, 25);
		tmobileno=new JTextField();
		tmobileno.setBounds(200, 380, 150, 25);
		temail=new JTextField();
		temail.setBounds(200, 440, 150, 25);
		//trole=new JTextField();
		//trole.setBounds(200, 500, 150, 25);
		vrole=new JComboBox(role);
		vrole.setBounds(200, 500, 150, 25);
		
		breset=new JButton("reset");
		breset.setBounds(200,600,150,30);
		breset.setLocation(300,570);
		breset.addActionListener(this);
		
		bregister=new JButton("register");
		bregister.setBounds(200,600,150,30);
		bregister.setLocation(20,570);
		bregister.addActionListener(this);
		
		lMessage=new JLabel();
		lMessage.setBounds(120, 320, 320, 25);
		
		dialog=new JDialog(this,"register",true);
		
		add(lTitle);
		add(lUser);
		
		add(lPassword);
		add(lfirstname);
		add(llastname);
		add(lrole);
		add(lemail);
		add(lmobileno);
		add(lgender);
		add(lMessage);
		
		add(tUser);
		add(tpassword);
		add(tfirstname);
		add(tlastname);
		add(tgender);
		add(tmobileno);
		add(temail);
		add(vrole);
		add(breset);
		add(bregister);
		
		dialog.add(lMessage);
		dialog.setSize(350, 200);
		setSize(600,800);
		setLayout(null);
		setVisible(true);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
    	try {
        if(e.getSource()==bregister)
        {
                String url="jdbc:sqlserver://LAPTOP-SEFV2UJQ\\AJAYSQL//localhost:1433;database=PCS";
         		String username="sa";
         		String password="ajay";
            		        		
            	//Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        	   	 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        	     Connection conn=DriverManager.getConnection(url,username,password);
         	     //Preapared Statement
                 PreparedStatement Pstatement=conn.prepareStatement("insert into Employee values(?,?,?,?,?,?,?,?,?)");
                    //Specifying the values of it's parameter
                    Pstatement.setString(1,tUser.getText());
                    Pstatement.setString(2,tpassword.getText());
                    Pstatement.setString(3,tfirstname.getText());
                    Pstatement.setString(4,tlastname.getText());
                    Pstatement.setString(5,tgender.getText());
                    Pstatement.setNString(6,tmobileno.getText());
                    Pstatement.setString(7,temail.getText());
                    Pstatement.setString(8,vrole.getSelectedItem().toString());
                    Pstatement.setString(9,"FALSE");
                    Pstatement.executeUpdate();
                    //JOptionPane.showMessageDialog(null,"Data Registered Successfully");
                    Statement stmt = conn.createStatement();
                    String sql = "UPDATE Employee SET active='TRUE' WHERE role='HR'";
                    // and role='PM'
                    stmt.executeUpdate(sql);
                    
                    JOptionPane.showMessageDialog(null,"Data Registered Successfully");
                  
                        
       
            }
     
    	}
        catch (SQLException ae) {
            ae.printStackTrace();
        } catch (ClassNotFoundException ae) {
			// TODO Auto-generated catch block
			ae.printStackTrace();
		}

	 if(e.getSource()==breset)
      {
          //Clearing Fields
		  tUser.setText("");
          tpassword.setText("");
          tfirstname.setText("");
          tlastname.setText("");
          tgender.setText("");
          tmobileno.setText("");
          temail.setText("");
          vrole.setSelectedItem("HR");
          //JOptionPane.showMessageDialog(null,"reset");
          
      }
	}
}
	


