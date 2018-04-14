package customer4;

/*
 * 抽象工厂模式
 * 
 * 
 * 抽象工厂模式针对的是产品族，而不是产品，每个工厂创建的是一个族的产品
 * 
 * 
 */


interface Engine {
	
}

class EngineA implements Engine {
	public EngineA() {
		System.out.println("创建-->Engine A");
	}
}

class EngineB implements Engine {
	public EngineB() {
		System.out.println("创建-->Engine B");
	}
}

interface AirCondition {
	
}

class AirConditionA implements AirCondition {
	public AirConditionA() {
		System.out.println("创建 --> AirConditionA");
	}
}

class AirConditionB implements AirCondition {
	public AirConditionB() {
		System.out.println("创建 --> AirConditionB");
	}
}


//抽象工厂角色
interface FactoryBMW {
	AirCondition createAirCondition();
	Engine createEngine();
}

//具体工厂角色
class FactoryBMW320 implements FactoryBMW{  
	@Override
	public AirCondition createAirCondition() {
		return new AirConditionA();
	}
	@Override
	public Engine createEngine() {
		return new EngineA();
	}
}

// 具体工厂角色
class FactoryBMW523 implements FactoryBMW{  
	@Override
	public AirCondition createAirCondition() {
		return new AirConditionB();
	}
	@Override
	public Engine createEngine() {
		return new EngineB();
	}
}

public class Customer4 {
	public static void main(String[] args) {
		FactoryBMW factory320 = new FactoryBMW320();
		factory320.createEngine();
		factory320.createAirCondition();
		
		FactoryBMW factory523 = new FactoryBMW523();
		factory523.createEngine();
		factory523.createAirCondition();
		
	}
}
