package ConnectionManager;

public class Ways {
	public void way1(){//��Ҫ�ܵ���way2��������static
		System.out.println("way1.constructor");
		way2();
	}
	public void way2(){//��Ҫ����д�����ܼ�static
		System.out.println("Ways->way2.constructor");
	}
	public static void main(String[] args){
		Waytowhere ww=new Waytowhere();
		ww.way2();
	}
}
class Waytowhere extends Ways{
	@Override
	public void way2(){
		System.out.println("Waytowhere->way2.constructor");
	}
}
