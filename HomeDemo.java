import javax.swing.*;
import java	.awt.*;
import java	.awt.event.*;

class HomeDemo extends JPanel implements ActionListener
{
	JButton b1,b2,b3,b4;
	HomeDemo()
	{
		setLayout(null);
		
		b1=new JButton("Student Login");
		b1.setBounds(300,300,150,40);
		add(b1);
		
		b2=new JButton("Teacher Login");
		b2.setBounds(500,300,150,40);
		add(b2);
		
		// b3=new JButton("Admin");
		// b3.setBounds(370,360,200,40);
		// add(b3);
		
		b4=new JButton("Exit");
		b4.setBounds(620,0,70,20);
		b4.setBackground(Color.red);
		b4.setForeground(Color.white);
		add(b4);
		b4.addActionListener(this);
		
		
	}
	public void actionPerformed(ActionEvent e)
	{
		System.exit(0);
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		ImageIcon img1=new ImageIcon("home1.png");
		Image hm1=img1.getImage();
		g.drawImage(hm1,0,0,this);
		
		ImageIcon img2=new ImageIcon("home2.png");
		Image hm2=img2.getImage();
		g.drawImage(hm2,300,0,this);
		
		ImageIcon img3=new ImageIcon("home3.png");
		Image hm3=img3.getImage();
		g.drawImage(hm3,300,420,this);
		
		
	}
	
}