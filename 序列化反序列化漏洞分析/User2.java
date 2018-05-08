import java.io.Serializable;
import java.io.IOException;
import java.io.ObjectInputStream;

public class User2 implements Serializable{
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	// User2 类重写了 readObject 方法，JVM 虚拟机在反序列化过程中会运行 User2 类中的 readObject 方法
	private void readObject(ObjectInputStream in) throws ClassNotFoundException, IOException {
		// 使用默认的 ReadObject() 方法
		in.defaultReadObject();
		// 弹窗测试
		Runtime.getRuntime().exec("calc.exe");
	}
}
