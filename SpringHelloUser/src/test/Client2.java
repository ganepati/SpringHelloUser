package test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import beans.Test;

public class Client2 {
	public static void main(String[] args) {
		Resource resource=new ClassPathResource("resource/Spring.xml");
		BeanFactory factory=new XmlBeanFactory(resource);
		//at load time object not created.
		
		Test t=(Test)factory.getBean("t");  //if we calling getbean(), now object is created.
		t.sayHello();
		
		System.out.println("------------------------");
		ApplicationContext ap=new ClassPathXmlApplicationContext("resource/Spring.xml");
		//at load time object created. if the scope is prototype that time object not created at load time.
		Test t1=(Test)ap.getBean("t");
		t1.sayHello();
		
	}
}
