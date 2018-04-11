package test;

/*
String����final�࣬Ҳ����ζ��String�಻�ܱ��̳У�final���ε���ĳ�Ա������Ĭ��Ϊfinal��������Ա��������Ϊfinal��Ҳ���Բ���final��
String����ʵ��ͨ��char�����������ַ�����
*/
public class StringDemo {
	public static int time = 50000;  // ����ѭ������
	public static void main(String[] args) {
		// �Ƿ��ڳ���������һ�� "abcabc" ���ַ�����a ָ������ַ��� 
		String a = "abcabc";
		// �������� "abcabc"��b ֱ��ָ������ַ���
		String b = "abcabc";
		String c = "abcabc";
		// �������оͲ������ˣ�����һ������Ϊ "abcabc" ���ַ������ڶ���
		String d = new String("abcabc");
		System.out.println( a == c);
		System.out.println( b == c);
		System.out.println( a == d);
		
		// ��������
		// �� String ������κθı䶼��Ӱ�쵽ԭ������ص��κ� change �������������µĶ���
		// String �����ǲ��ɱ����
		String e1 = a.concat(b);  // abcabcabcabc
		String e2 = a.substring(0, 3);  // abc
		String e3 = a.replace('a', 'b');  // bbcbbc
		System.out.println(e1);
		System.out.println(e2);
		System.out.println(e3);
		
		String string = "";
		/*
		 * ������ jad ������һ�£������forѭ��ʵ���ϱ�JVM�Ż������´���
		 * ���Կ���ÿ�ζ��� new һ�� StringBuilder ����Ȼ����� append ������������ toString ����
		 */
		/*
		 for(int i = 0; i < 10000; i++)
            string = (new StringBuilder(String.valueOf(string))).append("hello").toString();
		 */
		for(int i=0;i<10000;i++){
            string += "hello";
        }
		
		/*
		 * StringBuilder��StringBuffer��ӵ�еĳ�Ա�����Լ���Ա����������ͬ��
		 * ������StringBuffer��ĳ�Ա����ǰ�����һ���ؼ��֣�synchronized��
		 * ���ö�˵������ؼ������ڶ��̷߳���ʱ�𵽰�ȫ�������õ�,Ҳ����˵StringBuffer���̰߳�ȫ�ġ�
		 */
		StringBuilder stringBuilder = new StringBuilder();
        for(int i=0;i<10000;i++){
            stringBuilder.append("hello");
        }
        
        StringBuffer stringBuffer = new StringBuffer();
        for(int i=0;i<10000;i++){
            stringBuffer.append("hello");
        }
        
        // ���ܲ���
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
        System.out.println("����"+s.getClass().getName()+"����ʹ�õ�ʱ��Ϊ��"+(over-begin)+"����");
    }
 
	// StringBuffer +=
    public static void testStringBuffer () {
        StringBuffer sb = new StringBuffer();
        long begin = System.currentTimeMillis();
        for(int i=0; i<time; i++){
            sb.append("java");
        }
        long over = System.currentTimeMillis();
        System.out.println("����"+sb.getClass().getName()+"����ʹ�õ�ʱ��Ϊ��"+(over-begin)+"����");
    }
 
    // StringBuilder +=
    public static void testStringBuilder () {
        StringBuilder sb = new StringBuilder();
        long begin = System.currentTimeMillis();
        for(int i=0; i<time; i++){
            sb.append("java");
        }
        long over = System.currentTimeMillis();
        System.out.println("����"+sb.getClass().getName()+"����ʹ�õ�ʱ��Ϊ��"+(over-begin)+"����");
    }
    
    // String
    public static void test1String () {
        long begin = System.currentTimeMillis();
        for(int i=0; i<time; i++){
        	/*
        	 * ���´��뱻�������Ż���ע�͵����� 
        	 */
        	/*
        	for(int i = 0; i < time; i++){
            	String s = "Ilovejava";
        	}
        	 */
            String s = "I"+"love"+"java";
        }
        long over = System.currentTimeMillis();
        System.out.println("�ַ���ֱ����Ӳ�����"+(over-begin)+"����");
    }
 
    public static void test2String () {
        String s1 ="I";
        String s2 = "love";
        String s3 = "java";
        long begin = System.currentTimeMillis();
        /*
    	 * ���´��뱻�������Ż���ע�͵����� 
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
        System.out.println("�ַ��������Ӳ�����"+(over-begin)+"����");
    }
}
