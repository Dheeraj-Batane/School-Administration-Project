//SCSIT project
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class FDemo extends JFrame implements ActionListener
{
	CardLayout card;
	Container cn;
	HomeDemo home;
	StudentLogin student;
	TeacherLogin teacher;
	MenuDemo menu;
	Admin adm;
	FDemo()
	{
		cn=getContentPane();
		setTitle("School Administration");
		setResizable(false);
		
		card=new CardLayout();
		setLayout(card);
		
		home=new HomeDemo();
		student=new StudentLogin();
		teacher=new TeacherLogin();
		menu=new MenuDemo();
		adm=new Admin();
		add("hm",home);
		add("st",student);
		add("tch",teacher);
		add("mn",menu);
		add("ad",adm);
		home.b1.addActionListener(this);
		home.b2.addActionListener(this);
	//	home.b3.addActionListener(this);
		adm.b2.addActionListener(this);
		student.b2.addActionListener(this);
		teacher.b2.addActionListener(this);
		teacher.b1.addActionListener(this);
		menu.ins.b2.addActionListener(this);
		menu.ins.b1.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==home.b1)
		{
			card.show(cn,"st");
			setTitle("Result");
		}
		if(e.getSource()==student.b2 || e.getSource()==teacher.b2 ||e.getSource()==adm.b2 || e.getSource()==menu.ins.b2)
		{
			card.show(cn,"hm");
			
		}
		if(e.getSource()==home.b2)
		{
			card.show(cn,"tch");
		}
		if(e.getSource()==menu.ins.b1)
		{
			String s1=menu.ins.t1.getText();
			String s2=menu.ins.t2.getText();
			String s3=menu.ins.t3.getText();
			String s4=menu.ins.t4.getText();
			String s5=menu.ins.t5.getText();
			String s6=menu.ins.t6.getText();
			String s7=menu.ins.t7.getText();
			
			try
			{
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/scsit?useSSl=false","root","root");
				Statement st=con.createStatement();
				String q="insert into mcaA values('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"','"+s7+"')";
				
				st.executeUpdate(q);
				
				JOptionPane.showMessageDialog(menu.ins.t3,"Data Inserted");
				menu.ins.t1.setText("");
				menu.ins.t2.setText("");
				menu.ins.t3.setText("");
				menu.ins.t4.setText("");
				menu.ins.t5.setText("");
				menu.ins.t6.setText("");
				menu.ins.t7.setText("");
				
			}
			catch(Exception e2)
			{
				System.out.println(e2);
			}
			
		}
		
		// if(e.getSource()==home.b3)
		// {
			// card.show(cn,"ad");
		// }
		
		if(e.getSource()==teacher.b1)
		{
			String s3=teacher.tx1.getText();
			String s4=teacher.tx2.getText();
			
			try
			{
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/scsit?useSSl=false","root","root");
				Statement st=con.createStatement();
				String q="select * from teacher where TName='"+s3+"' and TID='"+s4+"' ";
				
				ResultSet rs=st.executeQuery(q);
				if(rs.next())
				{
				card.show(cn,"mn");
				
				}
				else
				{
					JOptionPane.showMessageDialog(teacher.b1,"Invalid Teacher Name or ID");
				}
				con.close();
			}
			catch(Exception e2)
			{
				System.out.println(e2);
			}
			
		}
		
	}
}
class main
{
	public static void main(String []arg)
	{
		FDemo f=new FDemo();
		Toolkit t=Toolkit.getDefaultToolkit();
		Image i=t.getImage("logo.png");
		f.setIconImage(i);
		f.setVisible(true);
		f.setBounds(400,100,700,520);
		f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
	}
}