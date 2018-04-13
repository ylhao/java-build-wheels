import java.util.Comparator;

/*
 *  Comparable �ӿڵĶ�������

public interface Comparable<T> {
    public int compareTo(T o);
}

*/


/*	Comparator �ӿڵĶ������£�ֻ�г�����Ҫ������������ compare ���ⲿ�Ƚ����Ļ���������equals �ǱȽ������Ƚ����Ƿ���ͬ��

public interface Comparator<T> {
     int compare(T o1, T o2);
     boolean equals(Object obj);
}

 */


/* 
 Comparable �Ƕ����ڲ����еıȽϣ�һ����Ĳ�ͬ����϶���Ҫ����Ȼ�ıȽϣ�����ʹ�����κεط�
 Comparator ���ⲿ�Ƚϣ��ڲ��ı�����ڲ����еıȽϱ�׼��ǰ���£������µıȽ���Ϊ�� �����Ƕ����е����ͣ����� String��Integer ��
 */


/*
String ��̳��� Comparable �ӿڣ�ʵ���� compareTo �������Ƚ������ַ����Ĵ�С����������붨���Լ��ıȽ���Ϊ�أ�������ֻ�Ƚϵ�һ���ַ��Ƿ���ͬ
public int compareTo(String anotherString) {
        int len1 = value.length;
        int len2 = anotherString.value.length;
        int lim = Math.min(len1, len2);
        char v1[] = value;
        char v2[] = anotherString.value;

        int k = 0;
        while (k < lim) {
            char c1 = v1[k];
            char c2 = v2[k];
            if (c1 != c2) {
                return c1 - c2;
            }
            k++;
        }
        return len1 - len2;
    }
 */

/*�����Զ�����ⲿ�Ƚ�����ֻ�Ƚϵ�һ���ַ�*/
class MyComparator implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		String str1 = (String) o1;
		String str2 = (String) o2;
		return (int) (str1.charAt(0) - str2.charAt(0));
	}
	
}


public class Test {
	public static void main(String[] args) {
		String str1 = "abcdfsdf";
		String str2 = "abbbbbbb";
		System.out.println(str1.compareTo(str2));
		System.out.println(new MyComparator().compare(str1, str2));
	}
}
