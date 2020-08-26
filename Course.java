
public class Course {
	String cName;
	int cTime;
	String cRequire;
	String cContent;
	String cMode;
	int audit;
	int count=0;
	listCourse LC;
	public Course(String inName,int inTime,String inRequire,String inContent,String inMode) {
		this.cName = inName;
		this.cTime = inTime;
		this.cRequire = inRequire;
		this.cContent = inContent;
		this.cMode = inMode;
		this.audit = 0;
		LC = new listCourse();

		count++;
		
	}
	public void print(Course c1)
	{
		System.out.println("课程名称： "+this.cName);
		System.out.println("课程学时： "+this.cTime );
		System.out.println("课程要求： "+this.cRequire);
		System.out.println("课程内容： "+this.cContent);
		System.out.println("考核方式： "+this.cMode);
	}
}
