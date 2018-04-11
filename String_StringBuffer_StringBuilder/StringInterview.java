package test;

public class StringInterview {
	public static void main(String[] args) {
		String a1 = "hello2"; 
		String b1 = "hello" + 2; 
		System.out.println(a1 == b1);  // true
		
		/*
		 * �����з������õĴ��ڣ�����  String c = b + 2;�����ڱ����ڼ䱻�Ż���
		 * �����b+2�������泣��������ģ�������ַ�ʽ���ɵĶ�����ʵ���Ǳ����ڶ��ϵġ����a��cָ��Ĳ�����ͬһ������
		 */
		String a2 = "hello2";
		String b2 = "hello";
		String c2 = b2 + 2;
		System.out.println(a2 == c2);  // false
		
		String a3 = "hello2";
		final String b3 = "hello";
		String c3 = b3 + 2;
		System.out.println(a3 == c3);  // true
		
		String a4 = "hello2";
        final String b4 = getHello();
        String c4 = b4 + 2;
        System.out.println((a4 == c4));  // false
        
        String a5 = "hello";
        String b5 =  new String("hello");
        String c5 =  new String("hello");
        String d5 = b5.intern();
 
        System.out.println(a5==b5);  // false
        System.out.println(b5==c5);  // false
        System.out.println(b5==d5);  // false
        System.out.println(a5==d5);  // true
		
	}
	
	 public static String getHello() {
	        return "hello";
	    }
	
}
