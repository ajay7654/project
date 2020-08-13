/*-- Active Employee
		-- Deactive Employee
		-- View All Employee
		-- View Selective Employee
		-- Add Skill
		-- View All Skills
		-- Deactive Skill
		-- Logout
*/
package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import model.Employee;

class hrhome extends JFrame implements ActionListener
{
	protected static final JDialog frame = null;
	JLabel lTitle,lMessage;
	JButton bactive,bdeactive,bview,bviewskill,blogout;
	JFrame frame2 = new JFrame("Activate Employee");
	JLabel E=new JLabel("Activate employee");
	JTextField text=new JTextField();
	JButton active=new JButton("active");
	
	
	
	
	private static JDialog dialog;
	public hrhome()
	{
		lTitle=new JLabel("HR HOME");
		lTitle.setBounds(155, 5, 150, 25);
		
		bview=new JButton("view");
		bview.setBounds(180, 10,200, 100);
		bview.addActionListener(this);
		bview.setLocation(10,50);
		
		bactive=new JButton("active");
		bactive.setBounds(100, 200,200, 100);
		bactive.addActionListener(this);
		bactive.setLocation(10,150);
		
		bdeactive=new JButton("deactive");
		bdeactive.setBounds(100, 10,200, 100);
		bdeactive.addActionListener(this);
		bdeactive.setLocation(225,150);
		
		bviewskill=new JButton("viewskill");
		bviewskill.setBounds(100, 10,200, 100);
		bviewskill.addActionListener(this);
		bviewskill.setLocation(225,50);
		
		blogout=new JButton("logout");
		blogout.setBounds(50,10,200,50);
		blogout.setLocation(280,260);
		blogout.addActionListener(this);
		
		add(lTitle);
		add(bview);
		add(bactive);
		add(bdeactive);
		add(bviewskill);
		add(blogout);
		 
	    //E.setBounds(50,10,200,50);
		//E.setLocation(280,260);
		//frame2.add(E);
		//frame2.add(text);
		//frame2.add(active);
		
		
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//dialog.add(lMessage);
		//dialog.setSize(450, 300);
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
				    hrdata frame = new hrdata();
				    
			       // frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
			        frame.pack();
			        frame.setVisible(true);
			} catch (ClassNotFoundException e1) {
				
				e1.printStackTrace();
			}
		}
	});

	bactive.addActionListener(new ActionListener()
	{	
		public void actionPerformed(ActionEvent e)
		{
			   
			   bactive.addActionListener(this);
			   newenter f = new newenter(); 
			   f.enter();
			    //hrdata frame = new hrdata();
			   // frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
			    f.pack();
			   // f.setVisible(true);
		}
	});
	
	bdeactive.addActionListener(new ActionListener()
	{	
		public void actionPerformed(ActionEvent e)
		{
			   
			   bactive.addActionListener(this);
			   newdeactive d= new newdeactive(); 
			   d.enter1();
			    //hrdata frame = new hrdata();
			   // frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
			   d.pack();
			   // f.setVisible(true);
		}
	});
}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==blogout)
		{
			new x();
			this.dispose();
	
		}
		
	}
}
public class HRAFrame {



	public static void main(String[] args) {
		// TODO Auto-generated method stub
         hrhome obj=new hrhome();
	}
}
