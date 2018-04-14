package customer2;
/* 简单工厂模式
 * 
 * 
 * 假设用户想要新车系，比如BMW X11
 * 
 * 首先我们要创建对应的具体产品类 BMWX11
 * 
 * 首先我们要在工厂类中添加 case(11) 类似的代码
 *
 * 产品方面符合开闭原则（对扩展开放，对修改封闭），直接增加产品类即可。但工厂方面就不太符合了，需要修改 createBMW 方法
 * 这种工厂类也叫上帝类
 * 
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

// 工厂角色
class BMWFactory {
	public BMW createBWM(int type) {
		switch(type) {
		case 320:
			return new BMW320();
		case 523:
			return new BMW523();
		default:
			break;
		}
		return null;
	}
}

public class Customer2 {
	public static void main(String[] args) {
		BMWFactory factory = new BMWFactory();
		BMW bmw320 = factory.createBWM(320);
		BMW bmw523 = factory.createBWM(523);
	}
}
