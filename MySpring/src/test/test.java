package test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import SpringFrameWork.Bean.Factory.Support.XmlBeanDefinitionReader;
import SpringFrameWork.Context.support.ClassPathXmlApplicationContext;
import SpringFrameWork.Context.support.FileSystemXmlApplicationContext;

public class test {

	public static void main(String[] args) {

		String path="F:/MyEclipse/myeclipse-pro-2014-GA/JavaEE workspace/MySpring/src/spring-bean.xml";
		

		System.out.println("============FileSystemXmlApplicationContext================");
		FileSystemXmlApplicationContext fc=new FileSystemXmlApplicationContext(path);
		
		student s=(student) fc.getBean("student");
		s.setName("���޼�");
		System.out.println(s.getName());
		
		person p=(person) fc.getBean("person");
		p.setAge(99);
		p.setName("��ӹ");
		System.out.println(p.getAge()+p.getName());
		
		System.out.println("============ClassPathXmlApplicationContext================");
		String path1="classpath:test/spring.xml";
		
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext(path1);
		
		student ss=(student)context.getBean("student");
		ss.setName("���");
		System.out.println(ss.getName());
		
		
		System.out.println("====================����ע��================");
		
		System.out.println("   ѧ��������"+ss.getName()+"   ��ʦ������"+ss.getP().getName());
	
	}
}
