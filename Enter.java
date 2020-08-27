import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Enter extends JFrame implements ActionListener{
	Connection con;
	String Name;
	String teacher1 = "teacher",student1 = "student",administrator1 = "administrator";
	JFrame frame; 
	Statement stmt;

	JLabel usename = new JLabel("�û���");
	JLabel password=new JLabel("����");

	JTextField usename1 = new JTextField(10);
	JTextField password1 = new JTextField(10);
	
	JButton yes = new JButton("ȷ��");
	JButton no  = new JButton("����");
	JButton retur  = new JButton("����");
	JButton add = new JButton("ע��");
	public Enter(String name)
	{
		Name = name;
		frame=new JFrame("ϵͳ��¼");
		setTitle("ϵͳ��¼");
		setLayout(null);
		
		usename.setBounds(100,150,100,50);
		usename1.setBounds(200,160,200,30);
		password.setBounds(100,200,100,50);
		password1.setBounds(200,210,200,30);
		yes.setBounds(10,350, 100, 50);
		no.setBounds(150, 350, 100,50);
		retur.setBounds(290, 350, 100, 50);
		add.setBounds(430, 350, 100, 50);
		
		add(usename);
		add(usename1);
		add(password);
		add(password1);
		add(yes);
		add(no);
		add(retur);
		add(add);
		add.addActionListener(this);
		yes.addActionListener(this);
		no.addActionListener(this);
		retur.addActionListener(this);
		
		setVisible(true);
		setBounds(400,100,600,600);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource()==no)
		{
			new system();
			this.dispose();
		}
		if(e.getSource()==retur)
		{
			usename1.setText("");
			password1.setText("");
		}
		if(e.getSource()==add)
		{
			if(Name.equals(student1))
			{
				new AddStudent();
				this.dispose();
			}
			if(Name.equals(teacher1))
			{
				new AddTeacher();
				this.dispose();
			}
		}
		if(e.getSource()==yes)
		{
			

			String strCon = "com.mysql.cj.jdbc.Driver";
			String strURL = "jdbc:mysql://localhost:3306/javawork?serverTimezone=UTC";
			String userName = "root";
			String userPass = "root";
			String tSql = "select * from teacher1";
			String sSql = "select * from student";
			String Sql = "select * from administrator";
			try {
			Class .forName(strCon);
			Connection con = DriverManager.getConnection(strURL,userName,userPass);
			Statement stmt = con.createStatement();
			int flag=0;
			String str1=usename1.getText();
			String str2=password1.getText();
			if(Name.equals(student1))
			{
				ResultSet re = stmt.executeQuery(sSql);
				while(re.next()) 
				{
					String name2 = re.getString("usename");
					String password2 = re.getString("password");
					if((str1.equals(name2))&&(str2.equals(password2)))
					{
						System.out.println("ѧ����¼�ɹ���");
						System.out.println("��ӭ��"+str1);
						flag=1;
						re.close();
						new Student(str1);
						dispose();
						break;
					}
				}
				if(flag==0)
				{
					System.out.println("��¼ʧ�ܣ�������˺Ŵ���");
					re.close();
					new system();
					this.dispose();
				}
			}
			if(Name.equals(administrator1))
			{
				ResultSet ra = stmt.executeQuery(Sql);
				while(ra.next()) 
				{

					String name2 = ra.getString("name");
					String password2 = ra.getString("password");
					if(str1.equals(name2)&&str2.equals(password2))
					{
						System.out.println("����Ա��¼�ɹ���");
						flag=1;
						ra.close();
						new Administrator();
						this.dispose();
						break;
					}
				}
				if(flag==0)
				{
					ra.close();
					System.out.println("����Ա��¼ʧ�ܣ�������˺Ŵ���");
					new system();
					this.dispose();
				}
			}
				
			if(Name.equals(teacher1))
			{
				ResultSet rt = stmt.executeQuery(tSql);
				while(rt.next()) 
				{

					String name2 = rt.getString("usename");
					String password2 = rt.getString("password");
					if(str1.equals(name2)&&str2.equals(password2))
					{
						System.out.println("��ʦ��¼�ɹ���");
						flag=1;
						rt.close();
						new Teacher(str1);
						this.dispose();
						break;
					}
				}
				if(flag==0)
				{
					System.out.println("��ʦ��¼ʧ�ܣ� ������˺Ŵ���");
					rt.close();
					new system();
					this.dispose();
				}
			}
			stmt.close();
			con.close();
			} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			}	
			
		}
	}
}
