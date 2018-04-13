import java.util.Comparator;

/*
 *  Comparable 接口的定义如下

public interface Comparable<T> {
    public int compareTo(T o);
}

*/


/*	Comparator 接口的定义如下（只列出了主要方法），其中 compare 是外部比较器的基本方法，equals 是比较两个比较器是否相同的

public interface Comparator<T> {
     int compare(T o1, T o2);
     boolean equals(Object obj);
}

 */


/* 
 Comparable 是对象内部固有的比较，一个类的不同对象肯定需要很自然的比较，无论使用在任何地方
 Comparator 是外部比较，在不改变对象内部固有的比较标准的前提下，增加新的比较行为， 尤其是对已有的类型，比如 String，Integer 等
 */


/*
String 类继承了 Comparable 接口，实现了 compareTo 方法，比较两个字符串的大小，如果我们想定义自己的比较行为呢？？比如只比较第一个字符是否相同
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

/*我们自定义的外部比较器，只比较第一个字符*/
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
