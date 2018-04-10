package innerclass;

// 静态内部类
// 静态内部类的创建是不需要依赖于外围类的。
// 静态内部类不能使用任何外围类的非static成员变量和方法。

class OuterClass1 {
    private String sex;
    public static String name = "chenssy";
    
    static class InnerClass1{
        /* 在静态内部类中可以存在静态属性和方法，但在非静态内部类中是不可以的 */
        public static String name1 = "chenssy_static";
        
        public void display(){
            /* 
             * 静态内部类只能访问外围类的静态成员变量和方法
             * 不能访问外围类的非静态成员变量和方法
             */
            System.out.println("OutClass name :" + name);
        }
        
        public static void test1() {
        	System.out.println("test1");
        }
    }
    
    public void display() {
    	System.out.println(InnerClass1.name1);
    	InnerClass1.test1();
    	new InnerClass1().display();
    }
}

public class Test3 {
	public static void main(String[] args) {
		// 静态内部类的创建是不需要依赖于外围类的。
		OuterClass1 o = new OuterClass1();
		o.display();
		OuterClass1.InnerClass1 ic = new OuterClass1.InnerClass1();
	}
}
