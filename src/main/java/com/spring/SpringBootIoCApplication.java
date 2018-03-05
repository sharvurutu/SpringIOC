package com.spring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.model.Personal;
import com.spring.model.UserInfo;

@SpringBootApplication
public class SpringBootIoCApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootIoCApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		simpleWorking();
		annotationWorking();
	}

	public void simpleWorking() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		System.out.println("Name = " + context.getBean("name", String.class));
		System.out.println("City = " + context.getBean("city", String.class));

		System.out.println("Constructor Based IoC");
		UserInfo userInfo = (UserInfo) context.getBean("userInfo", UserInfo.class);
		System.out.println("Name = " + userInfo.getName());
		System.out.println("City = " + userInfo.getCity());

		System.out.println("Setter Bassed IoC");
		UserInfo userDetails = (UserInfo) context.getBean("userDetails", UserInfo.class);
		System.out.println("Name = " + userDetails.getName());
		System.out.println("City = " + userDetails.getCity());
		userDetails.setCity("Chennai");

		System.out.println("checking Singleton scope...");
		UserInfo dupUserDetails = (UserInfo) context.getBean("userDetails", UserInfo.class);
		System.out.println("Name = " + dupUserDetails.getName());
		System.out.println("City = " + dupUserDetails.getCity());

	}

	public void annotationWorking() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("annotationApplicationContext.xml");
		Personal p = context.getBean("personalInfo", Personal.class);

		System.out.println("Annotation implementation ....");
		System.out.println("Person name = " + p.getUser().getName());
		System.out.println("Persona Mobile = " + p.getMobile());
	}
}
