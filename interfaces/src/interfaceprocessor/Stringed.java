package interfaceprocessor;

public class Stringed {//�������������ַ�
	static String process(String s){//�βν�Ϊһ��String
		char []s_change=new char[s.length()];
		if(s.length()%2==0){
			for(int i=0;i<s.length()-1;i+=2){
				s_change[i]=s.charAt(i+1);
				s_change[i+1]=s.charAt(i);
			}
		}
		else{
			for(int i=0;i<s.length()-1;i+=2){
				s_change[i]=s.charAt(i+1);
				s_change[i+1]=s.charAt(i);
			}
			s_change[s.length()-1]=s.charAt(s.length()-1);
		}
		String s_final=new String(s_change);
		return s_final;
	}
}
