package com.eastindia;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient//开启eureka客户端功能
//@MapperScan(basePackages = {"com.eastindia.mapper"})//是spring用于批量注入mybatis映射器(DAO接口)的注解。与之相对应@Mapper进行单个注册。
public class ProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProviderApplication.class, args);


//		测试数据库连接`
//		ConfigurableApplicationContext context = SpringApplication.run(ProviderApplication.class, args);
//		JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);
//		List<Map<String, Object>> result = jdbcTemplate.queryForList("SELECT * FROM sys_user");
//		System.out.println(result);

	}

}
