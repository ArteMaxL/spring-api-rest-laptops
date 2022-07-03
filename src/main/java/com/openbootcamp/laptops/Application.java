package com.openbootcamp.laptops;

import com.openbootcamp.laptops.entities.Laptop;
import com.openbootcamp.laptops.repositories.LaptopRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Application.class, args);
		LaptopRepository repository = context.getBean(LaptopRepository.class);

		//Se crearon 3 objetos Laptop para realizar las pruebas

		Laptop laptop1 = new Laptop(null, "Apple", "M1", 619.20, LocalDate.of(2020, 1, 12),true);
		Laptop laptop2 = new Laptop(null, "Lenovo", "ProMax", 431.33, LocalDate.of(2021, 5, 22),true);
		Laptop laptop3 = new Laptop(null, "HP", "MaxPower", 330.00, LocalDate.of(2019, 9, 17), false);

		repository.save(laptop1);
		repository.save(laptop2);
		repository.save(laptop3);
	}

}
