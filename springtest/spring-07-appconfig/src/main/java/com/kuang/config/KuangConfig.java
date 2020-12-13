package com.kuang.config;

import com.kuang.pojo.User;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

//这个也会被Spring容器托管,注册到容器中,因为他本来就是一个@Component,
// @Configuration代表这是一个配置类,就和我们之前看到的beans.xml一样
//@Configuration
//@ComponentScan("com.kuang.pojo")
@Import(KuangConfig2.class)
public class KuangConfig {

	//注册一个bean,就相当于我们之前写的一个bean标签,
	//这个方法的名字,就相当于bean标签中的id属性
	//这个方法的返回值,就相当于bean标签中的class属性
//	@Bean
//	public User getUser(){
//		return new User();
//	}

}
