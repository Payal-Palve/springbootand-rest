package com.config;



@Configuration
@ComponentScan("com.pojo")
public class StudConfig {

	public StudConfig() {
		System.out.println("loaded...........");
	}
	

}
