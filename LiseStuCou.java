import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LiseStuCou {
	List<Enter> STC;
	public void listSTC()
	{
		this.STC = new ArrayList<Enter>();
	}
	public void addSTC(Enter ss)
	{
		this.STC.add(ss);
		
	}
	public void delSTC(String name)
	{
		for(int i=0;i<this.STC.size();i++)
		{
			Enter tempStc = this.STC.get(i);
			if(name.equals(tempStc))
			{
				this.STC.remove(i);
			}
		}
	}
	public static Connection getConn() {
		String strCon = "com.mysql.cj.jdbc.Driver";
		String strURL = "jdbc:mysql://localhost:3306/javawork?serverTimezone=UTC";
		String userName = "root";
		String userPass = "root";
		String strSql = "select * from studentcourse";
		
		try {
		Class .forName(strCon);
		Connection con = DriverManager.getConnection(strURL,userName,userPass);
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(strSql);
		System.out.println("ѡ����Ϣ");
		while(rs.next())
		{
		String UseName = rs.getString("coursename");
		String Name = rs.getString("studenntname");
		int Num = rs.getInt("studentnum");
		int s = rs.getInt("sum");
		//��ʾ���ݿ�����
		System.out.println("��Ŀ: " + UseName +" ѧ�������� "+Name+"  ѡ��ѧ��ѧ�ţ�"+Num+"  ѡ�����˴Σ�"+s);
		}
		rs.close();
		stmt.close();
		con.close();
		} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		return null;
    	
    }
}
