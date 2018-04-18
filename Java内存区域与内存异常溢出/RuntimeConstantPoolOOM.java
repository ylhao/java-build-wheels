import java.util.ArrayList;
import java.util.List;

/*
 * -XX:PermSize=10M -XX:MaxPermSize=10M
 * 限制了方法区大小 10M，最大容量10M
 * 
 * 针对 HotSpot 虚拟机来说，永久代也就是方法区，方法区存类信息、常量、静态变量、即时编译器编译后的代码等
 * 但是 JDK1.7以后（包括JDK1.7）已经把常量池移出了永久代，采用 Native Memory 的方式
 * 所以在 JDK1.7（含）版本以上执行这段代码，会一直循环下去。
 * 上面两个参数设置的是方法区的容量，对 HotSpot 虚拟机来说也就是设置了永久代的容量
 */
public class RuntimeConstantPoolOOM {
	public static void main(String[] args) {
		// 使用 List 保持引用，避免 Full GC 回收常量池行为
		List<String> list = new ArrayList<>();
		int i = 0;
		while(true) {
			System.out.println(i);
			list.add(String.valueOf(i++).intern());
		}
	}
}
