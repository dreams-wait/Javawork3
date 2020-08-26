import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;

public class Administrator {
	String aName;
	String aPassword;
//	static LIST ll;
	public void Administrator(String inname,String inpassword)
	{
		this.aName = inname;
		this.aPassword = inpassword;
//		ll = new LIST();
	}
	public String getUseName() {
		return aName;
		}
	public void setUseName(String name) {
		this.aName = name;
		}
	public String getPassword() {
		return aPassword;
		}
	public void setPassword(String password) {
		this.aPassword = password;
		}
	
	 public static void getConn() {
		 Scanner in = new Scanner(System.in);
			String strCon = "com.mysql.cj.jdbc.Driver";
			String strURL = "jdbc:mysql://localhost:3306/javawork?serverTimezone=UTC";
			String userName = "root";
			String userPass = "root";
			String strSql = "select * from course";
			String sSql = "select * from administrator";
			try {
			Class .forName(strCon);
			Connection con = DriverManager.getConnection(strURL,userName,userPass);
			Statement stmt = con.createStatement();
			ResultSet re = stmt.executeQuery(sSql);
			int flag=0;
			
			//登录
			System.out.println("管理员登录页面");
			System.out.println("请输入您的登录名：");
			String iName = in.nextLine();
			System.out.println("请输入您的密码：");
			String iPassword = in.nextLine();	
			while(re.next()) 
			{

//				Enter ee=null;
				String name1 = re.getString("name");
				String password1 = re.getString("password");
//				ee.name = name1;
//				ee.password = password1;
//				ll.addEnter(ee);
				if(iName.equals(name1)&&iPassword.equals(password1))
				{
					System.out.println("登录成功！");
					flag=1;
					break;
				}
			}
			if(flag==0)
			{
				System.out.println("登录失败！");
			}
			re.close();
			ResultSet rs = stmt.executeQuery(strSql);
			if(flag == 1) 
			{
//审核
				while(rs.next())
				{
				int Audio = rs.getInt("audit");
				if(Audio==0)
				{
					
					String Name = rs.getString("name");
					String Time = rs.getString("time");
					String Require = rs.getString("require");
					String Content = rs.getString("content");
					String Mode = rs.getString("mode");
					String Teacher = rs.getString("teacher");
					int Count = rs.getInt("count");
					
					//显示数据库内容
					System.out.println("课程名: " + Name +"  课时： "+Time+" 要求："+Require+" 内容："+Content+" 考核："+Mode+"  开办老师："+Teacher+" 数量："+Count);

					System.out.println("输入审核结果：1.审核通过    2审核不通过");
					Scanner inn = new Scanner(System.in);
					
					int choice = inn.nextInt();
					while(choice>2||choice<1)
					{
						
						System.out.println("请重新输入审核结果：1.审核通过    2审核不通过");
						choice = in.nextInt();
					}
					if(choice==1)
					{
						String sql = "update course set audit=1";
						PreparedStatement presta = con.prepareStatement(sql);
						presta.execute();
						System.out.println("已通过审核！");
					}
					else if(choice==2)
					{
						System.out.println("已拒绝申请！");
					}
						
				}

				}
			}
			

			rs.close();
			stmt.close();
			con.close();
			} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}	
			System.out.println("已全部审核结束！");
	    }
	    

}
