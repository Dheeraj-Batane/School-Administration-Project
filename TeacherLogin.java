import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class TeacherLogin extends JPanel implements  KeyListener,ItemListener
{
	
	
	JButton b1,b2;
	JTextField tx1;
	JPasswordField tx2;
	Font f;
	JCheckBox cb1;
	TeacherLogin()
	{
		setLayout(null);
		Font f=new Font("",Font.BOLD,30);
		setFont(f);
		
		
		
		tx1=new JTextField("Username");
		tx1.setSize(308,35);
		tx1.setLocation(195,226);
		add(tx1);
		tx1.setForeground(Color.gray);
		tx1.addKeyListener(this);
		
		
		
		tx2=new JPasswordField("Enter ID");
		tx2.setSize(308,35);
		tx2.setLocation(195,272);
		tx2.setEchoChar((char)0);
		add(tx2);
		tx2.setForeground(Color.gray);
		tx2.addKeyListener(this);
		
		cb1=new JCheckBox("Show ID");
		cb1.setSize(175,20);
		cb1.setLocation(196,318);
		add(cb1);
		cb1.addItemListener(this);
		
		b1=new JButton("Login");
		b1.setSize(308,38);
		b1.setLocation(196,366);
		add(b1);
		
		
		b2=new JButton("Home");
		b2.setBounds(620,0,80,20);
		add(b2);
		b2.setBackground(Color.red);
		b2.setForeground(Color.white);
		
		
		
		
	}
	public void keyReleased(KeyEvent e)
	{
		if(tx1.isFocusOwner())
		{
		
			String s1=tx1.getText().trim();
			if(s1.equals(""))
			{
				tx1.setText("Username");
				tx1.setForeground(Color.gray);
			}
		}
		if(tx2.isFocusOwner())
		{
		
			String s1=tx2.getText().trim();
			if(s1.equals(""))
			{
				tx2.setText("Enter ID");
				tx2.setForeground(Color.gray);
			}
		}
		
	}
	public void keyPressed(KeyEvent e)
	{
		if(tx1.isFocusOwner())
		{

			String s1=tx1.getText();
			if(s1.equals("Username"))
			{
				tx1.setText("");
				tx1.setForeground(Color.black);
			}
		}
		if(tx2.isFocusOwner())
		{

			String s1=tx2.getText();
			if(s1.equals("Enter ID"))
			{
				tx2.setForeground(Color.black);
				tx2.setText("");
				tx2.setEchoChar('*');
			}
		}
		
	}
	public void keyTyped(KeyEvent e)
	{
	}
	public void itemStateChanged(ItemEvent e)
	{
		if(cb1.isSelected())
		{
			// String s1=tx2.getText();
			tx2.setEchoChar((char)0);
			// tx2.setText(s1);
		}
		else
		{
			tx2.setEchoChar('*');
			
		}
		
	}	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		ImageIcon img2=new ImageIcon("login1.jpg");
		Image s2=img2.getImage();
		g.drawImage(s2,0,0,this);
	}
	
}
