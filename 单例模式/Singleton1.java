package test;

// ��һ��������ʵ���Ƕ���ʽ����ģʽ
public class Singleton1 {
	// ����һ�� Singleton1 ��Ķ���
	// ��Ϊ��Ҫ�ṩһ���෽������̬������ getInstance ���������� instance ʵ����������������� static �ؼ���
	private static Singleton1 instance = new Singleton1();
	// ���캯��˽�л�
	private Singleton1() {}
	// �ṩ��ȡ���ö���ĺ���
	public static Singleton1 getInstance() {
		return instance;
	}
}
