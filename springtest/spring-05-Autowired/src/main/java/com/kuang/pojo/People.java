package com.kuang.pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.Resource;

public class People {



	//@Autowired
	//直接在属性上使用即可! 也可以在set方式上使用!
   //使用Autowired 我们可以不用编写Set方法了,前提是你这个自动装配的属性在IOC(Spring)容器中存在,且符合名字byname!
	//如果显示定义了Autowired的required属性为false,说明这个对象可以为null,否则不允许为空
	@Autowired(required = false)
	private Cat cat;
//	@Autowired                       //如果@Autowired自动装配的环境比较复杂,自动装配无法通过一个注解[@Autowired]完成的时候,我们可以
//	@Qualifier(value = "dog222")     //使用@Qualifier(value="xxx")去配置@Autowired的使用,指定一个唯一的bean对象注入!
	@Resource  //默认通过byname的方式实现,如果找不到名字,则通过byType实现!如果两个都找不到的情况下,就报错!
   private Dog dog;
	private String name;


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Cat getCat() {
		return cat;
	}

	public void setCat(Cat cat) {
		this.cat = cat;
	}

	public Dog getDog() {
		return dog;
	}

//	public void setDog(Dog dog) {
//		this.dog = dog;
//	}

	@Override
	public String toString() {
		return "People{" +
				"cat=" + cat +
				", dog=" + dog +
				'}';
	}
}
