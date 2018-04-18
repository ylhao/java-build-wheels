// 虚拟机栈和本地方法栈溢出
/*
 * 虚拟机栈和本地方法栈会产生两种异常，一种是 StackOverflowError，一种是 OutOfMemoryError
 * 当是因为栈帧太大（栈上的空间不够了，放不下这个栈帧）时，产生StackOverflowError
 * 当虚拟机的栈扩展的时候，发现没有内存让它扩展了，这个时候会抛 OutOfMemoryError
 */
public class JavaVMStackOVF {
	private int stackLength = 1;
	public void stackLeak() {
		/*
		 * 每进行一次方法调用，就产生一个栈帧，计数就加 1
		 * 不停的递归调用，然后通过 -Xss128k 设置了虚拟机栈和本地方法栈的容量为 128 k
		 * 所以一定会 抛出 java.lang.StackOverflowError 异常
		 */
		stackLength ++;
		stackLeak();
	}
	
	public static void main(String[] args) {
		JavaVMStackOVF oom = new JavaVMStackOVF();
		try {
			oom.stackLeak();
		} catch (Throwable e) {
			System.out.println("stack length: " +  oom.stackLength);
			throw e;
		}
	}
}
