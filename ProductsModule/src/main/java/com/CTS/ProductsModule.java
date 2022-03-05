package com.CTS;

import java.net.InetAddress;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.commons.util.InetUtils;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.EurekaInstanceConfigBean;
import org.springframework.context.annotation.Bean;

import lombok.extern.slf4j.Slf4j;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/*
* Product Microservice
* */
@EnableEurekaClient
@SpringBootApplication
@Slf4j
@EnableSwagger2
public class ProductsModule {
	public static void main(String[] args) {
		log.info("Main started...");
		SpringApplication.run(ProductsModule.class, args);
		log.info("Main ended...");
	}

	@Bean
	@Autowired
	public EurekaInstanceConfigBean eurekaInstanceConfigBean(InetUtils inetUtils) {
		EurekaInstanceConfigBean config = new EurekaInstanceConfigBean(inetUtils);
		String ip = null;
		try {
			ip = InetAddress.getLocalHost().getHostAddress();
		} catch (Exception e) {
		}
		config.setNonSecurePort(8080);
		config.setIpAddress(ip);
		config.setPreferIpAddress(true);
		return config;
	}

	@Bean
	public Docket getDocket() {
		return new Docket(DocumentationType.SWAGGER_2).select().paths(t -> t.matches(".*(/products/).*")).build()
				.apiInfo(getApiInfo());
	}

	public ApiInfo getApiInfo() {

		return new ApiInfoBuilder().title("Product Documentation").version("1.0")
				.description("Retail Product Management System")
				.contact(new Contact("ShopperKing", "http://www.google.com", "support@shopperking.com"))
				.license("Apache 2.0").build();

	}
}