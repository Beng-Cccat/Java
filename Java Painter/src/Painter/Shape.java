package Painter;

import java.awt.Color;
import java.awt.Point;
/**
 * ��״���󣬱���һ����״����Ҫ����������
 * @author flower
 *
 */
public class Shape {
	/**
	 * ��״���ͣ���ֵ����PaintModel�еĳ���
	 */
	private int shapeType ;
	/**
	 * ��״����ɫ
	 */
	private Color shapeColor;
	/**
	 * �������״������ͨ�ľ��Ρ�Բ�ȣ������֣���text����������������
	 */
	private String text;
	/**
	 * ��갴��ʱ�ĵ�
	 */
	private Point point1;
	/**
	 * ���̧��ʱ�ĵ�
	 */
	private Point point2;
	/**
	 * ��״�Ƿ����
	 */
	private boolean fillRegion;
	/**
	 * ��������Ĵ�С
	 */
	private int fontSize = 10;
	/**
	 * ��ͨ��״�Ĺ��캯��
	 * @param shapeType ��״����
	 * @param shapeColor ��״����ɫ
	 * @param fillRegion �Ƿ����
	 * @param point1 ��갴��ʱ�ĵ�
	 * @param point2 ���̧������϶�ʱ�ĵ�
	 */
	public Shape(int shapeType,Color shapeColor,boolean fillRegion, Point point1, Point point2) {
		super();
		this.shapeType = shapeType;
		this.shapeColor = shapeColor;
		this.fillRegion = fillRegion;
		this.point1 = point1;
		this.point2 = point2;
	}
	/**
	 * �������͵���״���캯��
	 * @param shapeType ��״���ͣ�������PaintModel�е�String����
	 * @param text Ҫ��ʾ������
	 * @param shapeColor ���ֵ���ɫ
	 * @param fontSize ��������Ĵ�С
	 * @param point1 Ҫ��ʾ���ֵ�λ��
	 */
	public Shape(int shapeType, String text,Color shapeColor,int fontSize, Point point1) {
		super();
		this.shapeType = shapeType;
		this.shapeColor = shapeColor;
		this.fontSize = fontSize;
		this.text = text;
		this.point1 = point1;
	}

	public int getShapeType() {
		return shapeType;
	}
	public Point getPoint1() {
		return point1;
	}
	public Point getPoint2() {
		return point2;
	}
	public String getText() {
		return text;
	}
	public int getFontSize() {
		return fontSize;
	}
	public Color getShapeColor() {
		return shapeColor;
	}
	public boolean isFillRegion() {
		return fillRegion;
	}
}
