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
				System.out.println("/********操作菜单**********/");
				System.out.println("       1.管理员注册                        " );
				System.out.println("       2.管理员登录                           ");
				System.out.println("       3.老师注册                               ");
				System.out.println("       4.老师登录                               ");
				System.out.println("       5.学生注册                               ");
				System.out.println("       6.学生登录                               ");
				System.out.println("       0.退出程序                               ");
				System.out.println("/*********操作菜单*********/");
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
				System.out.println("无此权限！");
				
			}
			if(chioes==2)
			{
				Administrator ad1 = null;
				ad1.getConn();					
				    
			}
			if(chioes==3)
			{
				//老师注册
				
				
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
				System.out.println("登录和修改信息：");
				Student s1 = new Student();
				String n=s1.denglu();
				if(n.equals(ss))
					break;
				int ch1;
				
				for(;;)
				{
					for(;;) 
					{
						System.out.println("|********操作菜单**********|");
						System.out.println("|       1.查看课程                       |");
						System.out.println("|       2.选课                               |");
						System.out.println("|       0.退出程序                        |");
						System.out.println("|************************|");
						System.out.println("|请输入您的选择：");
						ch1 = in.nextInt();
						if(ch1>=0&&ch1<=2)
						{
							break;
						}
						else
						{
							System.out.println("重新输入：");
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
						System.out.println("已退出！");
						System.exit(0);
					}
						
						
						
				}
			}//6
			
				
		}
	}
}
		
