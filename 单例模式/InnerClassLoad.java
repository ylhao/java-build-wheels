package test;

class OuterClass {
	
	static {
		System.out.println("�ⲿ�����");
	}
	
	static class InnerClass {
		static {
			System.out.println("�ڲ������");
		}
	}
	
}

public class InnerClassLoad {
	public static void main(String[] args) {
		OuterClass o = new OuterClass();
	}
}
