package innerclass;


// �����ڲ�����û�з������η��ġ�
// new �����ڲ��࣬�����������Ҫ���ڵġ�������ǽ��Ǹ�InnerClass�ӿ�ע�͵����ͻ���ֱ������
// ע��getInnerClass()�������βΣ���һ���β�����final���εģ����ڶ���ȴû�С�
// ͬʱ����Ҳ���ֵڶ����β��������ڲ�����û��ʹ�ù������Ե����ڷ������β���Ҫ�������ڲ���ʹ�ã���ô����βξͱ���Ϊfinal��

// �����ڲ�����û�й��췽���ġ���Ϊ�������ֶ�û�к������췽����

interface InnerClass {
    int getNumber();
}


class OuterClass {
    
	// �����ڷ������β���Ҫ�������ڲ���ʹ�ã���ô����βξͱ���Ϊfinal��
	public InnerClass getInnerClass(final int num, String str2){
    	return new InnerClass(){
            int number = num + 3;
            public int getNumber(){
                return number;
            }
        };        /* ע�⣺�ֺŲ���ʡ */
    }
    
   
}


public class Test2 {
	public static void main(String[] args) {
		OuterClass out = new OuterClass();
		InnerClass inner = out.getInnerClass(2, "chenssy");
		System.out.println(inner.getNumber());
	}
}