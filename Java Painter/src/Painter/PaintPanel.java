package Painter;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JPanel;
/**
 * ������壬����������벢�㱨������������PaintControllor��������ģ�Ͷ���PaintModel�е���״������ƽ���
 * @author flower
 *
 */
public class PaintPanel extends JPanel {
	/**
	 * ��갴�º�̧���������
	 */
	private Point p1, p2;
	/**
	 * ���캯�����������ǰ��������������
	 */
	public PaintPanel() {
		addMouseListener(new MouseAdapter() {
			/**
			 * ��갴�µ�ʱ����������㱨��갴�£�������Ӧ�ý��õ㱣�浽p1
			 */
			@Override
			public void mousePressed(MouseEvent e) {
				p1 = e.getPoint();
				Vars.paintControllor.reportMousePointPressed(p1);
			}
			/**
			 * ���̧���ʱ����������㱨��갴�º�̧�������㣬������Ӧ�ý�������ֱ𱣴浽p1��p2
			 */
			@Override
			public void mouseReleased(MouseEvent e) {
				p2 = e.getPoint();
				repaint();
				Vars.paintControllor.reportMousePoint(p1, p2);
			}
		});
		addMouseMotionListener(new MouseMotionAdapter() {
			/**
			 * ����϶���ʱ����������㱨��ǰ�㣬������Ӧ�ý��õ㱣��Ϊp2�����ͬʱ��ˢ�½��棬ǿ�Ƶ�ǰ���ڻ��Ƶ���״ˢ��
			 */
			@Override
			public void mouseDragged(MouseEvent e) {
				p2 = e.getPoint();
				Vars.paintControllor.reportMousePointRelease(p2);
				repaint();
			}
		});
	}

	/**
	 * ���Ǹ���ķ�������ʾӦ�û��Ƶ�������״
	 */
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		//���õ�ǰ��岻͸��
		setOpaque(true);
		//���ݿ������ı���ɫ��ֵ���޸ı����ı���ɫ
		setBackground(Vars.paintControllor.getBackgroundColor());
		//��ģ���л��Ҫ���Ƶ���״������
		int size = Vars.paintModel.getShapeSize();
		//���δ�ģ���л���������������״������������
		for (int i = 0; i < size; i++) {
			Shape shape = Vars.paintModel.getShape(i);
			drawShape(shape, g);
		}
		//���Ƶ�ǰ���ڻ��Ƶ���״
		drawCurrentShape(g);
	}
	/**
	 * ���Ƶ�ǰ���ڻ��Ƶ���״
	 * @param g
	 */
	private void drawCurrentShape(Graphics g) {
		//�ӿ����������л�õ�ǰ���ڻ��Ƶ���״�������������
		int currentShape = Vars.paintControllor.getCurrentShape();
		Point point1 = Vars.paintControllor.getPoint1();
		Point point2 = Vars.paintControllor.getPoint2();
		int fontSize = Vars.paintControllor.getFontSize();
		String text = Vars.paintControllor.getText();
		Color shapeColor = Vars.paintControllor.getShapeColor();
		boolean fillRegion = Vars.paintControllor.isFillRegion();
		//����һ����״���͵����ã��Ȳ���ֵ�����������ֵ
		Shape shape;
		if(currentShape==PaintModel.STRING){//���ݴӿ������õ�����״������Ϣ���������������
			//����һ���������͵�Shape������Ҫ�����ͣ����֣���ɫ����С��λ�á�����
			shape = new Shape(PaintModel.STRING,text,shapeColor,fontSize,point2);
		}else{
			//����������֣�������ͨ��״����Ҫ�����ͣ���ɫ���Ƿ���䣬��㣬�յ㡱����
			shape = new Shape(currentShape,shapeColor,fillRegion,point1,point2);
		}
		//���ոչ�����Ķ���������
		drawShape(shape,g);
	}
	/**
	 * ���һ����״�����ݲ�ͬ����״���͵��ò�ͬ�ĺ����������
	 * @param shape
	 * @param g
	 */
	private void drawShape(Shape shape, Graphics g) {
		switch (shape.getShapeType()) {
		case PaintModel.CIRCLE:
			drawCircle(shape, g);
			break;
		case PaintModel.LINE:
			drawLine(shape, g);
			break;
		case PaintModel.OVAL:
			drawOval(shape, g);
			break;
		case PaintModel.RECT:
			drawRect(shape, g);
			break;
		case PaintModel.STRING:
			drawString(shape, g);
			break;
		}
	}
	/**
	 * ����ַ�������shape������ȡ�����֣���С��
	 * ��������g����ɫ
	 * ȡ��g�ĵ�ǰ���壬ʹ��font.deriveFont(float)�������޸ĵ�ǰ�������Ĵ�С�����õ�һ���µ��������
	 * ���µ�����������ø�g����
	 * ʹ��g����������֣�
	 * @param shape
	 * @param g
	 */
	private void drawString(Shape shape, Graphics g) {
		g.setColor(shape.getShapeColor());
		Font font = g.getFont();
		font = font.deriveFont((float)shape.getFontSize());
		g.setFont(font);
		g.drawString(shape.getText(), (int) shape.getPoint1().getX(),
				(int) shape.getPoint1().getY());
	}
	/**
	 * ���ƾ��Σ����ȸ�����״�����е���ɫ������g����ɫ
	 * �������䣬�͵���fillRect������͵���drawRect
	 * ע�����Ͻǵ�����������������x��y��Сֵ�������x��y��ֵ�ľ���ֵ
	 * @param shape
	 * @param g
	 */
	private void drawRect(Shape shape, Graphics g) {
		g.setColor(shape.getShapeColor());
		int x1 = (int) shape.getPoint1().getX();
		int y1 = (int) shape.getPoint1().getY();
		int x2 = (int) shape.getPoint2().getX();
		int y2 = (int) shape.getPoint2().getY();
		if (shape.isFillRegion()) {
			g.fillRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1 - x2),
					Math.abs(y1 - y2));
		}else{
			g.drawRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1 - x2),
					Math.abs(y1 - y2));
		}
	}
	/**
	 * ������Բ�����ȸ�����״�����е���ɫ������g����ɫ
	 * �������䣬�͵���fillRect������͵���drawRect
	 * ע�����Ͻǵ�����������������x��y��Сֵ�������x��y��ֵ�ľ���ֵ
	 * @param shape
	 * @param g
	 */
	private void drawOval(Shape shape, Graphics g) {
		g.setColor(shape.getShapeColor());
		int x1 = (int) shape.getPoint1().getX();
		int y1 = (int) shape.getPoint1().getY();
		int x2 = (int) shape.getPoint2().getX();
		int y2 = (int) shape.getPoint2().getY();
		if (shape.isFillRegion()) {
			g.fillOval(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1 - x2),
					Math.abs(y1 - y2));
		}else{
			g.drawOval(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1 - x2),
					Math.abs(y1 - y2));
		}
	}
	/**
	 * �����ߣ����ȸ�����״�����е���ɫ������g����ɫ
	 * @param shape
	 * @param g
	 */
	private void drawLine(Shape shape, Graphics g) {
		g.setColor(shape.getShapeColor());
		int x1 = (int) shape.getPoint1().getX();
		int y1 = (int) shape.getPoint1().getY();
		int x2 = (int) shape.getPoint2().getX();
		int y2 = (int) shape.getPoint2().getY();
		g.drawLine(x1, y1, x2, y2);
		
	}
	/**
	 * ����Բ�����ȸ�����״�����е���ɫ������g����ɫ
	 * �������䣬�͵���fillRect������͵���drawRect
	 * ע�����Ͻǵ�����������������x��y��Сֵ�������һ���ģ�ȡx1-x2��y1-y2����ֵ�еĽ�Сֵ
	 * @param shape
	 * @param g
	 */
	private void drawCircle(Shape shape, Graphics g) {
		g.setColor(shape.getShapeColor());
		int x1 = (int) shape.getPoint1().getX();
		int y1 = (int) shape.getPoint1().getY();
		int x2 = (int) shape.getPoint2().getX();
		int y2 = (int) shape.getPoint2().getY();
		int w1 = Math.abs(x1-x2);
		int w2 = Math.abs(y1-y2);
		int w = Math.min(w1, w2);
		if (shape.isFillRegion()) {
			g.fillOval(Math.min(x1, x2), Math.min(y1, y2), w,w);
		}else{
			g.drawOval(Math.min(x1, x2), Math.min(y1, y2), w,w);
		}
	}

}
