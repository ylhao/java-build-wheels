package test;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/*
 * Externalizable�̳���Serializable���ýӿ��ж������������󷽷���writeExternal()��readExternal()��
 * ��ʹ��Externalizable�ӿ����������л��뷴���л���ʱ����Ҫ������Ա��дwriteExternal()��readExternal()������
 * */
public class User2 implements Externalizable {
	private String name;
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return String.format("User{name=%s, age=%d}", name, age);
	}
	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeObject(name);
		out.writeInt(age);
	}
	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		name = (String) in.readObject();
		age = in.readInt();
	}
}
