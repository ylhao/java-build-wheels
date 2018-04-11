package test;

/*
String类是final类，也即意味着String类不能被继承，final修饰的类的成员方法都默认为final方法，成员变量可以为final的也可以不是final的
String类其实是通过char数组来保存字符串的
*/
public class StringDemo {
	public static int time = 50000;  // 控制循环次数
	public static void main(String[] args) {
		// 是放在常量区创建一个 "abcabc" 的字符串，a 指向这个字符串 
		String a = "abcabc";
		// 常量区有 "abcabc"，b 直接指向这个字符串
		String b = "abcabc";
		String c = "abcabc";
		// 常量区有就不创建了，创建一个内容为 "abcabc" 的字符串放在堆区
		String d = new String("abcabc");
		System.out.println( a == c);
		System.out.println( b == c);
		System.out.println( a == d);
		
		// 基本操作
		// 对 String 对象的任何改变都不影响到原对象，相关的任何 change 操作都会生成新的对象
		// String 对象是不可变对象
		String e1 = a.concat(b);  // abcabcabcabc
		String e2 = a.substring(0, 3);  // abc
		String e3 = a.replace('a', 'b');  // bbcbbc
		System.out.println(e1);
		System.out.println(e2);
		System.out.println(e3);
		
		String string = "";
		/*
		 * 这里用 jad 反编译一下，下面的for循环实际上被JVM优化成以下代码
		 * 可以看出每次都先 new 一个 StringBuilder 对象，然后调用 append 方法，最后调用 toString 方法
		 */
		/*
		 for(int i = 0; i < 10000; i++)
            string = (new StringBuilder(String.valueOf(string))).append("hello").toString();
		 */
		for(int i=0;i<10000;i++){
            string += "hello";
        }
		
		/*
		 * StringBuilder和StringBuffer类拥有的成员属性以及成员方法基本相同，
		 * 区别是StringBuffer类的成员方法前面多了一个关键字：synchronized，
		 * 不用多说，这个关键字是在多线程访问时起到安全保护作用的,也就是说StringBuffer是线程安全的。
		 */
		StringBuilder stringBuilder = new StringBuilder();
        for(int i=0;i<10000;i++){
            stringBuilder.append("hello");
        }
        
        StringBuffer stringBuffer = new StringBuffer();
        for(int i=0;i<10000;i++){
            stringBuffer.append("hello");
        }
        
        // 性能测试
        testString();
        testStringBuffer();
        testStringBuilder();
        test1String();
        test2String();
	}
	
	// String +=
	public static void testString () {
        String s="";
        long begin = System.currentTimeMillis();
        for(int i=0; i < time; i++){
            s += "java";
        }
        long over = System.currentTimeMillis();
        System.out.println("操作"+s.getClass().getName()+"类型使用的时间为："+(over-begin)+"毫秒");
    }
 
	// StringBuffer +=
    public static void testStringBuffer () {
        StringBuffer sb = new StringBuffer();
        long begin = System.currentTimeMillis();
        for(int i=0; i<time; i++){
            sb.append("java");
        }
        long over = System.currentTimeMillis();
        System.out.println("操作"+sb.getClass().getName()+"类型使用的时间为："+(over-begin)+"毫秒");
    }
 
    // StringBuilder +=
    public static void testStringBuilder () {
        StringBuilder sb = new StringBuilder();
        long begin = System.currentTimeMillis();
        for(int i=0; i<time; i++){
            sb.append("java");
        }
        long over = System.currentTimeMillis();
        System.out.println("操作"+sb.getClass().getName()+"类型使用的时间为："+(over-begin)+"毫秒");
    }
    
    // String
    public static void test1String () {
        long begin = System.currentTimeMillis();
        for(int i=0; i<time; i++){
        	/*
        	 * 以下代码被编译器优化成注释的样子 
        	 */
        	/*
        	for(int i = 0; i < time; i++){
            	String s = "Ilovejava";
        	}
        	 */
            String s = "I"+"love"+"java";
        }
        long over = System.currentTimeMillis();
        System.out.println("字符串直接相加操作："+(over-begin)+"毫秒");
    }
 
    public static void test2String () {
        String s1 ="I";
        String s2 = "love";
        String s3 = "java";
        long begin = System.currentTimeMillis();
        /*
    	 * 以下代码被编译器优化成注释的样子 
    	 */
    	/*
    	for(int i = 0; i < time; i++)
        {
            String s = (new StringBuilder(String.valueOf(s1))).append(s2).append(s3).toString();
        }
    	 */
        for(int i=0; i<time; i++){
            String s = s1+s2+s3;
        }
        long over = System.currentTimeMillis();
        System.out.println("字符串间接相加操作："+(over-begin)+"毫秒");
    }
}
