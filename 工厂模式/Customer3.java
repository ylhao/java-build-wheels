package customer3;

/* ��������ģʽ
 * 
 * �����û���Ҫ�³�ϵ������BMW X11
 * 
 * ��������Ҫ������Ӧ�ľ����Ʒ�� BMWX11
 * 
 * ��������Ҫ������Ӧ�ľ��幤�� FactoryBMWX11
 *
 * �����Զ���Ĵ������̽����˰�װ�������ǲ�Ʒ���滹�ǹ������涼���Ͽ���ԭ��
 * 
 * ��������Ҳ�����ԣ�ÿ�����Ӳ�Ʒ����������ɱ�����
 */
// �����Ʒ��ɫ
interface BMW {
	
}

// �����Ʒ��ɫ
class BMW523 implements BMW{
	public BMW523() {
		System.out.println("����-->BMW523");
	}
}

// �����Ʒ��ɫ
class BMW320 implements BMW{
	public BMW320() {
		System.out.println("����-->BMW320");
	}
}

// ���󹤳���ɫ
interface FactoryBMW {  
    BMW createBMW();  
}

// ���幤����ɫ
class FactoryBMW320 implements FactoryBMW{  
    @Override  
    public BMW320 createBMW() {  
        return new BMW320();  
    }
}

// ���幤����ɫ
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
