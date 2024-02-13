package com.dev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class AccountWebClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountWebClientApplication.class, args);
	}
	
//	@Bean
//	public MessageSource messageSource() {
//	    ReloadableResourceBundleMessageSource messageSource
//	      = new ReloadableResourceBundleMessageSource();
//	    
//	    messageSource.setBasename("classpath:messages");
//	    messageSource.setDefaultEncoding("UTF-8");
//	    return messageSource;
//	}
	
//	@Bean
//	public LocalValidatorFactoryBean getValidator() {
//	    LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
//	    bean.setValidationMessageSource(messageSource());
//	    return bean;
//	}

}
