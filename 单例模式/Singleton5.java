package test;

// 静态内部类
// 线程安全，基于 classloader 机制避免了多线程同步问题
// 只有当调用了 getInstance() 方法时，才会装载 SingletonHolder 类，从而实例化一个 INSTANCE
// 利用了类的装载机制实现了延迟加载
public class Singleton5 {
	// SingletonHoler 是 Singleton5 的静态内部类
	private static class SingletonHolder {
		private static final Singleton5 INSTANCE = new Singleton5();
	}
	private Singleton5() {}
	public static final Singleton5 getInstance() {
		return SingletonHolder.INSTANCE;
	}
}
