package innerclass;

// ��̬�ڲ���
// ��̬�ڲ���Ĵ����ǲ���Ҫ��������Χ��ġ�
// ��̬�ڲ��಻��ʹ���κ���Χ��ķ�static��Ա�����ͷ�����

class OuterClass1 {
    private String sex;
    public static String name = "chenssy";
    
    static class InnerClass1{
        /* �ھ�̬�ڲ����п��Դ��ھ�̬���Ժͷ��������ڷǾ�̬�ڲ������ǲ����Ե� */
        public static String name1 = "chenssy_static";
        
        public void display(){
            /* 
             * ��̬�ڲ���ֻ�ܷ�����Χ��ľ�̬��Ա�����ͷ���
             * ���ܷ�����Χ��ķǾ�̬��Ա�����ͷ���
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
		// ��̬�ڲ���Ĵ����ǲ���Ҫ��������Χ��ġ�
		OuterClass1 o = new OuterClass1();
		o.display();
		OuterClass1.InnerClass1 ic = new OuterClass1.InnerClass1();
	}
}
