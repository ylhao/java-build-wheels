package innerclass;


// 成员内部类
// 成员内部类可以无条件访问外部类的所有属性和方法，包括私有的和静态的
// 当成员内部类拥有和外部类同名的成员变量或者方法时，会发生隐藏现象，即默认情况下访问的是成员内部类的成员
// 成员内部类中不能存在任何static的变量和方法
// 成员内部类是依附于外围类的，所以只有先创建了外围类才能够创建内部类
// 建议使用 getXXX() 的方式创建内部类
// 外围类要访问内部类的成员属性和方法则需要通过内部类实例来访问


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
    	// 外围类要访问内部类的成员属性和方法则需要通过内部类实例来访问
    	new Draw().drawShape();
    }
    
    public static void staticTest() {
    	System.out.println("this is Circle's static test func.");		
    }
    
    /*推荐使用getxxx()来获取成员内部类，尤其是该内部类的构造函数无参数时 */
    public Draw getDraw(){
        return new Draw();
    }
    
    class Draw {
    	// 属性与外部类重名，发生覆盖，直接访问属性，访问的是内部类的属性
    	public double radius = 5.0;
    	
    	// 属性与外部类重名，发生覆盖，直接调用方法，调用的是内部类的方法
    	private void test() {
    		System.out.println("this is Draw's test func.");
    	}
    	
    	// 成员内部类中不能有任何 static 的变量和方法
//    	public static int posX = 0;
    	
    	// 成员内部类中不能有任何 static 的变量和方法
//    	public static void staticTest() {
//    		System.out.println("this is Draw's test func.");
//    	}
    	
        public void drawShape() {
            test();  // 外部类方法被覆盖，访问的是内部类的方法
            Circle.this.test();  // 发生覆盖的情况下，访问外部类同名方法
            staticTest();  // 访问外部类静态方法
            Circle.staticTest();  // 访问外部类静态方法
            System.out.println("Draw's radius: " + radius);  // 访问私有属性，发生了覆盖
            System.out.println("Circle's radius: " + Circle.this.radius);  // 发生覆盖的情况下，访问外部类同名属性的方式
            System.out.println("Circle's color" + color);  // 访问外部类私有属性
            System.out.println("posX: " + posX);  // 访问外部类静态属性
            System.out.println("posY: " + posY);  // 访问外部类静态属性
        }
    }
}

public class Test1 {
	public static void main(String[] args) {
		Circle c = new Circle(2.0);
		c.test1();
		Circle.Draw d = c.new Draw();
		d.drawShape();
		// 通过 getDraw() 的方式创建成员内部类对象
		Circle.Draw d2 = c.getDraw();
		d2.drawShape();
	}
}