package com.eastindia.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class WebApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebApplication.class, args);


//		测试数据库连接`
//            ConfigurableApplicationContext context = SpringApplication.run(WebApplication.class, args);
//            JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);
//            List<Map<String, Object>> result = jdbcTemplate.queryForList("SELECT * FROM test");
//            System.out.println(result);

	}

}
