import javax.swing.table.AbstractTableModel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ColumnModelTest{
     
    public ColumnModelTest() {
    
   	JFrame f = new JFrame();
   /*�������ǵ�MyTable��̳���AbstractTableModel����ʵ����getColmunCount(),getRowCount(),getValueAt()����.������ǿ���ͨ
    *��MyTable������TableModel��ʵ��.
    */ 
   	MyTable mt=new MyTable();
   	JTable t=new JTable(mt);//��������MyTable������JTable.
   	JComboBox c = new JComboBox();//����һ��JComboBox�Ķ���.
//   	c.addItem("Taipei");//�������½�����JComboBox����������������Ŀ.
//   	c.addItem("ChiaYi");
//   	c.addItem("HsinChu");
    /*��������JTable���ṩ��getTableColumnModel()����ȡ��TableColumnModel����,����TableColumnModel�����ṩ��getColumn()��
     *��ȡ��TableColumn����,TableColumn�����Ա���е�ÿһ�������������,���������ֶεĿ��,ĳ�еı�ͷ,��������ϸ��ӵ�
     *�������͵ȵ�.������,��������TableColumn�����ṩ��setCellEditor()����,��JComboBox��Ϊ�ڶ��е�Ĭ�ϱ༭���.
     */
   	t.getColumnModel().getColumn(1).setCellEditor(new DefaultCellEditor(c));
   	t.setPreferredScrollableViewportSize(new Dimension(550, 200));//��С
    Point p = new Point(100, 100);
    f.setLocation(p);//λ��
        JScrollPane s = new JScrollPane(t);
//        f.setBounds(x, y, width, height);
        f.getContentPane().add(s, BorderLayout.CENTER);
	    f.setTitle("ColumnModelTest");
        f.pack();
        f.setVisible(true);
        
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public static void main(String args[]) {
    
        new ColumnModelTest();
    }
      
}

class MyTable extends AbstractTableModel{

        Object[][] p = {
            {"����", "Taipei",new Integer(66), 
              new Integer(32), new Integer(98), new Boolean(false),new Boolean(false)},
            {"����", "ChiaYi",new Integer(85), 
              new Integer(69), new Integer(154), new Boolean(true),new Boolean(false)},          
        };

        String[] n = {"����", 
        	         "��ס��",
                      "����",
                      "��ѧ",
                      "�ܷ�",
                      "����",			         
                      "����"};
    
        public int getColumnCount() {
            return n.length;
        }

        public int getRowCount() {
            return p.length;
        }

        public String getColumnName(int col) {
            return n[col];
        }

        public Object getValueAt(int row, int col) {
            return p[row][col];
        }
	    public Class getColumnClass(int c) {
        	return getValueAt(0, c).getClass();
    	}
	    /*public boolean isCellEditable(int rowIndex, int columnIndex) {
		    return true;	
    	}
	    public void setValueAt(Object value, int row, int col) {
        	p[row][col] = value;
		    fireTableCellUpdated(row, col);
    	}*/
}
