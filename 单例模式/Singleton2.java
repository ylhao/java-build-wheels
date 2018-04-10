package test;

// 懒汉式，线程不安全
// 类加载的时候，instance 初始化为 0，只有当 getInstance() 方法第一次被调用的时候，才 new 一个类的实例
// 线程不安全是指，不能保证只有一个类的实例，在多线程的环境中，可能创建多个 instance
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
