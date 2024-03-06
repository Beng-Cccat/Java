package sql;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StartView extends JFrame{
	private static StartView instance=new StartView();
	public static StartView getinstance(){
		return instance;
	}
	private JPanel panel=new JPanel();
	private JButton workersbutton=new JButton("Ա����Ϣ����");
	private JButton commoditybutton=new JButton("��Ʒ��Ϣ����");
	private JLabel welcome=new JLabel("��ӭ�������й���ϵͳ��",JLabel.CENTER);
	
	StartView(){
		setLayout(new GridLayout(2,1));
		panel.setLayout(new FlowLayout(FlowLayout.CENTER,250,80));
		
		welcome.setFont(new Font("����",Font.BOLD,50));
		workersbutton.setFont(new Font("����", Font.BOLD, 20));
		commoditybutton.setFont(new Font("����", Font.BOLD, 20));
		
		workersbutton.setPreferredSize(new Dimension(200,100));
		commoditybutton.setPreferredSize(new Dimension(200,100));
		
		workersbutton.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent arg0){
				employee emee=employee.getinstance();
				emee.setVisible(true);
				
			}
		});
		commoditybutton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				commodity comm;
				try {
					comm = new commodity();
					comm.setVisible(true);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			}
		});
		
		panel.add(workersbutton);
		panel.add(commoditybutton);

		getContentPane().add(welcome);
		getContentPane().add(panel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}
