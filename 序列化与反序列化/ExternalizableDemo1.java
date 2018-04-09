package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/*
 * Externalizable继承了Serializable，该接口中定义了两个抽象方法：writeExternal()与readExternal()。
 * 当使用Externalizable接口来进行序列化与反序列化的时候需要开发人员重写writeExternal()与readExternal()方法。
 * */
public class ExternalizableDemo1 {
	public static void main(String[] args) {
		// Write object to file
		User2 user = new User2();
		user.setName("ylhao");
		user.setAge(25);
		System.out.println(user);
		try(FileOutputStream fos = new FileOutputStream("tempFile");
				ObjectOutputStream oos = new ObjectOutputStream(fos)) {
			oos.writeObject(user);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Read object from file
		File file = new File("tempFile");
		try(FileInputStream fis = new FileInputStream(file);
				ObjectInputStream ois = new ObjectInputStream(fis)) {
			User2 newUser = (User2)ois.readObject();
			System.out.println(newUser);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
