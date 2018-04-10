package test;

// 第一个例子其实就是饿汉式单例模式
public class Singleton1 {
	// 创建一个 Singleton1 类的对象
	// 因为还要提供一个类方法（静态方法） getInstance 方法，操作 instance 实例，所以这里必须用 static 关键字
	private static Singleton1 instance = new Singleton1();
	// 构造函数私有化
	private Singleton1() {}
	// 提供获取可用对象的函数
	public static Singleton1 getInstance() {
		return instance;
	}
}
