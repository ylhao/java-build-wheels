package test;

// ����ʽ
// �̰߳�ȫ������ classloader ���Ʊ����˶��߳�ͬ������
// �ص㣺û�м����������ʱ�� new ��һ�����ʵ��
public class Singleton3 {
	private static Singleton3 instance = new Singleton3();  
    private Singleton3() {}
    public static Singleton3 getInstance() {
    	return instance;
    }
}
