package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/*
 * Externalizable�̳���Serializable���ýӿ��ж������������󷽷���writeExternal()��readExternal()��
 * ��ʹ��Externalizable�ӿ����������л��뷴���л���ʱ����Ҫ������Ա��дwriteExternal()��readExternal()������
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
