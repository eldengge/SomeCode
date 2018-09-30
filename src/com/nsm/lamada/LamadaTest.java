package com.nsm.lamada;

import java.util.ArrayList;
import java.util.List;

public class LamadaTest{
	
	public static void test1(){
		
		List<Student> stuList = new ArrayList<Student>();
		stuList.add(new Student(3,"a"));
		stuList.add(new Student(2, "c"));
		stuList.add(new Student(1, "b"));
		
		System.out.println("before sort:");
		
		stuList.forEach((student)->System.out.println(student));
		
		stuList.sort((stu1,stu2)->stu1.getAge()-stu2.getAge());
		
		System.out.println("after sort:");
		stuList.forEach((student)->System.out.println(student));
		
		System.out.println("after filter:");
		stuList.stream().filter((student)->student.getAge()>1).forEach(System.out::println);
		
		System.out.println("after limit");
		stuList.stream().limit(2).forEach(System.out::println);
		
	}
	
	public static void main(String[] args) {
		test1();
	}
	
}
