import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import javax.swing.JFrame;

public class Menu extends JFrame implements ActionListener{
	JFrame frame;
	JButton System = new JButton("选课系统");
	public Menu()
	{
		frame = new JFrame("选课系统");
		setTitle("选课系统");
		setLayout(null);
		System.setBounds(250,200,100,60);
		add(System);
		
		System.addActionListener(this);
		setVisible(true);
		setBounds(400,100,600,600);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == System);
		{
			new system();
			this.dispose();
		}
		
	}
	
}
