package gobang_unfinished;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class choose_ipport extends JFrame{
	private static choose_ipport instance;
	public static choose_ipport getinstance(){
		if(instance==null)
			instance=new choose_ipport();
		return instance;
	}
	
	JPanel panel1=new JPanel();
	JPanel panel2=new JPanel();
	JPanel panel3=new JPanel();
	JLabel label1=new JLabel("������Է���IP��ַ��");
	JLabel label2=new JLabel("��������Ҫ���ӵĶ˿ںţ�");
	JTextArea area1=new JTextArea();
	JTextArea area2=new JTextArea();
	JButton sure=new JButton("����");
	
	private choose_ipport(){
		setBounds(500, 500, 800, 550);
		getContentPane().setLayout(new GridLayout(3,1));
		
		label1.setFont(new Font("����",Font.BOLD,25));
		label2.setFont(new Font("����",Font.BOLD,25));
		area1.setFont(new Font("����",Font.BOLD,25));
		area2.setFont(new Font("����",Font.BOLD,25));
		sure.setFont(new Font("����",Font.BOLD,25));
		
		label1.setPreferredSize(new Dimension(350,50));
		label2.setPreferredSize(new Dimension(350,50));
		area1.setPreferredSize(new Dimension(150,50));
		area2.setPreferredSize(new Dimension(150,50));
		sure.setPreferredSize(new Dimension(120,60));
		
		panel1.add(label1);
		panel1.add(area1);
		panel2.add(label2);
		panel2.add(area2);
		panel3.add(sure);
		
		getContentPane().add(panel1);
		getContentPane().add(panel2);
		getContentPane().add(panel3);
		
		sure.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(area1.getText().length()==0&&area2.getText().length()==0)
					JOptionPane.showMessageDialog(null, "������Է���IP��ַ�Ͷ˿ںţ�");
				else if(area1.getText().length()==0)
					JOptionPane.showMessageDialog(null, "������Է���IP��ַ��");
				else if(area2.getText().length()==0)
					JOptionPane.showMessageDialog(null, "������˿ںţ�");
				else {
					String ip=area1.getText();
					NetHelper.getinstance().connect(ip);
				}
			}
		});
	}
}
