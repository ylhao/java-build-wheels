package customer4;

/*
 * ���󹤳�ģʽ
 * 
 * 
 * ���󹤳�ģʽ��Ե��ǲ�Ʒ�壬�����ǲ�Ʒ��ÿ��������������һ����Ĳ�Ʒ
 * 
 * 
 */


interface Engine {
	
}

class EngineA implements Engine {
	public EngineA() {
		System.out.println("����-->Engine A");
	}
}

class EngineB implements Engine {
	public EngineB() {
		System.out.println("����-->Engine B");
	}
}

interface AirCondition {
	
}

class AirConditionA implements AirCondition {
	public AirConditionA() {
		System.out.println("���� --> AirConditionA");
	}
}

class AirConditionB implements AirCondition {
	public AirConditionB() {
		System.out.println("���� --> AirConditionB");
	}
}


//���󹤳���ɫ
interface FactoryBMW {
	AirCondition createAirCondition();
	Engine createEngine();
}

//���幤����ɫ
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

// ���幤����ɫ
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
