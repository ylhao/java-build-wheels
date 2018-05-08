import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class Demo2 {
	
	public void run1() throws IOException {
		FileOutputStream fos = new FileOutputStream("user.bin");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		User2 user = new User2();
		user.setName("ylhao");
		oos.writeObject(user);
	}
	
	public void run2() throws IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream("user.bin");
		ObjectInputStream ois = new ObjectInputStream(fis);
		User2 user = (User2) ois.readObject();
		System.out.println(user.getName());
	}
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Demo2 demo = new Demo2();
		demo.run1();
		demo.run2();
	}
}
