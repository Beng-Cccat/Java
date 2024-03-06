package Painter;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.plaf.basic.BasicArrowButton;
/**
 * ������壬�����Ҫ���õ�����϶࣬��ԱȽϸ��ӣ����������������Ƕ��
 * @author flower
 *
 */
public class ToolPanel extends JPanel {
	/**
	 * �����Ϸ�Ϊ�ĸ���壬���ϣ����£����ϣ�����
	 */
	private JPanel leftUpPanel = null;
	private JPanel leftDownPanel = null;
	private JPanel rightUpPanel = null;
	private JPanel rightDownPanel = null;

	/**
	 * ����ɫ��Ͽ����״��ɫ��Ͽ�
	 */
	private JComboBox<Color> backgroundColorComboBox = null;
	private JComboBox<Color> shapeColorComboBox = null;
	
	/**
	 * Ϊ����ɫ��Ͽ����״��ɫ��Ͽ�׼������ɫ��������
	 */
	private Color[] backgroundColors = { Color.white,Color.yellow, Color.red };
	private Color[] shapeColors = { Color.black,Color.yellow, Color.red };
	
	/**
	 * �Ƿ����checkbox
	 */
	private JCheckBox fillRegionCheckbox;
	/**
	 * ���ִ�С��壬�������"size"��ǩ���������
	 */
	private JPanel sizePanel;
	/**
	 * ������壬����������ִ�С�ı���ͼӼ���ť
	 */
	private JPanel numberPanel;
	/**
	 * �����������ֵ��ı���
	 */
	private JTextField stringTextField;
	/**
	 * ������ʾ���ִ�С���ı���
	 */
	private JTextField fontSizeTextField;
	/**
	 * ���õ������ִ�С�ļӼ���ť�����
	 */
	private JPanel basicArrowPanel;
	/**
	 * �������ִ�С�İ�ť
	 */
	private BasicArrowButton downBasicArrowButton;
	private BasicArrowButton upBasicArrowButton;

	/**
	 * ��ȡ������壬�ú���ʵ���ˡ������ء���
	 * ��һ�ε��ñ�����ʱ��leftDownPanel�϶�Ϊnull�����й��졣
	 * �Ժ���õ�ʱ��ֱ�ӷ��ض���
	 * @return
	 */
	public JPanel getLeftDownPanel() {
		if (leftDownPanel == null) {
			leftDownPanel = new JPanel();
			leftDownPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
			leftDownPanel.add(new JLabel("Background"));
			leftDownPanel.add(getBackgroundColorComboBox());
		}

		return leftDownPanel;
	}

	private JComboBox<Color> getBackgroundColorComboBox() {
		if (backgroundColorComboBox == null) {
			backgroundColorComboBox = new JComboBox<Color>(backgroundColors);
			backgroundColorComboBox.addItemListener(new ItemListener() {
				
				@Override
				public void itemStateChanged(ItemEvent e) {
					//ֻҪ��Ͽ���ѡ�ѡ���ˣ�������������㱨���޸ĵ���ɫ
					if (e.getStateChange()==ItemEvent.SELECTED) {
						Vars.paintControllor.setBackgroundColor((Color) backgroundColorComboBox.getSelectedItem());
					}
				}
			});
		}

		return backgroundColorComboBox;
	}

	public JPanel getLeftUpPanel() {
		if (leftUpPanel == null) {
			leftUpPanel = new JPanel();
			leftUpPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
			leftUpPanel.add(new JLabel("Shape Color"));
			leftUpPanel.add(getShapeColorComboBox());
		}
		return leftUpPanel;
	}

	public JComboBox<Color> getShapeColorComboBox() {
		if (shapeColorComboBox == null) {
			shapeColorComboBox = new JComboBox<Color>(shapeColors);
			shapeColorComboBox.addItemListener(new ItemListener() {
				
				@Override
				public void itemStateChanged(ItemEvent e) {
					//ֻҪ��Ͽ���ѡ�ѡ���ˣ�������������㱨���޸ĵ���ɫ
					if (e.getStateChange() == ItemEvent.SELECTED) {
						Vars.paintControllor.setShapeColor((Color) shapeColorComboBox.getSelectedItem());
					}
				}
			});
		}
		return shapeColorComboBox;
	}

	public JPanel getRightDownPanel() {
		if (rightDownPanel == null) {
			rightDownPanel = new JPanel(new GridLayout(1, 2));
			rightDownPanel.add(getSizePanel());
			rightDownPanel.add(getFillRegionCheckbox());
		}
		return rightDownPanel;
	}

	private JCheckBox getFillRegionCheckbox() {
		if (fillRegionCheckbox == null) {
			fillRegionCheckbox = new JCheckBox("Fill the region");
			fillRegionCheckbox.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					//ֻҪ�Ƿ����״̬�ı��ˣ�������������㱨��ǰ״̬
					Vars.paintControllor.setFillRegion(fillRegionCheckbox
							.isSelected());
				}
			});
		}

		return fillRegionCheckbox;
	}

	private JPanel getSizePanel() {
		if (sizePanel == null) {
			sizePanel = new JPanel(new GridLayout(1, 2));
			sizePanel.add(new JLabel("Size"));
			sizePanel.add(getNumberPanel());
		}

		return sizePanel;
	}

	private JPanel getNumberPanel() {
		if (numberPanel == null) {
			numberPanel = new JPanel(new BorderLayout());

			numberPanel.add(getNumberTextField(), BorderLayout.CENTER);
			numberPanel.add(getBasicArrowPanel(), BorderLayout.EAST);
		}

		return numberPanel;
	}

	private JPanel getBasicArrowPanel() {
		if (basicArrowPanel == null) {
			basicArrowPanel = new JPanel(new GridLayout(2, 1));
			basicArrowPanel.add(getUpBasicArrowButton());
			basicArrowPanel.add(getDownBasicArrowButton());
		}

		return basicArrowPanel;
	}

	private BasicArrowButton getDownBasicArrowButton() {
		if (downBasicArrowButton == null) {
			downBasicArrowButton = new BasicArrowButton(BasicArrowButton.SOUTH);
			downBasicArrowButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					//��ǰ���������������¼�ͷ��������������㱨�����С�޸�ֵΪ-1
					Vars.paintControllor.addFontSize(-1);
				}
			});

		}

		return downBasicArrowButton;
	}

	private BasicArrowButton getUpBasicArrowButton() {
		if (upBasicArrowButton == null) {
			upBasicArrowButton = new BasicArrowButton(BasicArrowButton.NORTH);
			upBasicArrowButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					//��ǰ���������������ϼ�ͷ��������������㱨�����С�޸�ֵΪ1
					Vars.paintControllor.addFontSize(1);
				}
			});

		}

		return upBasicArrowButton;
	}

	private JTextField getNumberTextField() {
		if (fontSizeTextField == null) {
			fontSizeTextField = new JTextField("10");

		}

		return fontSizeTextField;
	}

	public JPanel getRightUpPanel() {
		if (rightUpPanel == null) {
			rightUpPanel = new JPanel(new BorderLayout());
			rightUpPanel.add(new JLabel("Text"), BorderLayout.WEST);
			rightUpPanel.add(getStringTextField());
		}
		return rightUpPanel;
	}

	private JTextField getStringTextField() {
		if (stringTextField == null) {
			stringTextField = new JTextField("hello");
			stringTextField.addKeyListener(new KeyAdapter() {

				@Override
				public void keyPressed(KeyEvent e) {
					// ������ֻҪ�а������£�������������㱨��ǰ����������
					Vars.paintControllor.setText(stringTextField.getText()
							+ e.getKeyChar());
				}
			});
		}

		return stringTextField;
	}

	/**
	 * ���캯�������õ�ǰ���Ϊ2x2�Ĳ��֣����ֱ�����ĸ����
	 */
	public ToolPanel() {
		setLayout(new GridLayout(2, 2));
		add(getLeftUpPanel());
		add(getRightUpPanel());
		add(getLeftDownPanel());
		add(getRightDownPanel());
	}
	/**
	 * �������С�ı�����ʾ��ǰ�����С��
	 * �����������������ã�ֻҪ��������֪ͨ�����С���޸ģ��͵��ñ�����
	 */
	public void refreshFontSize() {
		fontSizeTextField.setText(Vars.paintControllor.getFontSize() + "");
	}

}
