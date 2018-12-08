Spring IOC
•	IOC
1. Core Container - Bean Factory
2. J2EE Container- Application Context.

IOC Container do following things.
1) IOC Container will Create the instance of POJO Classes.
2) Manage Life Cycle of POJO classes.
3) Dependency Injection into POJO Classes.

1). Core Container - Bean Factory
       
On load time BeanFactory container not created the object of bean class. On the first user request it will create the obect in JVM. Before that SAX Parser will check Syntax of Xml file. If Syntax not Correct it will throw SaxParserException. 

2. J2EE Container- Application Context.
On load time Application Context created the object of bean class. If we change the scope to "prototype" that time object not created.

•	Simple SpringHelloUser Project.
Step :-
1. Create New Java Project - HelloUser
2. In src folder create three packages name beans, resources, test.
3. create Test class in beans package.
4. create spring.xml file in resource package.
5. create Client class in test package.

For Download : https://github.com/ganepati/SpringHelloUser

1. Test.java	
	package beans;
	public class Test {	
		private String user;
		//getter
		public String getUser() {
			return user;
		}
		//We use setter for setter Dependancy Injection , we will discuss soon.
		//setter
		public void setUser(String user) {
			this.user = user;
		}
		public void sayHello() {
			System.out.println("Hello, "+getUser());
			System.out.println("Welcome to Spring Demo Program");
		}	
}

2.Spring.xml
	Before creating spring.xml file add Spring Core Jar
	1.Project ->Right Click->Build Path->Add following four Jar file.
		org-apache-commons-logging.jar
		spring-beans.jar
		spring-context.jar
		spring-core.jar

	2.Open Spring-bean.jar ->Select... org.springframework.beans.factory.xml ->
	Open -> spring-beans-2.0.dtd copy 36 & 37 line no & past it into Spring.xml file.
	
Spring.xml file
	<?xml version="1.0" encoding="UTF-8"?>
		<!DOCTYPE beans PUBLIC "-//SPRING//DTD BEAN 2.0//EN"
			  "http://www.springframework.org/dtd/spring-beans-2.0.dtd">	  
		<beans>
			<bean id="t" class="beans.Test">
				<property name="user" value="Ganesh"></property>
			</bean>
	</beans>
Client.java
Using Core Container - BeanFactory
package test;

import org.springframework.beans.factory.BeanFactory;
import beans.Test;	
public class Client {
	
	public static void main(String[] args) {
		Resource resource=new ClassPathResource("resources/Spring.xml");
		BeanFactory factory = new XmlBeanFactory(resource);
		Test t=(Test)factory.getBean("t");
		t.sayHello();	
	}
}
Finally Run Client.java file As java Application
Output
Oct 01, 2018 7:05:27 PM org.springframework.beans.factory.xml.XmlBeanDefinitionReader loadBeanDefinitions
INFO: Loading XML bean definitions from class path resource [resources/Spring.xml]
Hello, Ganesh
Welcome to Spring Demo Program

Using J2EE Container -ApplicationContext
package test;	
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import beans.Test;

public class Client {
	public static void main(String[] args) {
		ApplicationContext ap=new ClassPathXmlApplicationContext("resources/Spring.xml");
		Test t=(Test)ap.getBean("t");
		t.sayHello();
	}
}

Output
Oct 01, 2018 7:08:36 PM org.springframework.context.support.AbstractApplicationContext prepareRefresh
INFO: Refreshing org.springframework.context.support.ClassPathXmlApplicationContext@6acbcfc0: display name [org.springframework.context.support.ClassPathXmlApplicationContext@6acbcfc0]; startup date [Mon Oct 01 19:08:36 IST 2018]; root of context hierarchy
Oct 01, 2018 7:08:36 PM org.springframework.beans.factory.xml.XmlBeanDefinitionReader loadBeanDefinitions
INFO: Loading XML bean definitions from class path resource [resources/Spring.xml]
Oct 01, 2018 7:08:37 PM org.springframework.context.support.AbstractApplicationContext obtainFreshBeanFactory
INFO: Bean factory for application context [org.springframework.context.support.ClassPathXmlApplicationContext@6acbcfc0]: org.springframework.beans.factory.support.DefaultListableBeanFactory@4926097b
Oct 01, 2018 7:08:37 PM org.springframework.beans.factory.support.DefaultListableBeanFactory preInstantiateSingletons
INFO: Pre-instantiating singletons in org.springframework.beans.factory.support.DefaultListableBeanFactory@4926097b: defining beans [t]; root of factory hierarchy

Hello, Ganesh

Welcome to Spring Demo Program
