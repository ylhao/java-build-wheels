package test;

class OuterClass {
	
	static {
		System.out.println("外部类加载");
	}
	
	static class InnerClass {
		static {
			System.out.println("内部类加载");
		}
	}
	
}

public class InnerClassLoad {
	public static void main(String[] args) {
		OuterClass o = new OuterClass();
	}
}
