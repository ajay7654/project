package gui;

import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*; 
public class changepassword extends JFrame implements ActionListener { 
    private static final String user = null;

	// JTextField 
    static JTextField t,t1; 
  
    // JFrame 
    static JFrame f,f2; 
  
    // JButton 
    static JButton b,b1; 
  
    // label to display text 
    static JLabel l,l2; 
   
  
    // default constructor 
   public void enter(String user) 
      { 
   
    // main class 
   
        // create a new frame to store text field and button 
        f = new JFrame("textfield"); 
       
  
        // create a label to display text 
        l = new JLabel("empid"); 
      
  
        // create a new button 
        b = new JButton("sumit"); 
      ; 
  
        // create a object of the text class 
        newenter te = new newenter(); 
       
        
  
        // addActionListener to button 
        b.addActionListener(te); 
       
    
  
        // create a object of JTextField with 16 columns 
        t = new JTextField(16); 
       
  
        // create a panel to add buttons and textfield 
        JPanel p = new JPanel();
        
  
        // add buttons and textfield to panel 
        p.add(t); 
     
        p.add(b); 
    
        p.add(l); 
  
        // add panel to frame 
        f.add(p); 
      
  
        // set the size of frame 
        f.setSize(400, 400);
        f.show(); 
        f.setVisible(true);
       
   
    }
  /* public void enter1() 
   { 
	   f2 = new JFrame("textfield"); 
	   l2 = new JLabel("empid"); 
	   b1 = new JButton("deactive"); 
	   newenter ve = new newenter();
	   b1.addActionListener(ve); 
	   t1 = new JTextField(16);
	   JPanel p1 = new JPanel();
	   f2.setSize(400, 400);
	   
	   f2.add(p1); 
	   p1.add(t1);
	   p1.add(b1);
	   p1.add(l2); 
	   
	   f2.show(); 
       f2.setVisible(true);
   }*/
   
	@Override
	public void actionPerformed(ActionEvent e) {
		String s = e.getActionCommand(); 
        if (s.equals("sumit")) { 
        	String url="jdbc:sqlserver://LAPTOP-SEFV2UJQ\\AJAYSQL//localhost:1433;database=PCS";
       		String username="sa";
       		String password="ajay";
       	
              try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
       		    Connection conn;
				conn = DriverManager.getConnection(url,username,password);			 
       		    String userid=t.getText();   
			    PreparedStatement ps;
				ps = conn.prepareStatement("update Employee set password='"+userid+"' where userid='"+user+"'");
			   // ps.setString(1, userid);
			    ps.executeUpdate();
              } 
              catch (SQLException e1) {
  				e1.printStackTrace();
  			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			}
              l.setText(t.getText()); 
              t.setText("  "); 
          } 
  
} 
}

