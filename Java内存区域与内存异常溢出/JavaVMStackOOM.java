/*
 * -Xss2M
 * ����ÿ��ջ�������� 2M�� ÿ����һ���߳̾ͻᴴ��һ����Ӧ��ջ�ռ䣨����ָ�����ջ�ͱ��ط���ջ�����Ǿ���Ҫ��
 * �ڴ��з���ռ䣬��ȥ�ѵ������ͷ�������������������������������ƣ�̫С����ʣ�µľ��ǿ��Է����ջ�������ˣ�
 * ʣ�µ���ָ����ϵͳ�����������̵������������� 32 λ windows ϵͳ��������ÿ�����̵�����Ϊ 2GB���������߳�
 * �Ĵ�����ÿ���߳�2M���ܻ����ڴ治������������ʱ��������
 * 
 * ����ִ�У�ִ�����ˣ�ϵͳ��Ȼ������~~
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
