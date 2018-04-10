package innerclass;


// 匿名内部类是没有访问修饰符的。
// new 匿名内部类，这个类首先是要存在的。如果我们将那个InnerClass接口注释掉，就会出现编译出错。
// 注意getInnerClass()方法的形参，第一个形参是用final修饰的，而第二个却没有。
// 同时我们也发现第二个形参在匿名内部类中没有使用过，所以当所在方法的形参需要被匿名内部类使用，那么这个形参就必须为final。

// 匿名内部类是没有构造方法的。因为它连名字都没有何来构造方法。

interface InnerClass {
    int getNumber();
}


class OuterClass {
    
	// 当所在方法的形参需要被匿名内部类使用，那么这个形参就必须为final。
	public InnerClass getInnerClass(final int num, String str2){
    	return new InnerClass(){
            int number = num + 3;
            public int getNumber(){
                return number;
            }
        };        /* 注意：分号不能省 */
    }
    
   
}


public class Test2 {
	public static void main(String[] args) {
		OuterClass out = new OuterClass();
		InnerClass inner = out.getInnerClass(2, "chenssy");
		System.out.println(inner.getNumber());
	}
}