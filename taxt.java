import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class taxt {

	public static void main(String[] args) {

		
		

		Scanner in = new Scanner(System.in);
		for(;;)
		{
			int chioes;
			for(;;) 
			{
				System.out.println("/********�����˵�**********/");
				System.out.println("       1.����Աע��                        " );
				System.out.println("       2.����Ա��¼                           ");
				System.out.println("       3.��ʦע��                               ");
				System.out.println("       4.��ʦ��¼                               ");
				System.out.println("       5.ѧ��ע��                               ");
				System.out.println("       6.ѧ����¼                               ");
				System.out.println("       0.�˳�����                               ");
				System.out.println("/*********�����˵�*********/");
				chioes = in.nextInt();
				if(chioes>=0&&chioes<=6)
				{
					break;
				}
			}
			if(chioes==0)
			{
				System.exit(0);
			}
			if(chioes==1)
			{
				System.out.println("�޴�Ȩ�ޣ�");
				
			}
			if(chioes==2)
			{
				Administrator ad1 = null;
				ad1.getConn();					
				    
			}
			if(chioes==3)
			{
				//��ʦע��
				
				
			}
			if(chioes==4)
			{
				
			}
			if(chioes==5)
			{
				Student s = null;
				s.login();
			}
			if(chioes==6)
			{//6
				String ss = "java";
				System.out.println("��¼���޸���Ϣ��");
				Student s1 = new Student();
				String n=s1.denglu();
				if(n.equals(ss))
					break;
				int ch1;
				
				for(;;)
				{
					for(;;) 
					{
						System.out.println("|********�����˵�**********|");
						System.out.println("|       1.�鿴�γ�                       |");
						System.out.println("|       2.ѡ��                               |");
						System.out.println("|       0.�˳�����                        |");
						System.out.println("|************************|");
						System.out.println("|����������ѡ��");
						ch1 = in.nextInt();
						if(ch1>=0&&ch1<=2)
						{
							break;
						}
						else
						{
							System.out.println("�������룺");
						}
					}
					if(ch1 == 1)
					{
						s1.print1();
					}
					if(ch1 == 2) 
					{
						s1.chclass(n);
					}
					if(ch1==0)
					{
						System.out.println("���˳���");
						System.exit(0);
					}
						
						
						
				}
			}//6
			
				
		}
	}
}
		
