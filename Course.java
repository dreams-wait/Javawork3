
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
		System.out.println("�γ����ƣ� "+this.cName);
		System.out.println("�γ�ѧʱ�� "+this.cTime );
		System.out.println("�γ�Ҫ�� "+this.cRequire);
		System.out.println("�γ����ݣ� "+this.cContent);
		System.out.println("���˷�ʽ�� "+this.cMode);
	}
}
