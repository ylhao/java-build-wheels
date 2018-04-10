package test;

// 饿汉式
// 线程安全，基于 classloader 机制避免了多线程同步问题
// 特点：没有加锁、类加载时就 new 了一个类的实例
public class Singleton3 {
	private static Singleton3 instance = new Singleton3();  
    private Singleton3() {}
    public static Singleton3 getInstance() {
    	return instance;
    }
}
