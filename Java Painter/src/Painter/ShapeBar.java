package Painter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JToolBar;

/**
 * ����������״ѡ�������̳���JToolBar�������ϳ���
 * @author flower
 *
 */
public class ShapeBar extends JToolBar{
	/**
	 * Բ�ΰ�ť��Ĭ��Ϊnull����һ������getCircleButton����ʱ���й���
	 */
	private JButton circleButton;
	private JButton ovalButton;
	private JButton rectButton;
	private JButton lineButton;
	private JButton stringButton;
	/**
	 * ��ȡԲ�ΰ�ť�ĺ�����������ʹ���ˡ������ء���
	 * ����һ�ε��ñ�����circleButton��ȻΪnull���ʹ���ð�ť���󣬲��Ըð�ť���Ӽ�������
	 * ��������Ψһ����������������㱨�����ť������
	 * ������ť�������Ƶķ���
	 * @return
	 */
	public JButton getCircleButton() {
		if(circleButton==null){
			circleButton = new JButton("yuan");
			circleButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					Vars.paintControllor.setCurrentShape(PaintModel.CIRCLE);
				}
			});
		}
		return circleButton;
	}
	public JButton getOvalButton() {
		if(ovalButton==null){
			ovalButton = new JButton("oval");
			ovalButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					Vars.paintControllor.setCurrentShape(PaintModel.OVAL);
				}
			});
		}
		return ovalButton;
	}
	public JButton getRectButton() {
		if(rectButton==null){
			rectButton = new JButton("rect");
			rectButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					Vars.paintControllor.setCurrentShape(PaintModel.RECT);
				}
			});
		}
		return rectButton;
	}
	public JButton getLineButton() {
		if (lineButton == null) {
			lineButton = new JButton("line");
			lineButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					Vars.paintControllor.setCurrentShape(PaintModel.LINE);
				}
			});
		}

		return lineButton;
	}
	public JButton getStringButton() {
		if (stringButton == null) {
			stringButton = new JButton("string");
			stringButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					Vars.paintControllor.setCurrentShape(PaintModel.STRING);
				}
			});
		}

		return stringButton;
	}
	/**
	 * ���캯�������ñ��������İڷŷ�ʽΪ����
	 * ������Ӹ���ť
	 */
	public ShapeBar() {
		setOrientation(JToolBar.VERTICAL);
		add(getCircleButton());
		add(getOvalButton());
		add(getRectButton());
		add(getLineButton());
		add(getStringButton());
	}
}
