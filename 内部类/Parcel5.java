package innerclass;

// �ֲ��ڲ���
// �ֲ��ڲ����Ƕ�����һ����������һ��������������࣬���ͳ�Ա�ڲ�����������ھֲ��ڲ���ķ��ʽ����ڷ����ڻ��߸��������ڡ�
// �ֲ��ڲ�������Ƿ��������һ���ֲ�����һ�����ǲ�����public��protected��private�Լ�static���η��ġ�

interface Destionation {
	public String readLabel();
}


public class Parcel5 {
    public Destionation destionation(String str){
    	// �� destionation �������ڶ�����һ�� PDestionation �࣬ʵ���� Destionation �ӿ�
    	class PDestionation implements Destionation{
            private String label;
            private PDestionation(String whereTo){
                label = whereTo;
            }
            public String readLabel(){
                return label;
            }
        }
        return new PDestionation(str);
    }
    
    public static void main(String[] args) {
        Parcel5 parcel5 = new Parcel5();
        Destionation d = parcel5.destionation("chenssy");
        System.out.println(d.readLabel());
    }
}
