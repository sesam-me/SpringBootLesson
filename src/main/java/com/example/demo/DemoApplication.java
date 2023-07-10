package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
////		올라간 Bean 전체 보기
		SpringApplication.run(DemoApplication.class, args);
//		String[] beanDefinitionNames = run.getBeanDefinitionNames();
//		for(String b:beanDefinitionNames){
//			System.out.println(b);
//		}
	}

}
