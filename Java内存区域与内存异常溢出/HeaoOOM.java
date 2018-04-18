import java.util.ArrayList;
import java.util.List;

public class HeaoOOM {
	static class OOMObject {
		
	}
	public static void main(String[] args) {
		/*
		 * Java 堆溢出
		 * -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError 
		 * 首先创建出来的 OOMObject 类的对象是不会被回收的
		 * -Xms20m -Xmx20m 限定了堆内存大小20M，且不能自动扩展（设置Xms Xmx值一样就阻止了自动扩展）
		 * 所以会溢出
		 */
		List<OOMObject> list = new ArrayList<>();
		while(true) {
			list.add(new OOMObject());
		}
	}
}
