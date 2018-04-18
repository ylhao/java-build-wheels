/*
 * -Xss2M
 * 设置每个栈的容量是 2M， 每创建一个线程就会创建一个对应的栈空间（这里指虚拟机栈和本地方法栈），那就需要从
 * 内存中分配空间，除去堆的容量和方法区的容量，程序计数器的容量不计（太小），剩下的就是可以分配给栈的容量了，
 * 剩下的是指操作系统分配给这个进程的总容量（比如 32 位 windows 系统，会限制每个进程的容量为 2GB），随着线程
 * 的创建，每个线程2M，总会有内存不够的情况，这个时候就溢出了
 * 
 * 慎重执行，执行完了，系统果然假死了~~
 * 
 */
public class JavaVMStackOOM {
	private void dontstop() {
		while(true) {
			
		}
	}
	public void stackLeakByThread() {
		while(true) {
			Thread thread = new Thread(new Runnable() {
				@Override
				public void run() {
					dontstop();
				}
			});
			thread.start();
		}
	}
	public static void main(String[] args) {
		JavaVMStackOOM oom = new JavaVMStackOOM();
		oom.stackLeakByThread();
	}
}
