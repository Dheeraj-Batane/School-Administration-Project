import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
class StudentLogin extends JPanel implements ActionListener
{
	JLabel u1,u2;
	JTextField t1,t2;
	JButton b1,b2;
	Font f;
	JLabel l1,l2,l3,l4,l5,l6,l7;
	JLabel r1,r2,r3,r4,r5,r6,r7,r8;
	StudentLogin()
	{
		setLayout(null);
		f=new Font("Calibri (Body)",Font.BOLD,15);
		setFont(f);
		u1=new JLabel("Enter Roll No.:");
		u1.setBounds(50,230,150,30);
		u1.setFont(f);
		add(u1);
		
		t1=new JTextField();
		t1.setBounds(190,230,100,30);
		add(t1);
		
		b1=new JButton("Check Result");
		b1.setBounds(300,230,140,30);
		add(b1);
		b1.addActionListener(this);
		
		b2=new JButton("Home");
		b2.setBounds(620,0,80,20);
		add(b2);
		b2.setBackground(Color.red);
		b2.setForeground(Color.white);
		
		l1=new JLabel("Name :");
		l1.setBounds(10,320,70,30);
		l1.setFont(f);
		
		r1=new JLabel();
		r1.setBounds(80,320,150,30);
		r1.setFont(f);
		
		
		l2=new JLabel("Computer Organisation :");
		l2.setBounds(10,360,200,30);
		l2.setFont(f);
		
		r2=new JLabel();
		r2.setBounds(220,360,50,30);
		r2.setFont(f);
		
		l3=new JLabel("Data Structure :");
		l3.setBounds(10,400,200,30);
		l3.setFont(f);
		
		r3=new JLabel();
		r3.setBounds(220,400,50,30);
		r3.setFont(f);
		
		
		l4=new JLabel("Operating System :");
		l4.setBounds(10,440,200,30);
		l4.setFont(f);
		
		r4=new JLabel();
		r4.setBounds(220,440,50,30);
		r4.setFont(f);
		
		
		l5=new JLabel("Communication Skills :");
		l5.setBounds(300,360,180,30);
		l5.setFont(f);
		
		r5=new JLabel();
		r5.setBounds(480,360,50,30);
		r5.setFont(f);
		
		
		l6=new JLabel("Mathematics :");
		l6.setBounds(300,400,180,30);
		l6.setFont(f);
		
		r6=new JLabel();
		r6.setBounds(480,400,50,30);
		r6.setFont(f);
		
		
		l7=new JLabel("Percentage :");
		l7.setBounds(300,440,180,30);
		l7.setFont(f);
		
		
		r7=new JLabel();
		r7.setBounds(480,440,50,30);
		r7.setFont(f);
		
		r8=new JLabel();
		r8.setForeground(Color.blue);
		r8.setBounds(200,270,300,30);
		r8.setFont(f);
		
		
		
	
		
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b1)
		{
			String s1=t1.getText();
			String s2="";
			String s3="";
			String s4="";
			String s5="";
			String s6="";
			String s7="";
			
				try
				{
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/scsit?useSSl=false","root","root");
					Statement st=con.createStatement();
					String q="select *from mcaa where RNO='"+s1+"' ";
					ResultSet rs=st.executeQuery(q);
					
					if(rs.next())
					{	
						s2=rs.getString(1);
						s3=rs.getString(3);
						s4=rs.getString(4);
						s5=rs.getString(5);
						s6=rs.getString(6);
						s7=rs.getString(7);	
					
						int m1=Integer.parseInt(s3);
						int m2=Integer.parseInt(s4);
						int m3=Integer.parseInt(s5);
						int m4=Integer.parseInt(s6);
						int m5=Integer.parseInt(s7);
						int m6=m1+m2+m3+m4+m5;
						float m7=(float)m6/250;
						m7=m7*100;
						String s8=""+m7+"%";
						
							
						add(l1);
						add(l2);
						add(l3);
						add(l4);
						add(l5);
						add(l6);
						add(l7);
						
						r1.setText(s2);
						add(r1);
						r2.setText(s3);
						add(r2);
						r3.setText(s4);
						add(r3);
						r4.setText(s5);
						add(r4);
						r5.setText(s6);
						add(r5);
						r6.setText(s7);
						add(r6);
						r7.setText(s8);
						add(r7);
						
						if(m7>50.0)
						{
							r8.setText("Congratulations You Scored "+m7+" %");
							r8.setForeground(Color.blue);
							add(r8);	
						}
						else
						{
							r8.setText("Sorry !!! You Scored "+m7+" %");
							r8.setForeground(Color.red);
							add(r8);			
						}
					}
					else 
					{
						JOptionPane.showMessageDialog(null,"No data found");
					}
					
					
					
				}
				catch(Exception e2)
				{
					System.out.println(e2);
				}
			repaint();
		}
		
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		ImageIcon img2=new ImageIcon("result.jpeg");
		Image s2=img2.getImage();
		g.drawImage(s2,0,0,this);
	}
	
}