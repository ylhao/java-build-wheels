import java.util.ArrayList;
import java.util.List;

public class HeaoOOM {
	static class OOMObject {
		
	}
	public static void main(String[] args) {
		/*
		 * Java �����
		 * -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError 
		 * ���ȴ��������� OOMObject ��Ķ����ǲ��ᱻ���յ�
		 * -Xms20m -Xmx20m �޶��˶��ڴ��С20M���Ҳ����Զ���չ������Xms Xmxֵһ������ֹ���Զ���չ��
		 * ���Ի����
		 */
		List<OOMObject> list = new ArrayList<>();
		while(true) {
			list.add(new OOMObject());
		}
	}
}
