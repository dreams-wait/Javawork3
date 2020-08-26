import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Student {
	String sUseName;
	String sPassword;
	String sName;
	int sAge;
	String sSex;
	String sMajor;
	String sClass;
	String sNum;
	listCourse LC;
	LiseStuCou stc;
	LIST oneLC;
	Enter enter1;
	LIST list1;
	LIST list2;
	LIST list3;

	public Student(String inUseName,String inPassword,String inName,int inAge,String inSex,String inMajor,String inNum,String inClass) 
	{
		this.sUseName  = inUseName;
		this.sPassword = inPassword;
		this.sName = inName;
		this.sAge = inAge;
		this.sSex = inSex;
		this.sMajor = inMajor;
		this.sClass = inClass;
		this.sNum = inNum;
		stc=new LiseStuCou();
		oneLC = new LIST();
		enter1 = null;
		list1 = new LIST();
		list2 = new LIST();
		list3 = new LIST();
	}

    public Student() {
		// TODO Auto-generated constructor stub
	}

	public String getUseName() {
        return sUseName;
    }
 
    public void setUseName(String useName) {
        this.sUseName = useName;
    }
 
    public String getPassword() {
        return sPassword;
    }
 
    public void setPassword(String password) {
        this.sPassword = password;
    }
 
    public String getName() {
        return sName;
    }
 
    public void setName(String name) {
        this.sName = name;
    }
 
    public int getAge() {
        return sAge;
    }
 
    public void setAge(int age) {
        this.sAge = age;
    }
    public String getSex() {
        return sSex;
    }
 
    public void setSex(String sex) {
        this.sSex = sex;
    }
    public String getMajor() {
        return sMajor;
    }
 
    public void setMajor(String major) {
        this.sMajor = major;
    }

    public String getClass1() {
        return sMajor;
    }
 
    public void setClass(String class1) {
        this.sClass = class1;
    }
    public String getNum() {
        return sNum;
    }
 
    public void setNum(String num) {
        this.sNum = num;
    }
    
	public String denglu()
	{
		Scanner in = new Scanner(System.in);
		String strCon = "com.mysql.cj.jdbc.Driver";
		String strURL = "jdbc:mysql://localhost:3306/javawork?serverTimezone=UTC";
		String userName = "root";
		String userPass = "root";
		String strSql = "select * from course";
		String sSql = "select * from student";
		String Sql = "select * from studentcourse";
		String iName = null;
		String iPassword = null;
		String ii ="java";
		try {
		Class .forName(strCon);
		Connection con = DriverManager.getConnection(strURL,userName,userPass);
		Statement stmt = con.createStatement();
		int flag=0;
		//��¼�޸���Ϣ
		System.out.println("ѧ����¼ҳ��");
		System.out.println("���������ĵ�¼����");
		iName = in.nextLine();
		System.out.println("�������������룺");
		iPassword = in.nextLine();	
		ResultSet re = stmt.executeQuery(sSql);
		while(re.next()) 
		{
			String name1 = re.getString("name");
			String password1 = re.getString("password");
			if((iName.equals(name1))&&(iPassword.equals(password1)))
			{
				System.out.println("��¼�ɹ���");
				System.out.println("��ӭ��"+iName);
				flag=1;
				break;
			}
		}
		if(flag==0)
		{
			System.out.println("��¼ʧ�ܣ�������˺Ŵ���");
			return ii;
		}
		System.out.println("���������ѡ��    1.�޸���Ϣ    2��������ҳ��");
		int cc = in.nextInt();
		if(cc==1)
		{
			for(;;)
			{
				System.out.println("���������ѡ��");
				System.out.println("1.�޸��û���");
				System.out.println("2.�޸�����");
				System.out.println("3.�޸�����");
				System.out.println("4.�޸�רҵ");
				System.out.println("0.�˳��޸�");
				System.out.println("ע��������Ϣ�������޸�");
				int cc1 = in.nextInt();
				if(cc1 == 1)
				{
					System.out.println("�������û�����");
					String name4 = in.nextLine();
					String sql = "update student set usename = 'name4'";
					PreparedStatement presta = con.prepareStatement(sql);
					presta.execute();
				}
				if(cc1 == 2)
				{
					System.out.println("���������룺");
					String password4 = in.nextLine();
					String sql = "update student set password = 'password4'";
					PreparedStatement presta = con.prepareStatement(sql);
					presta.execute();
				}
				if(cc1 == 3)
				{
					System.out.println("������������");
					String name4 = in.nextLine();
					String sql = "update student set name = 'name4'";
					PreparedStatement presta = con.prepareStatement(sql);
					presta.execute();
				}
				if(cc1 == 4)
				{
					System.out.println("������רҵ��");
					String major4 = in.nextLine();
					String sql = "update student set major = 'major4'";
					PreparedStatement presta = con.prepareStatement(sql);
					presta.execute();
				}
				if(cc1 == 0)
				{
					break;
				}		
			}
		}
		re.close();
		stmt.close();
		con.close();
		} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}	
		return iName;
    }
	
	
	public void print1()
	{
		String strCon = "com.mysql.cj.jdbc.Driver";
		String strURL = "jdbc:mysql://localhost:3306/javawork?serverTimezone=UTC";
		String userName = "root";
		String userPass = "root";
		String strSql = "select * from course";
		try {
		Class .forName(strCon);
		Connection con1 = DriverManager.getConnection(strURL,userName,userPass);
		Statement stmt1 = con1.createStatement();
		ResultSet r1 = stmt1.executeQuery(strSql);
		System.out.println("��ѧ�ڿγ���Ϣ��");
		while(r1.next())
		{
			int Audio = r1.getInt("audit");
			if(Audio==1)
			{
				String Name = r1.getString("name");
				String Time = r1.getString("time");
				String Require = r1.getString("require");
				String Content = r1.getString("content");
				String Mode = r1.getString("mode");
				String Teacher = r1.getString("teacher");
				int count1 = r1.getInt("count");
				
				System.out.println("�γ���: " + Name +"  ��ʱ�� "+Time+" Ҫ��"+Require+" ���ݣ�"+Content+" ���ˣ�"+Mode+"  ������ʦ��"+Teacher+" ��ѡѧ������"+count1);
				}
			}
		r1.close();
		stmt1.close();
		con1.close();
		} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		}
	
	//ѡ��
	public void chclass(String name1) {
		 @SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
			String strCon = "com.mysql.cj.jdbc.Driver";
			String strURL = "jdbc:mysql://localhost:3306/javawork?serverTimezone=UTC";
			String userName = "root";
			String userPass = "root";
			String Sql = "select * from studentcourse";
			String strSql = "select * from course";
			String sSql = "select * from student";
			list1 = new LIST();
			list2 = new LIST();
			list3 = new LIST();
//			list1=null;
			String NUM1 = null;
			String xx =name1;
			String cname3 = null;
			int Sum=0;
			try {
			Class .forName(strCon);
			Connection con = DriverManager.getConnection(strURL,userName,userPass);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(Sql);
			while(rs.next())
			{
				String CName = rs.getString("coursename");
				String USEName = rs.getString("studenntname");
				String Num = rs.getString("studentnum");
				Enter enter1 = new Enter(USEName,CName,Num);

				if(xx.equals(USEName))
				{
					this.list1.addEnter(enter1);//��¼��¼ͬѧ��ѡ�γ�
				}	
				Sum++;
			}
			
			System.out.println("���Ѿ�ѡ�˵Ŀγ̣�");
			list1.print();
			rs.close();
			ResultSet rr = stmt.executeQuery(strSql);
			while(rr.next())
			{
				
				String CName = rr.getString("name");
				String mode1 = rr.getString("mode");
				String teacher1 = rr.getString("teacher");
//				enter1.cname  = CName;
//				enter1.name = mode1;
//				enter1.num = teacher1;
				Enter enter1 = new Enter(mode1,CName,teacher1);
				list2.addEnter(enter1);//��¼���пγ�	List����ѭ���洢����ʱ������ѭ���󼯺���ȫ�����ݶ������һ�������
			}

			
			rr.close();		
			list3=list2;
			for(int j1=0;j1<list1.size();j1++)
			{
				for(int s=0;s<list2.size();s++)
				{
//					 temp1 =new Enter();
//					 Enter temp2 =new Enter();
					Enter temp1 =list2.get(s);
					Enter temp2 =list1.get(j1);
					if((temp1.cname).equals(temp2.cname))
					{
						list3.remove(temp1); 
						break;
					}
				}
			}
			int flag=0;
			System.out.println("ѡ��Ŀ¼");
			System.out.println("�����ѡ�Ŀγ̣�");
			list3.print();
			if(list3.size()==0)
			{
				System.out.println("��Ŀǰû�п���ѧϰ�Ŀγ̣����˳�����");
				System.exit(0);
			}
			else
			{
				for(;;) 
				{
					System.out.println("������Ҫѧϰ�Ŀγ̣�");
					cname3 = in.nextLine();
					for(int j2=0;j2<list3.size();j2++)
					{
						if((list3.get(j2).cname).equals(cname3))
						{
							System.out.println("�����ɹ�"+list3.get(j2).cname);
							flag = 1;
							break;
						}
						else
						{
							System.out.println("û�д˿γ̣�������������Ҫѧϰ�Ŀγ̣�");
							cname3 = in.nextLine();
						}			
					}
					if(flag == 1)
					{
						break;
					}
				}
			}
			ResultSet r2 = stmt.executeQuery(sSql);
			while(r2.next())
			{
				String Name1 = r2.getString("name");
				String Num1 = r2.getString("num");
				if(Name1.equals(xx))
				{
					NUM1 = Num1;
				}
			}
			Sum=Sum+1;
			r2.close();
			if(flag==1) 
			{
				System.out.println("����¼�����ݿ�");
				ResultSet r1 = stmt.executeQuery(Sql);
				String sql = "insert into studentcourse(coursename,studenntname,studentnum,sum) values('"+cname3+"','"+xx+"','"+NUM1+"','"+Sum+"')";
				PreparedStatement presta = con.prepareStatement(sql);
				presta.execute();
				r1.close();
				System.out.println("��ϲ�㣡�ɹ�ѡѧ  "+cname3);
			}
			list1.clear();
			list2.clear();
			list3.clear();
			stmt.close();
			con.close();
			} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}	
	    }
	public  void login()
	{
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		String strCon = "com.mysql.cj.jdbc.Driver";
		String strURL = "jdbc:mysql://localhost:3306/javawork?serverTimezone=UTC";
		String userName = "root";
		String userPass = "root";
		String strSql = "select * from student";
		String usename1,password1,name1,sex1,major1,num1,class1;
		int age1;
		try {
		Class .forName(strCon);
		Connection con1 = DriverManager.getConnection(strURL,userName,userPass);
		Statement stmt1 = con1.createStatement();
		ResultSet r1 = stmt1.executeQuery(strSql);
		System.out.println("����������û�����");
		usename1 = in.nextLine();
		System.out.println("������������룺");
		password1 = in.nextLine();
		System.out.println("�����������ʵ������");
		name1 = in.nextLine();
		System.out.println("���������רҵ��");
		major1 = in.nextLine();
		System.out.println("����������Ա�");
		sex1 = in.nextLine();
		System.out.println("���������ѧ�ţ�");
		num1 = in.nextLine();
		System.out.println("��������İ༶��");
		class1 = in.nextLine();
		System.out.println("������������䣺");
		age1 = in.nextInt();
		while(r1.next()) 
		{
			String snum = r1.getString("num");
			while(snum.equals(num1))
			{
				System.out.println("�������ѧ�Ŵ������������룺");
				num1 = in.nextLine();
			}
		}
		System.out.println("����¼�����ݿ�");
		String sql = "insert into student(usename,password,name,age,sex,major,num,class) values('"+usename1+"','"+password1+"','"+name1+"','"+age1+"','"+sex1+"','"+major1+"','"+num1+"','"+class1+"')";
		PreparedStatement presta = con1.prepareStatement(sql);
		presta.execute();
		r1.close();
		System.out.println("��ϲ�㣡ע��ɹ� "+name1);
		stmt1.close();
		con1.close();
		} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}	
	}
}




