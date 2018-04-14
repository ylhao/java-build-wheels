package customer3;

/* 工厂方法模式
 * 
 * 假设用户想要新车系，比如BMW X11
 * 
 * 首先我们要创建对应的具体产品类 BMWX11
 * 
 * 首先我们要创建对应的具体工厂 FactoryBMWX11
 *
 * 工厂对对象的创建过程进行了包装，不管是产品方面还是工厂方面都符合开闭原则
 * 
 * 但是问题也很明显，每当增加产品，类的数量成倍增加
 */
// 抽象产品角色
interface BMW {
	
}

// 具体产品角色
class BMW523 implements BMW{
	public BMW523() {
		System.out.println("制造-->BMW523");
	}
}

// 具体产品角色
class BMW320 implements BMW{
	public BMW320() {
		System.out.println("制造-->BMW320");
	}
}

// 抽象工厂角色
interface FactoryBMW {  
    BMW createBMW();  
}

// 具体工厂角色
class FactoryBMW320 implements FactoryBMW{  
    @Override  
    public BMW320 createBMW() {  
        return new BMW320();  
    }
}

// 具体工厂角色
class FactoryBMW523 implements FactoryBMW{  
    @Override  
    public BMW523 createBMW() {  
        return new BMW523();  
    }
}

public class Customer3 {
	public static void main(String[] args) {
		FactoryBMW factory320 = new FactoryBMW320(); 
		BMW bmw320 = factory320.createBMW();
		FactoryBMW factory523 = new FactoryBMW523(); 
		BMW bmw523 = factory523.createBMW();
	}
}
