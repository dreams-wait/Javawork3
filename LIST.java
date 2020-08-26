import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LIST {
	List<Enter> list;
	
	public LIST()
	{
		this.list = new ArrayList<Enter>();
	}
	public void addEnter(Enter ss)
	{
		this.list.add(ss);
		
	}
	public void del1(Enter name)
	{
		for(int i=0;i<this.list.size();i++)
		{
			Enter tempStc = this.list.get(i);
			if(name.equals(tempStc))
			{
				this.list.remove(i);
			}
		}
	}
	public int size() {
		// TODO Auto-generated method stub
		return this.list.size();
	}
	public Enter get(int i) {
		// TODO Auto-generated method stub
		return this.list.get(i);
	}
	public void print()
	{
		for(int i=0;i<this.list.size();i++)
		{
			System.out.println("¿Î³ÌÃû£º   "+this.list.get(i).cname);
		}
	}
//	public void addALL(LIST list1,LIST list2) {
//		// TODO Auto-generated method stub
//		return list1.addALL(list2);
//	}
	public void remove(Enter temp1) {
		// TODO Auto-generated method stub
		this.list.remove(temp1);
	}
	public void clear() {
		// TODO Auto-generated method stub
		this.list.clear();
	}

}
