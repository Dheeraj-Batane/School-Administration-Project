import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
class MenuDemo extends JPanel
{
	
	InsertDemo ins;
	SearchDemo src;
	ShowDemo show;
	UpdateDemo upt;
	DeleteDemo dlt;
	JTabbedPane tab1;
	MenuDemo()
	{
		setLayout(new BorderLayout());
		tab1=new JTabbedPane(JTabbedPane.TOP);
		ins=new InsertDemo();
		src=new SearchDemo();
		show=new ShowDemo();
		upt=new UpdateDemo();
		dlt=new DeleteDemo();
		
		tab1.addTab("Insert",ins);
		tab1.addTab("Search",src);
		tab1.addTab("Show All",show);
		tab1.addTab("Update",upt);
		tab1.addTab("Delete",dlt);
		
		add(tab1);
		
	}
}

//******************** Insert *************************
class InsertDemo extends JPanel implements ActionListener
{
	JLabel u1,u2,u3,u4,u5,u6,u7;
	JTextField t1,t2,t3,t4,t5,t6,t7;
	JButton b1,b2;
	InsertDemo()
	{
		setLayout(null);
		u1=new JLabel("Enter Name:");
		u1.setBounds(100,50,100,30);
		add(u1);
		
		t1=new JTextField();
		t1.setBounds(200,50,150,30);
		add(t1);
		
		u2=new JLabel("Enter R.NO:");
		u2.setBounds(100,100,100,30);
		add(u2);
		
		t2=new JTextField();
		t2.setBounds(200,100,150,30);
		add(t2);
		
		u3=new JLabel("Enter COA.");
		u3.setBounds(100,150,100,30);
		add(u3);
		
		t3=new JTextField();
		t3.setBounds(200,150,150,30);
		add(t3);
		
		u4=new JLabel("Enter OS.");
		u4.setBounds(100,200,100,30);
		add(u4);
		
		t4=new JTextField();
		t4.setBounds(200,200,150,30);
		add(t4);
		
		u5=new JLabel("Enter Math.");
		u5.setBounds(100,250,100,30);
		add(u5);
		
		t5=new JTextField();
		t5.setBounds(200,250,150,30);
		add(t5);
		
		u6=new JLabel("Enter Comm.");
		u6.setBounds(100,300,100,30);
		add(u6);
		
		t6=new JTextField();
		t6.setBounds(200,300,150,30);
		add(t6);
		
		u7=new JLabel("Enter DS.");
		u7.setBounds(100,350,100,30);
		add(u7);
		
		t7=new JTextField();
		t7.setBounds(200,350,150,30);
		add(t7);
		
		
		b1=new JButton("Insert");
		b1.setBounds(110,400,80,30);
		add(b1);
		b1.addActionListener(this);
		
		
		b2=new JButton("LogOut");
		b2.setBounds(220,400,80,30);
		b2.addActionListener(this);
		add(b2);
		
		
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		ImageIcon img1=new ImageIcon("insert.jpg");
		Image regis=img1.getImage();
		g.drawImage(regis,400,80,this);
	}
	public void actionPerformed(ActionEvent e)
	{
		
	
	}
}

//******************** Search**********************
class SearchDemo extends JPanel implements ActionListener
{
	JLabel u1;
	JTextField t1;
	JButton b1;
	Label u2,u3,u4,u5,u6,u7;
	Font f;
	Label u8,u9,u10,u11,u12,u13;
	String s1,s2,s3,s4,s5,s6;
	//JTextArea ta;
	SearchDemo()
	{
		setLayout(null);
		f=new Font("",Font.BOLD,15);
		setFont(f);
		u1=new JLabel("Enter R.No.:");
		u1.setBounds(100,50,100,30);
		add(u1);
		
		t1=new JTextField();
		t1.setBounds(200,50,150,30);
		add(t1);
		
		
		b1=new JButton("Search");
		b1.setBounds(170,100,80,30);
		b1.addActionListener(this);
		add(b1);
			
			u2=new Label("Name:");
			u2.setBounds(10,150,80,30);
			u2.setBackground(Color.white);
			
			u3=new Label("COA:");
			u3.setBounds(10,200,80,30);
			u3.setBackground(Color.white);
			
			u4=new Label("OS:");
			u4.setBounds(10,250,80,30);
			u4.setBackground(Color.white);
			
			u5=new Label("DS:");
			u5.setBounds(10,300,80,30);
			u5.setBackground(Color.white);
			
			u6=new Label("Maths:");
			u6.setBounds(10,350,80,30);
			u6.setBackground(Color.white);
			
			u7=new Label("Comm:");
			u7.setBounds(10,400,80,30);
			u7.setBackground(Color.white);
			
			u8=new Label();
			u8.setBounds(100,150,130,30);
			u8.setBackground(Color.white);
			
			u9=new Label();
			u9.setBounds(100,200,80,30);
			u9.setBackground(Color.white);
			
			u10=new Label();
			u10.setBounds(100,250,80,30);
			u10.setBackground(Color.white);
			
			u11=new Label();
			u11.setBounds(100,300,80,30);
			u11.setBackground(Color.white);
			
			u12=new Label();
			u12.setBounds(100,350,80,30);
			u12.setBackground(Color.white);
			
			u13=new Label();
			u13.setBounds(100,400,80,30);
			u13.setBackground(Color.white);
			
			
			
			
	}
	public void paintComponent(Graphics g)
	{
		
		ImageIcon img2=new ImageIcon("search.jpg");
		Image search=img2.getImage();
		g.drawImage(search,0,0,this);
	}
	public void actionPerformed(ActionEvent e)
	{
			String s11=t1.getText();
		
		try
			{
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/scsit?useSSl=false","root","root");
				Statement st=con.createStatement();
				String q="select * from mcaA where RNO='"+s11+"' ";
				
				ResultSet rs=st.executeQuery(q);
				if(rs.next())
				{
					s1=rs.getString(1);
					s2=rs.getString(3);
					s3=rs.getString(4);
					s4=rs.getString(5);
					s5=rs.getString(6);
					s6=rs.getString(7);
					
			
				add(u2);
				add(u3);
				add(u4);
				add(u5);
				add(u6);
				add(u7);
			
				u8.setText(s1);
				u9.setText(s2);
				u10.setText(s3);
				u11.setText(s4);
				u12.setText(s5);
				u13.setText(s6);
				
				add(u8);
				add(u9);
				add(u10);
				add(u11);
				add(u12);
				add(u13);
			
			
				}
				else
				{
					JOptionPane.showMessageDialog(b1,"Invalid Roll No");
				}
			}
			catch(Exception e2)
			{
				System.out.println(e2);
			}
			
		
		
			
			
	}
}

//******************* Show all********************************
class ShowDemo extends JPanel 
{
	ShowDemo()
	{
		setLayout(new FlowLayout());
		JTable jt;
			JScrollPane sp;
			DefaultTableModel tableModel;
			
			try
			{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/scsit?allowPublicKeyRetrieval=true&useSSL=false","root","root");
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select *from mcaa");
			String []columns={"Name","Roll No","COA","OS","MATHS","Communication","DS"};
			tableModel = new DefaultTableModel(columns, 0);
			while(rs.next())
			{
				String x1=rs.getString("Name");
				String x2=rs.getString("RNO");
				String x3=rs.getString("COA");
				String x4=rs.getString("OS");
				String x5=rs.getString("Maths");
				String x6=rs.getString("Comm");
				String x7=rs.getString("DS");
				String []data={x1,x2,x3,x4,x5,x6,x7};
				tableModel.addRow(data);
			}
				jt =new JTable(tableModel);
			sp=new JScrollPane(jt);
				add(sp);
			con.close();
			}
			catch(Exception e1)
			{
			System.out.println(e1);
			}
		
			
	}
}


//************************ Update**************************
class UpdateDemo extends JPanel implements ActionListener
{
	JLabel u1,u2,u3,u4,u5,u6,u7;
	JTextField t1,t2,t3,t4,t5,t6,t7;
	javax.swing.JButton b1,b2;
	UpdateDemo()
	{
		setLayout(null);
		u1=new JLabel("Enter R.No.:");
		u1.setBounds(50,10,100,30);
		add(u1);
		
		t1=new JTextField();
		t1.setBounds(150,10,150,30);
		add(t1);
		
		
		b1=new JButton("Search");
		b1.setBounds(120,50,80,30);
		b1.addActionListener(this);
		add(b1);
		
		u2=new JLabel("Name:");
		u2.setBounds(50,120,100,30);
		
		t2=new JTextField();
		t2.setBounds(150,120,150,30);
		
		u3=new JLabel("COA:");
		u3.setBounds(50,170,100,30);
		
		t3=new JTextField();
		t3.setBounds(150,170,150,30);
		
		u4=new JLabel("OS:");
		u4.setBounds(50,220,100,30);
		
		t4=new JTextField();
		t4.setBounds(150,220,150,30);
		
		u5=new JLabel("Maths:");
		u5.setBounds(50,270,100,30);
		
		t5=new JTextField();
		t5.setBounds(150,270,150,30);
		
		u6=new JLabel("Communication:");
		u6.setBounds(50,320,100,30);
		
		t6=new JTextField();
		t6.setBounds(150,320,150,30);
		
		u7=new JLabel("Data Structure:");
		u7.setBounds(50,370,100,30);
		
		t7=new JTextField();
		t7.setBounds(150,370,150,30);
		
		
		
		
		b2=new JButton("Update");
		b2.setBounds(150,420,80,30);
		b2.addActionListener(this);
		add(b2);
		
		add(u2);
		add(u3);
		add(u4);
		add(u5);
		add(u6);
		add(u7);
		
		add(t2);
		add(t3);
		add(t4);
		add(t5);
		add(t6);
		add(t7);
		
	}
	public void paintComponent(Graphics g)
	{
		
		ImageIcon img3=new ImageIcon("update.png");
		Image update=img3.getImage();
		g.drawImage(update,350,60,this);
	}
	public void  actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b1)
		{
			String s1=t1.getText();
			if(s1.equals(""))
			{
					JOptionPane.showMessageDialog(b1,"Please Enter Roll Number");
			}
			else
	    	{	
				try
				{
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql:///scsit","root","root");
				Statement st=con.createStatement();
				String q ="select * from mcaa where rno='"+s1+"'";
				ResultSet rs=st.executeQuery(q);
				if(rs.next())
				{
					t2.setText(rs.getString(1));
					t3.setText(rs.getString(3));
					t4.setText(rs.getString(4));
					t5.setText(rs.getString(5));
					t6.setText(rs.getString(6));
					t7.setText(rs.getString(7));
				}
				else
				{
					JOptionPane.showMessageDialog(b1,"Invalid Roll Number");
				}
				con.close();
				}
				catch(Exception e1)
				{
				System.out.println(e1);
				}
			}
	    			
		}
		if(e.getSource()==b2)
		{
			String s1=t1.getText();
			String s2=t2.getText();
			String s3=t3.getText();
			String s4=t4.getText();
			String s5=t5.getText();
			String s6=t6.getText();
			String s7=t7.getText();
			
			try
			{
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/scsit?useSSL=false","root","root");
				Statement st=con.createStatement();
				String q="update mcaa set Name='"+s2+"' ,COA='"+s3+"' ,OS='"+s4+"',Maths='"+s5+"',Comm='"+s6+"',DS='"+s7+"' where RNO='"+s1+"' ";
				st.executeUpdate(q);
				con.close();
				JOptionPane.showMessageDialog(b2,"Data Updated Successfully");
				t1.setText("");
				t2.setText("");
				t3.setText("");
				t4.setText("");
				t5.setText("");
				t6.setText("");
				t7.setText("");
				
			}
			catch(Exception e1)
			{
				System.out.println(e1);
				
				
			}
		}
		
	}
}

//************************ Delete **************************
class DeleteDemo extends JPanel implements ActionListener
{
	JLabel u1;
	JTextField t1;
	JButton b1;
	DeleteDemo()
	{
		setLayout(null);
		u1=new JLabel("Enter R.No.:");
		u1.setBounds(100,100,100,30);
		add(u1);
		
		t1=new JTextField();
		t1.setBounds(200,100,150,30);
		add(t1);
		
		
		b1=new JButton("Delete");
		b1.setBounds(170,180,80,30);
		add(b1);
		b1.addActionListener(this);
	}
	public void paintComponent(Graphics g)
	{
		
		ImageIcon img4=new ImageIcon("delete.png");
		Image delete=img4.getImage();
		g.drawImage(delete,380,80,this);
	}
	public void actionPerformed(ActionEvent e)
	{
		String s1=t1.getText();
		if(s1.equals(""))
		{
			JOptionPane.showMessageDialog(null,"Please Enter Valid Roll No");
		}
		else
		{	

			try
			{
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/scsit?useSSL=false","root","root");
				Statement st=con.createStatement();
				String q="delete from mcaa where rno='"+s1+"' ";
				st.executeUpdate(q);
				con.close();
				JOptionPane.showMessageDialog(null,"Data Deleted Successfully");
				t1.setText("");			
			}
			catch(Exception e1)
			{
				System.out.println(e1);					
			}
		}
	}
}


