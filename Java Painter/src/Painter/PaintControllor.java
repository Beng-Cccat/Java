package Painter;

import java.awt.Color;
import java.awt.Point;

/**
 * �����������ս������в�����֪ͨ������¼����
 * ����ʱ�̣����յ�������ɫ�޸�ʱ��֪ͨ����ˢ�¡�
 * @author flower
 *
 */
public class PaintControllor {
	/**
	 * ��ǰ����������״����PaintModel�еĳ�����ֵ
	 */
	private int currentShape;
	/**
	 * ��״����ɫ�����ݽ���ѡ��ֵ,Ĭ���Ǻ�ɫ
	 */
	private Color shapeColor = Color.black;
	/**
	 * ����ɫ�����ݽ���ѡ�������ֵ��Ĭ���ǰ�ɫ
	 */
	private Color backgroundColor = Color.white;
	/**
	 * Ҫ��ʾ�����֣����ݽ�������������ֵ��Ĭ����hello
	 */
	private String text = "hello";
	/**
	 * �����С�����ݽ������������ֵ��Ĭ����10
	 */
	private int fontSize = 10;
	/**
	 * ��״�Ƿ���䣬���ݽ������������ֵ��Ĭ���ǡ�����䡱
	 */
	private boolean fillRegion = false;
	/**
	 * ��갴�µ�ʱ������
	 */
	private Point point1;
	/**
	 * ���̧������϶�ʱ������
	 */
	private Point point2;

	public void setCurrentShape(int shape) {
		this.currentShape = shape;
	}

	public int getFontSize() {
		return fontSize;
	}
	/**
	 * ������������С�Աߵļ�ͷʱ���ñ�������������������������Ҳ�����Ǹ�����
	 * @param step
	 */
	public void addFontSize(int step) {
		this.fontSize += step;
		Vars.toolPanel.refreshFontSize();
	}

	public void setFillRegion(boolean selected) {
		fillRegion = selected;
	}

	public void setText(String text) {
		this.text = text;
	}
	/**
	 * ���ս��汳��ɫ�ı�Ĳ�����һ�����յ�����¼����������֪ͨ���ˢ��
	 * @param color
	 */
	public void setBackgroundColor(Color color) {
		this.backgroundColor = color;
		Vars.paintPanel.repaint();
	}

	public void setShapeColor(Color color) {
		this.shapeColor = color;
	}
	/**
	 * �������̧������϶�ʱ��֪ͨ��һ�����յ�֪ͨ���͸��ݵ�ǰ��״��֪ͨģ�Ͷ���PaintModel��¼��ǰ��״
	 * @param p1
	 * @param p2
	 */
	public void reportMousePoint(Point p1, Point p2) {
		this.point1 = p1;
		this.point2 = p2;
		if (currentShape != PaintModel.STRING) {
			Vars.paintModel.addShape(currentShape,shapeColor,fillRegion, p1, p2);
		}else{
			Vars.paintModel.addString(text,shapeColor,fontSize,p2);
		}
	}
	public int getCurrentShape() {
		return currentShape;
	}
	public Color getBackgroundColor() {
		return backgroundColor;
	}
	public Color getShapeColor() {
		return shapeColor;
	}
	public String getText() {
		return text;
	}
	public Point getPoint2() {
		return point2;
	}
	public boolean isFillRegion() {
		return fillRegion;
	}

	public Point getPoint1() {
		return point1;
	}

	public void reportMousePointPressed(Point p1) {
		this.point1 = p1;
	}

	public void reportMousePointRelease(Point p2) {
		this.point2 = p2;
	}
}

