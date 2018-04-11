package object;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

public class PriorityQueueDemo1 {
	public static void main(String[] args) {
		PriorityQueue<Student> pq = new PriorityQueue<>(11,
			new Comparator<Student>() {
				public int compare(Student s1, Student s2) {
					// 升序
					return s1.grade - s2.grade;
					// 降序
					//return s2.grade - s1.grade;
				}
		});
		for(int i = 0; i < 10; i++) {
			String name = "s" + i;
			// 0 到 100 分（包含100）
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
	String name;  // 年龄
	int grade;  // 成绩
	public Student(String name, int grade) {
		this.name = name;
		this.grade = grade;
	}
	
	@Override
	public String toString() {
		return name + ": " + grade;
	}
}