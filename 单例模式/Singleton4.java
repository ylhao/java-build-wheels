package test;

// DCL(double checked locking)
// 双检锁/双重校验锁
public class Singleton4 {
	private volatile static Singleton4 instance;
	private Singleton4() {}
	public static Singleton4 getSingleton() {
		// 这次判空是为了避免不必要的同步
		if(instance == null) {
			synchronized(Singleton4.class) {
				// 这次判空是在 instance 为空的情况下才创建实例
				if(instance == null) {
					instance = new Singleton4();
				}
			}
		}
		return instance;
	}
	
}
