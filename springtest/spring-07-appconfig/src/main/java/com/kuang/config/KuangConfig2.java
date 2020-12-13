package com.kuang.config;


import com.kuang.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class KuangConfig2 {

    @Bean
	public User getUser(){
		return new User();
	}

}
