package interfaceprocessor;

public class Apply {
	public static void process(Processor p,Object s){//��������һ����Processor����һ�����������Ͷ��󣬴���Ҫ����String���Ͷ���
		System.out.println("Using Processor"+p.name());
		System.out.println(p.process(s));
	}
}
