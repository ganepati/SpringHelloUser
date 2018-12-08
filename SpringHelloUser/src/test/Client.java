package test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import beans.Test;

public class Client {
	public static void main(String[] args) {
		Resource resource = new ClassPathResource("resource/Spring.xml");
		BeanFactory factory = new XmlBeanFactory(resource);
		// at load time object not created.
		System.out.println("------------------------");
		ApplicationContext ap = new ClassPathXmlApplicationContext("resource/Spring.xml");

	}
}
