package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializableDemo1 {
	public static void main(String[] args) {
		User1 user = new User1();
		user.setName("ylhao");
		user.setAge(25);
		System.out.println(user);
		
		// write to file
		// user => 对象输出流  => 文件输出流 => tempFile 文件
		// 这里使用了语法糖：try-with-resources
		try(FileOutputStream fos = new FileOutputStream("tempFile");
				ObjectOutputStream oos = new ObjectOutputStream(fos)) {
			oos.writeObject(user);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// read object from file
		// newUser <= 对象输入流  <= 文件输入流 <= tempFile 文件
		// 这里使用了语法糖：try-with-resources
		File file = new File("tempFile");
		try(FileInputStream fis = new FileInputStream(file);
				ObjectInputStream ois = new ObjectInputStream(fis)) {
			User1 newUser = (User1)ois.readObject();
			System.out.println(newUser);
			System.out.println(user == newUser);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
