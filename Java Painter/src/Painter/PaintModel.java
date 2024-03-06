package Painter;

import java.awt.Color;
import java.awt.Point;
import java.util.LinkedList;
/**
 * ģ�Ͷ��󣬶�����״������������״���ݣ�������״����
 * @author flower
 *
 */
public class PaintModel {
	/**����Բ*/
	public static final int CIRCLE = 1;
	/**������Բ*/
	public static final int OVAL = 2;
	/**�������*/
	public static final int RECT = 3;
	/**������*/
	public static final int LINE = 4;
	/**��������*/
	public static final int STRING = 5;
	/**
	 * ����������״���ݵ�һ��������LinkedList���ͣ�ֻ����Shape���͵Ķ���
	 */
	private LinkedList<Shape> data = new LinkedList<Shape>();
	/**
	 * �����״���������������͵Ķ��󣬽������Ĳ�������һ��Shape���󣬲���ӵ�data������
	 * @param currentShape ��ǰ��״
	 * @param shapeColor ��״����ɫ
	 * @param fillRegion �Ƿ����
	 * @param p1 ��갴�µĵ�
	 * @param p2 ���̧��ĵ�
	 */
	public void addShape(int currentShape, Color shapeColor,boolean fillRegion, Point p1, Point p2) {
		data.add(new Shape(currentShape, shapeColor,fillRegion,p1, p2));
	}
	/**
	 * ����������͵���״���󣬽������Ĳ�������һ��Shape���󣬲���ӵ�data������
	 * @param text Ҫ��ʾ������
	 * @param shapeColor ���ֵ���ɫ
	 * @param fontSize ����Ĵ�С
	 * @param point ��갴�µĵ�
	 */
	public void addString(String text, Color shapeColor,int fontSize,Point point) {
		data.add(new Shape(STRING,text,shapeColor,fontSize,point));
	}
	/**
	 * ���һ���ж��ٸ���״
	 * @return �Ѿ���������״�ĸ���
	 */
	public int getShapeSize(){
		return data.size();
	}
	/**
	 * �����±��ȡ���Ӧ����״����
	 * @param index
	 * @return
	 */
	public Shape getShape(int index){
		return data.get(index);
	}
}
