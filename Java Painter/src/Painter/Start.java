package Painter;

import java.awt.BorderLayout;

import javax.swing.JFrame;
/**
 * �����࣬�����ܣ������������״�����������ͻ�����壬Ȼ����ʾ
 * @author flower
 *
 */
public class Start {
	public static void main(String[] args) {
		JFrame f = new JFrame("Java Painter");
		f.setSize(800,600);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		f.getContentPane().add(Vars.shapeBar,BorderLayout.WEST);
		f.getContentPane().add(Vars.toolPanel,BorderLayout.NORTH);
		f.getContentPane().add(Vars.paintPanel,BorderLayout.CENTER);
		
		f.setVisible(true);
	}
}
