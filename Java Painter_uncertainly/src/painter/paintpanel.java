package painter;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class paintpanel extends JPanel{
	
	private static paintpanel instance;
	public static paintpanel getinstance(){
		if(instance==null){
			instance=new paintpanel();
		}
		return instance;
	}
	public static int startx;
	public static int starty;
	public int endx;
	public int endy;
	public int x;
	public int y;
	public static String Shape="Բ��";
	public static String currentShape="Բ��";
	public String text;
	public boolean fillregion; 
	public Color backgroundColor;
	public Color ShapeColor;
	public int sizetext;
	
	@Override
	public void paint(Graphics g){
		
		super.paint(g);
		Graphics2D g2d=(Graphics2D)g;
		for(int i=0;i<Draw.list.size();i++){
			text=Draw.list.get(i).text;
			Shape=Draw.list.get(i).Shape;
			sizetext=Draw.list.get(i).sizetext;
			
			if(!Draw.list.get(i).fillregion){
				if(Shape.equals("Բ��")){
					int widx=Math.abs(Draw.list.get(i).endx-Draw.list.get(i).startx);
					int heiy=Math.abs(Draw.list.get(i).endy-Draw.list.get(i).starty);
					g2d.setColor(Draw.list.get(i).ShapeColor);
					g2d.drawOval(Draw.list.get(i).startx,Draw.list.get(i).starty,widx, heiy);
				}
				else if(Shape.equals("��Բ")){
					int widx=Math.abs(Draw.list.get(i).endx-Draw.list.get(i).startx);
					int heiy=Math.abs(Draw.list.get(i).endy-Draw.list.get(i).starty);
					g2d.setColor(Draw.list.get(i).ShapeColor);
					g2d.drawOval(Draw.list.get(i).startx,Draw.list.get(i).starty,widx, heiy);
				}
				else if(Shape.equals("����")){
					int widx=Math.abs(Draw.list.get(i).endx-Draw.list.get(i).startx);
					int heiy=Math.abs(Draw.list.get(i).endy-Draw.list.get(i).starty);
					g2d.setColor(Draw.list.get(i).ShapeColor);
					g2d.drawRect(Draw.list.get(i).startx,Draw.list.get(i).starty, widx, heiy);
				}
			}
			else {
				if(Shape.equals("Բ��")){
					int widx=Math.abs(Draw.list.get(i).endx-Draw.list.get(i).startx);
					int heiy=Math.abs(Draw.list.get(i).endy-Draw.list.get(i).starty);
					g2d.setColor(Draw.list.get(i).backgroundcolor);
					g2d.fillOval(Draw.list.get(i).startx,Draw.list.get(i).starty,widx, heiy);
				}
				else if(Shape.equals("��Բ")){
					int widx=Math.abs(Draw.list.get(i).endx-Draw.list.get(i).startx);
					int heiy=Math.abs(Draw.list.get(i).endy-Draw.list.get(i).starty);
					g2d.setColor(Draw.list.get(i).backgroundcolor);
					g2d.fillOval(Draw.list.get(i).startx,Draw.list.get(i).starty,widx, heiy);
				}
				else if(Shape.equals("����")){
					int widx=Math.abs(Draw.list.get(i).endx-Draw.list.get(i).startx);
					int heiy=Math.abs(Draw.list.get(i).endy-Draw.list.get(i).starty);
					g2d.setColor(Draw.list.get(i).backgroundcolor);
					g2d.fillRect(Draw.list.get(i).startx,Draw.list.get(i).starty, widx, heiy);
				}
			}
			if(Shape.equals("ֱ��")){
				g2d.setColor(Draw.list.get(i).ShapeColor);
				g2d.drawLine(Draw.list.get(i).startx,Draw.list.get(i).starty,Draw.list.get(i).endx,Draw.list.get(i).endy);
			}
			if(Shape.equals("����")){
				g2d.setColor(Draw.list.get(i).ShapeColor);
				g2d.setFont(new Font("����",Font.BOLD,sizetext));
				g2d.drawString(text, Draw.list.get(i).endx, Draw.list.get(i).endy);
			}
		}
		
		if(!fillregion){
			if(currentShape.equals("Բ��")){
				int widx=Math.abs(x-startx);
				int heiy=Math.abs(y-starty);
				g2d.setColor(ShapeColor);
				g2d.drawOval(startx,starty,widx, heiy);
			}
			else if(currentShape.equals("��Բ")){
				int widx=Math.abs(x-startx);
				int heiy=Math.abs(y-starty);
				g2d.setColor(ShapeColor);
				g2d.drawOval(startx,starty,widx, heiy);
			}
			else if(currentShape.equals("����")){
				int widx=Math.abs(x-startx);
				int heiy=Math.abs(y-starty);
				g2d.setColor(ShapeColor);
				g2d.drawRect(startx,starty, widx, heiy);
			}
		}
		else {
			if(currentShape.equals("Բ��")){
				int widx=Math.abs(x-startx);
				int heiy=Math.abs(y-starty);
				g2d.setColor(backgroundColor);
				g2d.fillOval(startx,starty,widx,heiy);
			}
			else if(currentShape.equals("��Բ")){
				int widx=Math.abs(x-startx);
				int heiy=Math.abs(y-starty);
				g2d.setColor(backgroundColor);
				g2d.fillOval(startx,starty,widx,heiy);
			}
			else if(currentShape.equals("����")){
				int widx=Math.abs(x-startx);
				int heiy=Math.abs(y-starty);
				g2d.setColor(backgroundColor);
				g2d.fillRect(startx,starty, widx, heiy);
			}
		}
		if(currentShape.equals("ֱ��")){
			g2d.setColor(ShapeColor);
			g2d.drawLine(startx,starty,x,y);
		}
	}

	public void setcurrentShape(String command) {
		currentShape=command;
	}
}
