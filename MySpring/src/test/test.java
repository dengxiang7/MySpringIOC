package test;

import SpringFrameWork.Context.support.FileSystemXmlApplicationContext;

public class test {

	public static void main(String[] args) {

		String path="F:/MyEclipse/myeclipse-pro-2014-GA/JavaEE workspace/Spring/src/spring.xml";
		
		FileSystemXmlApplicationContext fc=new FileSystemXmlApplicationContext(path);
		
		student s=(student) fc.getBean("student");
		s.setName("���޼ɼ�");
		System.out.println(s.getName());
		
		person p=(person) fc.getBean("person");
		p.setAge(99);
		p.setName("��ӹ");
		System.out.println(p.getAge()+p.getName());
	}

}
