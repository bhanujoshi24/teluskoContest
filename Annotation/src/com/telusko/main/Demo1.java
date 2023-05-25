package com.telusko.main;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

@Target({ElementType.TYPE , ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface DemoAnnotation{
	String metaData() default "Meta Info";
}

@DemoAnnotation(metaData = "This is my Demo Meta Data")
class Demo{
	
	@DemoAnnotation(metaData = "This is my Method Meta Data")
	public void show() {
		System.out.println("I am Show");
	}
}

public class Demo1 {

	public static void main(String[] args) throws NoSuchMethodException, Exception {
		// TODO Auto-generated method stub
		
		Demo demo = new Demo();
		
		Class c_demo = demo.getClass();
		Annotation an_demo = c_demo.getAnnotation(DemoAnnotation.class);
		
		DemoAnnotation dm_demo = (DemoAnnotation)an_demo;
		
		System.out.println(dm_demo.metaData());
		
		Method m_demo = c_demo.getMethod("show", null);
		
		Annotation an_met_demo = m_demo.getAnnotation(DemoAnnotation.class);
		
		DemoAnnotation dm_method_demo = (DemoAnnotation)an_met_demo;
		
		System.out.println(dm_method_demo.metaData());
		
		
		
	}

}
