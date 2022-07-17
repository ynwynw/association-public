package com.muxi.association;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author ZXW
 */
@SpringBootApplication
@MapperScan("com.muxi.association.mapper")
public class AssociationApplication {

	public static void main(String[] args) {
		SpringApplication.run(AssociationApplication.class, args);
	}

}
