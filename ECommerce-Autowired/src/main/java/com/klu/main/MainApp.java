package com.klu.main;
import com.klu.config.AppConfig;
import com.klu.model.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		ApplicationContext cn=new AnnotationConfigApplicationContext(AppConfig.class);
		Order ord=cn.getBean(Order.class);
		ord.disp();
		//annotationconfig up one
		ApplicationContext cn1=new ClassPathXmlApplicationContext("applicationContext.xml");
		Order ord1=cn1.getBean(Order.class);
		ord1.disp();
		//Xml config one
	}
}