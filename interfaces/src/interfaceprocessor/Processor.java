package interfaceprocessor;

public interface Processor {
	String name();
	Object process(Object input);
}
class Stringedchange implements Processor{//�̳���Processor��StringedchangeΪProcessor�����࣬��������ת��ΪProcessor���Ͷ���
	public String name(){//java��ļ̳й�ϵ�У�ֻ������һ��������������Χ��������С���ʴ˴�����д��public
		return "Stringed change:";
	}
	public Object process(Object input){//��processֻ��Ҫһ��������String s
		return Stringed.process((String)input);//Stringed��process��static������ֱ��д��Stringed.process����
	}
}