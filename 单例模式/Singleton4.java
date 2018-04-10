package test;

// DCL(double checked locking)
// ˫����/˫��У����
public class Singleton4 {
	private volatile static Singleton4 instance;
	private Singleton4() {}
	public static Singleton4 getSingleton() {
		// ����п���Ϊ�˱��ⲻ��Ҫ��ͬ��
		if(instance == null) {
			synchronized(Singleton4.class) {
				// ����п����� instance Ϊ�յ�����²Ŵ���ʵ��
				if(instance == null) {
					instance = new Singleton4();
				}
			}
		}
		return instance;
	}
	
}
