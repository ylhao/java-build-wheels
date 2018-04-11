package object;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

public class PriorityQueueDemo2 {
	public static void main(String[] args) {
		// lambda ���ʽд��������
		PriorityQueue<Student> pq = new PriorityQueue<>(11, (Student s1, Student s2) -> (s1.grade - s2.grade));
		for(int i = 0; i < 10; i++) {
			String name = "s" + i;
			// 0 �� 100 �֣�����100��
			int grade = new Random().nextInt(101);
			System.out.println(name + ": " + grade);
			pq.add(new Student(name, grade));
		}
		System.out.println();
		while(!pq.isEmpty()) {
			System.out.println(pq.poll());
		}
	}
}


class Student {
	String name;  // ����
	int grade;  // �ɼ�
	public Student(String name, int grade) {
		this.name = name;
		this.grade = grade;
	}
	
	@Override
	public String toString() {
		return name + ": " + grade;
	}
}