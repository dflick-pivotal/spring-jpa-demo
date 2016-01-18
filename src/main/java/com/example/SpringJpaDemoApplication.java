package com.example;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringJpaDemoApplication {

	private static final Logger log = LoggerFactory.getLogger(SpringJpaDemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaDemoApplication.class);
	}
	
	@Bean
	public CommandLineRunner demo(CustomerRepository repository) {
		return (args) -> {
			
			Car car = new Car("type1", "white");
			List<Car> cars = new ArrayList<Car>();
			cars.add(car);			
			repository.save(new Customer("Dieter", cars));
			
			car = new Car("type1", "red");
			cars.set(0, car);
			repository.save(new Customer("Juri", cars));
			
			car = new Car("type1", "blue");
			cars.set(0, car);
			repository.save(new Customer("Oliver", cars));

			car = new Car("type2", "black");
			cars.set(0, car);
			repository.save(new Customer("Eric", cars));

			car = new Car("type2", "red");
			cars.set(0, car);
			repository.save(new Customer("TSS", cars));

			// fetch all customers
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			for (Customer customer1 : repository.findAll()) {
				log.info(customer1.toString());
				log.info(customer1.cars.get(0).toString());
			}
            log.info("");

			// fetch an individual customer by ID
			Customer customer2 = repository.findOne(1L);
			log.info("Customer found with findOne(1L):");
			log.info("--------------------------------");
			log.info(customer2.toString());
			log.info(customer2.cars.get(0).toString());
            log.info("");

			// fetch customers with car type and car color
			log.info("Customer found with findCustomersWithCar('type1', 'red'):");
			log.info("--------------------------------------------");
			for (Customer customer3 : repository.findCustomersWithCar("type1", "red")) {
				log.info(customer3.toString());
				log.info(customer3.cars.get(0).toString());
			}
            log.info("");
		};
	}

}
