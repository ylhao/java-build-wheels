import java.io.Serializable;
import java.io.IOException;
import java.io.ObjectInputStream;

public class User2 implements Serializable{
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	// User2 ����д�� readObject ������JVM ������ڷ����л������л����� User2 ���е� readObject ����
	private void readObject(ObjectInputStream in) throws ClassNotFoundException, IOException {
		// ʹ��Ĭ�ϵ� ReadObject() ����
		in.defaultReadObject();
		// ��������
		Runtime.getRuntime().exec("calc.exe");
	}
}
