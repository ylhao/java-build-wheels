package innerclass;


// ��Ա�ڲ���
// ��Ա�ڲ�����������������ⲿ����������Ժͷ���������˽�еĺ;�̬��
// ����Ա�ڲ���ӵ�к��ⲿ��ͬ���ĳ�Ա�������߷���ʱ���ᷢ���������󣬼�Ĭ������·��ʵ��ǳ�Ա�ڲ���ĳ�Ա
// ��Ա�ڲ����в��ܴ����κ�static�ı����ͷ���
// ��Ա�ڲ�������������Χ��ģ�����ֻ���ȴ�������Χ����ܹ������ڲ���
// ����ʹ�� getXXX() �ķ�ʽ�����ڲ���
// ��Χ��Ҫ�����ڲ���ĳ�Ա���Ժͷ�������Ҫͨ���ڲ���ʵ��������


class Circle {
    private double radius = 1.0;
    private String color = "red";
    public static int posX = 0;
    public static int posY = 0; 
    
    public Circle(double radius) {
        this.radius = radius;
    }
    
    private void test() {
    	System.out.println("this is Circle's test func.");
    }
    
    public void test1() {
    	// ��Χ��Ҫ�����ڲ���ĳ�Ա���Ժͷ�������Ҫͨ���ڲ���ʵ��������
    	new Draw().drawShape();
    }
    
    public static void staticTest() {
    	System.out.println("this is Circle's static test func.");		
    }
    
    /*�Ƽ�ʹ��getxxx()����ȡ��Ա�ڲ��࣬�����Ǹ��ڲ���Ĺ��캯���޲���ʱ */
    public Draw getDraw(){
        return new Draw();
    }
    
    class Draw {
    	// �������ⲿ���������������ǣ�ֱ�ӷ������ԣ����ʵ����ڲ��������
    	public double radius = 5.0;
    	
    	// �������ⲿ���������������ǣ�ֱ�ӵ��÷��������õ����ڲ���ķ���
    	private void test() {
    		System.out.println("this is Draw's test func.");
    	}
    	
    	// ��Ա�ڲ����в������κ� static �ı����ͷ���
//    	public static int posX = 0;
    	
    	// ��Ա�ڲ����в������κ� static �ı����ͷ���
//    	public static void staticTest() {
//    		System.out.println("this is Draw's test func.");
//    	}
    	
        public void drawShape() {
            test();  // �ⲿ�෽�������ǣ����ʵ����ڲ���ķ���
            Circle.this.test();  // �������ǵ�����£������ⲿ��ͬ������
            staticTest();  // �����ⲿ�ྲ̬����
            Circle.staticTest();  // �����ⲿ�ྲ̬����
            System.out.println("Draw's radius: " + radius);  // ����˽�����ԣ������˸���
            System.out.println("Circle's radius: " + Circle.this.radius);  // �������ǵ�����£������ⲿ��ͬ�����Եķ�ʽ
            System.out.println("Circle's color" + color);  // �����ⲿ��˽������
            System.out.println("posX: " + posX);  // �����ⲿ�ྲ̬����
            System.out.println("posY: " + posY);  // �����ⲿ�ྲ̬����
        }
    }
}

public class Test1 {
	public static void main(String[] args) {
		Circle c = new Circle(2.0);
		c.test1();
		Circle.Draw d = c.new Draw();
		d.drawShape();
		// ͨ�� getDraw() �ķ�ʽ������Ա�ڲ������
		Circle.Draw d2 = c.getDraw();
		d2.drawShape();
	}
}