package CDproject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boss {
	private static UserBook userbook=new UserBook();
	private static DiskBook diskbook=new DiskBook();
	BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args)throws Exception{
		new Boss().begin();
	}
	public void begin()throws Exception{
		while(true){
			printMainMenu();
			String line=in.readLine();
			int choice =Integer.parseInt(line);
			switch(choice){
			case 1:
				userManage();
				break;
			case 2:
				DiskManage();
				break;
			case 3:
				takedisk();
				break;
			case 4:
				borrowdisk();
				break;
			case 5:
				returnDisk();
				break;
			case 6:
				return;
			}
		}
	}
	private void borrowdisk() throws IOException {
		// TODO Auto-generated method stub
		System.out.println("��������Ҫ���ĵ�CD�ı�ţ�");
		String line=in.readLine();
		int id=Integer.parseInt(line);
		if(diskbook.find(id)!=null){
			System.out.println("��ѯ�ɹ�����CD��Ϊ"+diskbook.data[id].getName()+",���������Ļ�Ա��ţ�");
			String line1=in.readLine();
			int name_id=Integer.parseInt(line1);
			System.out.println("��������Ҫ���ĵ���Ŀ��");
			String line2=in.readLine();
			int num=Integer.parseInt(line2);
			Disk borrow_disk=new Disk(id,diskbook.data[id].getName(),diskbook.data[id].getPrice(),num);
			if(diskbook.data[id].getNum()>=num){//
				diskbook.remove(borrow_disk);
				userbook.data[name_id].tools.add(borrow_disk);
				System.out.println("��ϲ����ĳɹ���");
				return;
			}
			else {
				System.out.println("��ǸĿǰ�����ֻ��"+diskbook.data[id].getNum()+"��CD�����Ƿ�Ҫ���н��ģ�");
				System.out.println("1:�ǵģ���"+diskbook.data[id].getNum()+"��CDȫ����");
				System.out.println("2:���������н���");
				String line3=in.readLine();
				int choice=Integer.parseInt(line3);
				switch(choice){
				case 1:
					diskbook.remove(borrow_disk);
					userbook.data[name_id].tools.add(borrow_disk);
					System.out.println("��ϲ����ĳɹ���");
					break;
				case 2:
					return;
				}
			}
		}
		else {
			System.out.println("��CD���Ϊ0���޷����н��Ĳ���");
			return;
		}
	}
	private void returnDisk() throws IOException {
		System.out.println("��������Ҫ�黹��CD�ı�ţ�");
		String line=in.readLine();
		int id=Integer.parseInt(line);
		System.out.println("��������Ҫ�黹��CD��������");
		String line1=in.readLine();
		int num=Integer.parseInt(line1);
		Disk return_disk=new Disk(id,diskbook.data[id].getName(),diskbook.data[id].getPrice(),num);
		diskbook.add(return_disk);
		System.out.println("���������Ļ�Ա��ţ�");
		String line2=in.readLine();
		int userid=Integer.parseInt(line2);
		userbook.data[userid].tools.remove(return_disk);
		System.out.println("��ϲ��黹�ɹ���");
		return;
	}
	private void takedisk() throws IOException {
		System.out.println("��������Ҫ�����CD�ı�ţ�");
		String line=in.readLine();
		int id=Integer.parseInt(line);
		if(diskbook.find(id)!=null){
			System.out.println("��ѯ�ɹ�����CD��Ϊ"+diskbook.data[id].getName()+",���������Ļ�Ա��ţ�");
			String line1=in.readLine();
			int name_id=Integer.parseInt(line1);
			System.out.println("��������Ҫ�������Ŀ��");
			String line2=in.readLine();
			int num=Integer.parseInt(line2);
			Disk borrow_disk=new Disk(id,diskbook.data[id].getName(),diskbook.data[id].getPrice(),num);
			if(diskbook.data[id].getNum()>=num){//
				if(userbook.data[name_id].getMoney()>=num*diskbook.data[id].getPrice()){
					diskbook.remove(borrow_disk);
					userbook.data[name_id].setMoney(userbook.data[name_id].getMoney()-num*diskbook.data[id].getPrice());
					System.out.println("��ϲ�㹺��ɹ���");
					return;
				}
				else {
					printAddMoney(name_id);
					takedisk();
					return;
				}
			}
			else {
				System.out.println("��ǸĿǰ�����ֻ��"+diskbook.data[id].getNum()+"��CD�����Ƿ�Ҫ���й���");
				System.out.println("1:�ǵģ���"+diskbook.data[id].getNum()+"��CDȫ����");
				System.out.println("2:���������й���");
				String line3=in.readLine();
				int choice=Integer.parseInt(line3);
				switch(choice){
				case 1:
					diskbook.remove(borrow_disk);
					System.out.println("��ϲ�㹺��ɹ���");
					break;
				case 2:
					return;
				}
			}
		}
		else {
			System.out.println("��CD���Ϊ0���޷����й������");
			return;
		}
			
	}
	private void printAddMoney(int name_id) throws IOException {
		System.out.println("��Ǹ �����㣡");
		System.out.println("�Ƿ���г�ֵ��");
		System.out.println("1:��ֵ");
		System.out.println("2������ֵ");
		String line=in.readLine();
		int choice=Integer.parseInt(line);
		switch(choice){
		case 1:
			AddMoney(name_id);
			break;
		case 2:
			return;
			
		}
	}
	private void AddMoney(int name_id) throws IOException {
		System.out.println("��������Ҫ��ֵ��Ǯ��");
		String line=in.readLine();
		int money_add=Integer.parseInt(line);
		userbook.data[name_id].setMoney(money_add+userbook.data[name_id].getMoney());
		System.out.println("��ϲ���ֵ�ɹ���");
		return;
	}
	private void DiskManage() throws IOException {
		while(true){
			printDiskMenu();
			String line=in.readLine();
			int choice =Integer.parseInt(line);
			switch(choice){
			case 1:
				DiskAdd();
				break;
			case 2:
				DiskFind();
				break;
			case 3:
				ListDisk();
				break;
			case 4:
				return;
			}
		}
	}
	private void ListDisk() {
		diskbook.list();
		return;
	}
	private void DiskFind() throws IOException {
		System.out.println("��������Ҫ���ҵ�CD��id��");
		String line=in.readLine();
		int id=Integer.parseInt(line);
		if(diskbook.find(id)!=null)
			System.out.println(diskbook.data[id].toString());
		else
			System.out.println("�Բ�������û�и�CD�������Ϣ");
		return;
	}
	private void DiskAdd() throws IOException {
		System.out.println("���������id�ţ�");
		String line=in.readLine();
		int id=Integer.parseInt(line);
		System.out.println("������������ƣ�");
		String name =in.readLine();
		System.out.println("��������̵��ۣ�");
		String line1=in.readLine();
		int price=Integer.parseInt(line1);
		System.out.println("���������������");
		String line2=in.readLine();
		int num=Integer.parseInt(line2);
		Disk newdisk=new Disk(id,name,price,num);
		diskbook.add(newdisk);
		diskbook.num++;
		System.out.println("��ϲ�㣡������Ϣ��ӳɹ���");
	}
	private void printDiskMenu() {
		System.out.println("1:disk add");
		System.out.println("2:disk find");
		System.out.println("3:list disk");
		System.out.println("4:return main menu");
		System.out.println("please choose:");
	}
	private void userManage() throws IOException {
		while(true){
			printUserMenu();
			String line=in.readLine();
			int choice =Integer.parseInt(line);
			switch(choice){
			case 1:
				userAdd();
				break;
			case 2:
				UserRemove();
				break;
			case 3:
				UserFind();
				break;
			case 4:
				ListUser();
				break;
			case 5:
				return;
			}
		}
	}
	private void UserRemove() throws IOException {
		System.out.println("��������Ҫ�˻�Ļ�Աid��");
		String line=in.readLine();
		int name_id=Integer.parseInt(line);
		if(userbook.find(name_id)!=null){
			System.out.println("��ע�⣡�˻���Ա���е�Ǯ�Ų��˻����Ƿ������");
			System.out.println("1:����");
			System.out.println("2:ֹͣ");
			String line1=in.readLine();
			int choice=Integer.parseInt(line1);
			if(choice==1){
				Users remove_user=new Users(name_id,userbook.data[name_id].getName(),userbook.data[name_id].getMoney());
				userbook.remove(remove_user);
				System.out.println("��ϲ���˻�ɹ���ף��������죡");
			}
			return;
		}
		else{
			System.out.println("�������Ǳ����ԱŶ����������Ļ�Ա���Ƿ���ȷ��");
			return;
		}
	}
	private void ListUser() {
		userbook.list();
		return;
	}
	private void UserFind() throws IOException {
		System.out.println("��������Ҫ���ҵ��û���id��");
		String line=in.readLine();
		int id=Integer.parseInt(line);
		if(userbook.find(id)!=null)
			System.out.println(userbook.data[id].toString());
		else
			System.out.println("�Բ�������û�и��û��������Ϣ");
		return;
	}
	private void userAdd() throws IOException {
		System.out.println("�������û�id��");
		String line=in.readLine();
		int id=Integer.parseInt(line);
		System.out.println("�������û����֣�");
		String name =in.readLine();
		System.out.println("�������û������Ǯ��");
		String line1=in.readLine();
		int money=Integer.parseInt(line1);
		if(userbook.data[id]!=null){
			System.out.println("��ϲ���Ǯ�ɹ���");
		}
		else{
			System.out.println("��ϲ�㣡�û���ӳɹ���");
		}
		Users user=new Users(id,name,money);
		userbook.add(user);
		userbook.num++;
	}
	private void printUserMenu() {
		System.out.println("1:user add");
		System.out.println("2:user remove");
		System.out.println("3:user find");
		System.out.println("4:list user");
		System.out.println("5:return main menu");
		System.out.println("please choose:");
	}
	private void printMainMenu() {
		System.out.println("1:�����Ա����");
		System.out.println("2:������̹���");
		System.out.println("3:�����");
		System.out.println("4:�����");
		System.out.println("5:������");
		System.out.println("6:�˳�ϵͳ");
		System.out.println("��ѡ��");
		
	}
}
