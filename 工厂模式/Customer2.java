package customer2;
/* �򵥹���ģʽ
 * 
 * 
 * �����û���Ҫ�³�ϵ������BMW X11
 * 
 * ��������Ҫ������Ӧ�ľ����Ʒ�� BMWX11
 * 
 * ��������Ҫ�ڹ���������� case(11) ���ƵĴ���
 *
 * ��Ʒ������Ͽ���ԭ�򣨶���չ���ţ����޸ķ�գ���ֱ�����Ӳ�Ʒ�༴�ɡ�����������Ͳ�̫�����ˣ���Ҫ�޸� createBMW ����
 * ���ֹ�����Ҳ���ϵ���
 * 
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

// ������ɫ
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
