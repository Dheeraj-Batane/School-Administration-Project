import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class Admin extends JPanel implements ActionListener
{
	JLabel u1,u2,u3,u4;
	JTextField t1,t2,t3,t4;
	JButton b1,b2;
	Admin()
	{
		setLayout(null);
		u1=new JLabel("Enter Name:");
		u1.setBounds(100,100,100,30);
		add(u1);
		
		t1=new JTextField();
		t1.setBounds(200,100,150,30);
		add(t1);
		
		u2=new JLabel("Enter ID:");
		u2.setBounds(100,150,100,30);
		add(u2);
		
		t2=new JTextField();
		t2.setBounds(200,150,150,30);
		add(t2);
		
		u3=new JLabel("Qualification:");
		u3.setBounds(100,200,100,30);
		add(u3);
		
		t3=new JTextField();
		t3.setBounds(200,200,150,30);
		add(t3);
		
		u4=new JLabel("Contact No:");
		u4.setBounds(100,250,100,30);
		add(u4);
		
		t4=new JTextField();
		t4.setBounds(200,250,150,30);
		add(t4);
		
		
		b1=new JButton("Register");
		b1.setBounds(170,350,100,30);
		add(b1);
		b1.addActionListener(this);
		
		b2=new JButton("LogOut");
		b2.setBounds(170,40,80,30);
		add(b2);
		
	}
	public void actionPerformed(ActionEvent e)
	{
		String s1=t1.getText();
		String s2=t2.getText();
		String s3=t3.getText();
		String s4=t4.getText();
		
		
			try
			{
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/scsit?useSSL=false","root","root");
				Statement st=con.createStatement();
				st.executeUpdate("insert into teacher values('"+s1+"','"+s2+"','"+s3+"','"+s4+"')");
				con.close();
				JOptionPane.showMessageDialog(b1,"Success");
				t1.setText("");
				t2.setText("");
				t3.setText("");
				t4.setText("");
				
			}
			catch(Exception e1)
			{
				System.out.println(e1);
			}
			
	}
	
		
	
}