package innerclass;

// 局部内部类
// 局部内部类是定义在一个方法或者一个作用域里面的类，它和成员内部类的区别在于局部内部类的访问仅限于方法内或者该作用域内。
// 局部内部类就像是方法里面的一个局部变量一样，是不能有public、protected、private以及static修饰符的。

interface Destionation {
	public String readLabel();
}


public class Parcel5 {
    public Destionation destionation(String str){
    	// 在 destionation 方法体内定义了一个 PDestionation 类，实现了 Destionation 接口
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
