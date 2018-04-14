package customer1;
class BMW523 {
	public BMW523() {
		System.out.println("制造-->BMW523");
	}
}

class BMW320 {
	public BMW320() {
		System.out.println("制造-->BMW320");
	}
}

public class Customer1 {
	public static void main(String[] args) {
		
		// 以下两行代码相当于用户直接去创建一款车了
		// 用户和车紧密耦合
		BMW320 bmw320 = new BMW320();
		BMW523 bmw523 = new BMW523();
	}
}
