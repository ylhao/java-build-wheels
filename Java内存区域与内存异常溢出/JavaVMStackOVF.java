// �����ջ�ͱ��ط���ջ���
/*
 * �����ջ�ͱ��ط���ջ����������쳣��һ���� StackOverflowError��һ���� OutOfMemoryError
 * ������Ϊջ̫֡��ջ�ϵĿռ䲻���ˣ��Ų������ջ֡��ʱ������StackOverflowError
 * ���������ջ��չ��ʱ�򣬷���û���ڴ�������չ�ˣ����ʱ����� OutOfMemoryError
 */
public class JavaVMStackOVF {
	private int stackLength = 1;
	public void stackLeak() {
		/*
		 * ÿ����һ�η������ã��Ͳ���һ��ջ֡�������ͼ� 1
		 * ��ͣ�ĵݹ���ã�Ȼ��ͨ�� -Xss128k �����������ջ�ͱ��ط���ջ������Ϊ 128 k
		 * ����һ���� �׳� java.lang.StackOverflowError �쳣
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
