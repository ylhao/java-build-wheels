package test;

// ����ʽ���̲߳���ȫ
// ����ص�ʱ��instance ��ʼ��Ϊ 0��ֻ�е� getInstance() ������һ�α����õ�ʱ�򣬲� new һ�����ʵ��
// �̲߳���ȫ��ָ�����ܱ�ֻ֤��һ�����ʵ�����ڶ��̵߳Ļ����У����ܴ������ instance
public class Singleton2 {
	private static Singleton2 instance;  
	private Singleton2 (){}
	public static Singleton2 getInstance() {
		if(instance == null) {
			instance = new Singleton2();
		}
		return instance;
	}
}
