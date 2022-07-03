package com.openbootcamp.laptops.repositories;

import com.openbootcamp.laptops.entities.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LaptopRepository extends JpaRepository<Laptop, Long> {
}
