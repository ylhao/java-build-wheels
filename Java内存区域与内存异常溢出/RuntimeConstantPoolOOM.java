import java.util.ArrayList;
import java.util.List;

/*
 * -XX:PermSize=10M -XX:MaxPermSize=10M
 * �����˷�������С 10M���������10M
 * 
 * ��� HotSpot �������˵�����ô�Ҳ���Ƿ�������������������Ϣ����������̬��������ʱ�����������Ĵ����
 * ���� JDK1.7�Ժ󣨰���JDK1.7���Ѿ��ѳ������Ƴ������ô������� Native Memory �ķ�ʽ
 * ������ JDK1.7�������汾����ִ����δ��룬��һֱѭ����ȥ��
 * ���������������õ��Ƿ��������������� HotSpot �������˵Ҳ�������������ô�������
 */
public class RuntimeConstantPoolOOM {
	public static void main(String[] args) {
		// ʹ�� List �������ã����� Full GC ���ճ�������Ϊ
		List<String> list = new ArrayList<>();
		int i = 0;
		while(true) {
			System.out.println(i);
			list.add(String.valueOf(i++).intern());
		}
	}
}
