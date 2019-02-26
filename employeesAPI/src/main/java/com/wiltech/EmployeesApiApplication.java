package com.wiltech;

import com.wiltech.employees.model.Employee;
import com.wiltech.employees.repository.EmployeeRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class EmployeesApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeesApiApplication.class, args);
	}

	/**
	 * Adding  ApplicationRunner bean to the Application Boot to run set up on start up.
	 *
	 * @param repository the repository
	 * @return application runner
	 */
	@Bean
	ApplicationRunner init(EmployeeRepository repository) {
		//Populate a list of health checks on
		return args -> {

				repository.save(Employee.builder()
						.firstName("Employee")
						.lastName("Employee")
						.emailId("employee@wiltech.com")
						.build());

				repository.save(Employee.builder()
						.firstName("Manager")
						.lastName("Manager")
						.emailId("manager@wiltech.com")
						.build());

			repository.findAll().forEach(System.out::println);
		};
	}

}
