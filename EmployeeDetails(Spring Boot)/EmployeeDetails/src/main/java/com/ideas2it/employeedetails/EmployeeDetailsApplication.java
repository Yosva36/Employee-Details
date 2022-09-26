package com.ideas2it.employeedetails;

import com.ideas2it.employeedetails.filter.EmployeeFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.SpringServletContainerInitializer;

@SpringBootApplication
public class EmployeeDetailsApplication extends SpringServletContainerInitializer {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeDetailsApplication.class, args);
	}

	@Bean
	FilterRegistrationBean<EmployeeFilter> traineeFilterFilterRegistrationBean() {
		FilterRegistrationBean<EmployeeFilter> filterFilterRegistrationBean = new FilterRegistrationBean<>();
		filterFilterRegistrationBean.setFilter(new EmployeeFilter());
		filterFilterRegistrationBean.addUrlPatterns("/trainees/*");
		return filterFilterRegistrationBean;
	}
}
