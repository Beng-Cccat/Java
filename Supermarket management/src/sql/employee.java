package sql;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class employee extends JFrame{
	private static employee instance=new employee();
	public static employee getinstance(){
		return instance;
	}
	JPanel panel1=new JPanel(new BorderLayout());
	JPanel panel2=new JPanel();
	JPanel panel3=new JPanel();
	JPanel panel4=new JPanel();
	JPanel panel5=new JPanel();
	JPanel panel6=new JPanel();
	JPanel panel7=new JPanel();
	JLabel label1=new JLabel("Ա����Ϣ���£�");
	
	JButton[] buttonall=new JButton[4];
	JLabel[] labelall=new JLabel[11];
	JTextField[] tfall=new JTextField[11];
	
	JTable ta;
	TableModel update_ta;
	
	String[] title={"���Ա����Ϣ","ɾ��Ա����Ϣ","����Ա����Ϣ","��ѯԱ����Ϣ"};
	String[] columnNames = {"Ա��������", "Ա����ţ�", "Ա���Ա�", "���֤�ţ�","Ա�����䣺","�������ƣ�","��ϵ��ʽ��","ְλ��","н�ʣ�","���ű�ţ�"};
	Object[][] rowData = new Object[50][11];
	String[] content=new String[11];
	
	public employee(){
		setBounds(50, 50, 2100, 1000);
		setLayout(new BorderLayout());
		init();

	}

	private void init(){
		this.setLayout(new BorderLayout());
		panel7.setLayout(new GridLayout(1,2));
		panel7.add(getleftpanel());
		panel7.add(getrightpanel());
		this.getContentPane().add(panel7,BorderLayout.CENTER);
		this.getContentPane().add(new JPanel(),BorderLayout.EAST);
		this.getContentPane().add(new JPanel(),BorderLayout.NORTH);
		this.getContentPane().add(new JPanel(),BorderLayout.WEST);
	}

	private void getTableText(Object[][] rowData,int choice){
		switch(choice){
			case 1:
				Helper.getinstance().settext(rowData,1,"");
				break;
			case 2:
				Helper.getinstance().settext(rowData,3,tfall[1].getText());
				break;
				default:
		}
		
	}
	private JPanel gettablepanel(){
		getTableText(rowData,1);
		ta=new JTable(rowData,columnNames);
		ta.setFont(new Font("����", Font.BOLD, 15));
		ta.setIntercellSpacing(new Dimension(0,1));
		ta.getColumnModel().getColumn(0).setPreferredWidth(70);
		ta.setRowHeight(30);
		ta.setEnabled(false);
		
		JScrollPane sp = new JScrollPane();
		sp.setViewportView(ta);
		sp.setOpaque(false);
		sp.getViewport().setOpaque(false);
		//sp.setPreferredSize(new Dimension(800,700));
		
		panel1.add(ta.getTableHeader(),BorderLayout.NORTH);
		panel1.add(sp,BorderLayout.CENTER);
		return panel1;
	}
	private JPanel getleftpanel(){
		panel2.setLayout(new BorderLayout());
		panel2.add(label1,BorderLayout.NORTH);
		panel2.add(gettablepanel(),BorderLayout.CENTER);
		label1.setPreferredSize(new Dimension(100,100));
		label1.setFont(new Font("����", Font.BOLD, 27));
		
		return panel2;
	}
	private JPanel getrightpanel(){
		panel6.setLayout(new GridLayout(12,1));
		for(int i=0;i<1;i++)
			panel6.add(new JPanel());

		for(int i=0;i<8;i++){
			labelall[i]=new JLabel(columnNames[i],JLabel.LEFT);
			labelall[i].setFont(new Font("����", Font.BOLD, 25));
			labelall[i].setPreferredSize(new Dimension(200, 50));
			tfall[i]=new JTextField();
			tfall[i].setPreferredSize(new Dimension(300,40));
			tfall[i].setFont(new Font("����", Font.BOLD, 20));
			tfall[i].setText("");;
			JPanel newpanel=new JPanel();
			newpanel.add(labelall[i]);
			newpanel.add(tfall[i]);
			panel6.add(newpanel);
		}
		
		panel4.setLayout(new FlowLayout(FlowLayout.CENTER,70,10));
		panel5.setLayout(new FlowLayout(FlowLayout.CENTER,70,10));
		for(int i=0;i<4;i++){
			buttonall[i]=new JButton(title[i]);
			buttonall[i].setFont(new Font("����", Font.BOLD, 20));
			buttonall[i].setPreferredSize(new Dimension(250, 55));
		}
		panel4.add(buttonall[0]);
		panel4.add(buttonall[1]);
		panel5.add(buttonall[2]);
		panel5.add(buttonall[3]);
		
		buttonall[0].addActionListener(new change(1));
		buttonall[1].addActionListener(new change(2));
		buttonall[2].addActionListener(new change(3));
		buttonall[3].addActionListener(new change(4));
		
		panel6.add(panel4);
		panel6.add(panel5);
		/*for(int i=0;i<1;i++)
			panel6.add(new JPanel());*/
		return panel6;
	}

	public void reshow() {
		getTableText(rowData,1);
		update_ta=new DefaultTableModel(rowData, columnNames);
		ta.setModel(update_ta);
	}
	void setContent(change newchange) {
		String[] object=new String[11];
		for(int i=0;i<8;i++){
			object[i]=tfall[i].getText();
		}
		for(int i=0;i<8;i++){
			newchange.setcontent(object);
		}
	}

	public void reshow_select() {
		getTableText(rowData,2);
		for(int i=0;i<9;i++){
			System.out.println(rowData[i][3]);
		}
		update_ta=new DefaultTableModel(rowData, columnNames);
		ta.setModel(update_ta);
		
	}
	public void setfindtext(String text){
		buttonall[3].setText(text);
	}
	
}
 