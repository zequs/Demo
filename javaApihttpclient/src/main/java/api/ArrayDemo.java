package api;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
public class ArrayDemo {

	public static void main(String [] args) {
		testA();
		System.out.println("===========================");
		testB();
		System.out.println("===========================");
		testC();
	}

	//去掉数组中重复的值
	public static void testA() {
		String [] str = {"Java", "C++", "Php", "C#", "Python", "C++", "Java"};
		for (String elementA:str ) {
			System.out.print(elementA + " ");
		}
        List<String> list = new ArrayList<String>();
		for (int i=0; i<str.length; i++) {
			if(!list.contains(str[i])) {
				list.add(str[i]);
			}
		}
		/*
		Set<String> set = new HashSet<String>();
		for (int i=0; i<str.length; i++) {
			set.add(str[i]);
		}
		String[] newStr =  set.toArray(new String[1]); 
		*/
		System.out.println();
		String[] newStr =  list.toArray(new String[1]); //返回一个包含所有对象的指定类型的数组 
		for (String elementB:newStr ) {
			System.out.print(elementB + " ");
		}
		System.out.println();
	}

	//删除数组中其中一个元素
	public static void testB() {
		String [] str = {"Java", "C++", "Php", "C#", "Python"};
		for (String elementA:str ) {
			System.out.print(elementA + " ");
		}
		//删除php
		List<String> list = new ArrayList<String>();
		for (int i=0; i<str.length; i++) {
			list.add(str[i]);
		}
		list.remove(2); //list.remove("Php") 
		System.out.println();
		String[] newStr =  list.toArray(new String[1]); //返回一个包含所有对象的指定类型的数组 
		for (String elementB:newStr ) {
			System.out.print(elementB + " ");
		}	
		System.out.println();
	}

	//在数组中增加一个元素
	public static void testC() {
		String [] str = {"Java", "C++", "Php", "C#", "Python"};
		for (String elementA:str ) {
			System.out.print(elementA + " ");
		}
		//增加ruby
		List<String> list = new ArrayList<String>();
		for (int i=0; i<str.length; i++) {
			list.add(str[i]);
		}
		list.add(2, "ruby"); //list.add("ruby") 
		System.out.println();
		String[] newStr =  list.toArray(new String[1]); //返回一个包含所有对象的指定类型的数组 
		for (String elementB:newStr ) {
			System.out.print(elementB + " ");
		}	
		System.out.println();
	}
}
