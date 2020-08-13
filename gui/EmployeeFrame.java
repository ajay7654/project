/*-- View Profile  
		-- Update Profile
		-- Update Skill
		-- Apply Job
		-- Logout
		*/
package gui;
import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import daoImpl.EmployeeDaoImpl;
class employeehome extends JFrame implements ActionListener{
	JLabel lTitle,lMessage;
	JButton bview,baddskill,bupdate,bviewjob,blogout;
	private static JDialog dialog;
	 public void employeehome(String user, String passwords)
	{
		lTitle=new JLabel("EMPlOYEE HOME");
		lTitle.setBounds(155, 5, 150, 25);
		bview=new JButton("view");
		bview.setBounds(180, 10,200, 100);
		bview.addActionListener(this);
		bview.setLocation(10,50);
		
		
		baddskill=new JButton("addskill");
		baddskill.setBounds(100, 200,200, 100);
		baddskill.addActionListener(this);
		baddskill.setLocation(10,150);
		
		bupdate=new JButton("update");
		bupdate.setBounds(100, 10,200, 100);
		bupdate.addActionListener(this);
		bupdate.setLocation(225,150);
		
		bviewjob=new JButton("viewjob");
		bviewjob.setBounds(100, 10,200, 100);
		bviewjob.addActionListener(this);
		bviewjob.setLocation(225,50);
		
		blogout=new JButton("logout");
		blogout.setBounds(50,10,200,50);
		blogout.setLocation(280,260);
		blogout.addActionListener(this);
		
		lMessage=new JLabel();
		lMessage.setBounds(120, 320, 350, 40);
		dialog=new JDialog(this,"view",true);
		
		lMessage=new JLabel();
		lMessage.setBounds(20, 320, 350, 40);
		dialog=new JDialog(this,"addskill",true);
		
		lMessage=new JLabel();
		lMessage.setBounds(120, 320, 320, 25);
		dialog=new JDialog(this,"viewjob",true);
		 
		lMessage=new JLabel();
		lMessage.setBounds(120, 320, 320, 25);
		dialog=new JDialog(this,"update",true);
		
		add(lTitle);
		add(bview);
		add(baddskill);
		add(bupdate);
		add(bviewjob);
		add(blogout);
		dialog.add(lMessage);
		
		dialog.setSize(450,300);
		setSize(500,500);
		setLayout(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		bview.addActionListener(new ActionListener()
		{	
			public void actionPerformed(ActionEvent e)
			{
			//	new Addition();
				//new registerform1();
				try {
					    empdata frame = new empdata();
					    frame.empdata(user,passwords);
				       // frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
				        frame.pack();
				        frame.setVisible(true);
				} catch (ClassNotFoundException e1) {
					
					e1.printStackTrace();
				}
			}
		});
}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==blogout) {
			new x();
			this.dispose();
		}
		
		
	}

	
	
}
public class EmployeeFrame {

	
}


