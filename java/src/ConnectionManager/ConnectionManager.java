package ConnectionManager;

public class ConnectionManager {
	static int count=0;
	static int num=5;
	ConnectionManager(int i){num=i;};
	static Connection[] connection=new Connection[num];
	static void getConnection(){
		for(int i=0;i<num;i++){
			Connection x=Connection.makeup();//makeup()Ϊ��̬��������ֱ��Ӧ��Connection����
			connection[i]=x;
			count++;
		}
	}
	static Connection DeleteConnection(){
		if(count==0){
			System.out.println("no more connection to delete");
			return null;
		}
		else {
			System.out.println("����һ��connection");
			count--;
			return connection[count];
		}
	}
	public static void main(String[] args){
		ConnectionManager cm=new ConnectionManager(3);
		cm.getConnection();
		System.out.println("��ʣ��"+cm.count+"��connection");
		cm.DeleteConnection();
		System.out.println("��ʣ��"+cm.count+"��connection");
		cm.DeleteConnection();
		System.out.println("��ʣ��"+cm.count+"��connection");
		cm.DeleteConnection();
		System.out.println("��ʣ��"+cm.count+"��connection");
		cm.DeleteConnection();
		
	}
}
class Connection{
	private Connection(){
		System.out.println("����һ��connection");
	};
	public static Connection makeup(){//����Ϊ��̬static
		return new Connection();
	}
		
}