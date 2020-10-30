package ca.sheridancollege;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages={"ca.sheridancollege"})
public class H2andJdbcTemplateApplication {

	public static void main(String[] args) {
		SpringApplication.run(H2andJdbcTemplateApplication.class, args);
	}

}
