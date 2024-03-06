package outfiles;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Files {
	static int cataloguenumber=0;
	static int filenumber=0;
	static int filesize=0;
	public static void main(String args[]) throws IOException{
		File filetext=new File("output.txt");
		if(filetext.exists())
			filetext.delete();
		filetext.createNewFile();
		FileWriter fw=new FileWriter("output.txt",true);//�̳������outputstreamwriter�����ַ�������д������
		PrintWriter pw=new PrintWriter(fw);//����һ���ļ������ļ���д�����ݣ��������Ϊ�ļ����
		File file=new File("D:\\users\\wujing\\documents\\WeChat Files\\wxid_zl6a0l9q48ag22\\FileStorage\\General");
		printAllFile(file);
		pw.println("�ļ�����Ϊ��"+cataloguenumber);
		pw.flush();//��ջ���������������û�а취��ʾ
		pw.println("�ļ���Ϊ��"+filenumber);
		pw.flush();
		pw.println("�ļ���СΪ��"+filesize+"���ֽ�");
		pw.flush();
	}

	private static void printAllFile(File dir) throws IOException {
		
		File filetext=new File("output.txt");
		if(filetext.exists())
			filetext.delete();//����ļ����ڣ�Ҫִ����ղ�������������ɾ���ؽ��Ĳ���
		filetext.createNewFile();//�ؽ�
		FileWriter fw=new FileWriter("output.txt",true);
		PrintWriter pw=new PrintWriter(fw);
		
		pw.println(dir);
		pw.flush();
		File[] files =dir.listFiles();
		if(files!=null){

			for(File file:files){
				if(file.isDirectory()){
					cataloguenumber++;
					printAllFile(file);
				}else {
					filesize+=file.length();
					filenumber++;
					pw.println(file);
					pw.flush();
				}
			}
		}
	}
}
