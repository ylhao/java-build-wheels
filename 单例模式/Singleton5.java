package test;

// ��̬�ڲ���
// �̰߳�ȫ������ classloader ���Ʊ����˶��߳�ͬ������
// ֻ�е������� getInstance() ����ʱ���Ż�װ�� SingletonHolder �࣬�Ӷ�ʵ����һ�� INSTANCE
// ���������װ�ػ���ʵ�����ӳټ���
public class Singleton5 {
	// SingletonHoler �� Singleton5 �ľ�̬�ڲ���
	private static class SingletonHolder {
		private static final Singleton5 INSTANCE = new Singleton5();
	}
	private Singleton5() {}
	public static final Singleton5 getInstance() {
		return SingletonHolder.INSTANCE;
	}
}
