package com.openbootcamp.laptops.controllers;

import com.openbootcamp.laptops.entities.Laptop;
import com.openbootcamp.laptops.repositories.LaptopRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LaptopController {

    LaptopRepository laptopRepository;

    public LaptopController(LaptopRepository laptopRepository) {
        this.laptopRepository = laptopRepository;
    }

    @GetMapping("/api/laptops")
    public List<Laptop> findAll(){
        return laptopRepository.findAll();
    }

    @GetMapping("/api/laptops/{id}")
    public ResponseEntity<Laptop> findOneById(@PathVariable Long id){
        Optional<Laptop> laptopFinded = laptopRepository.findById(id);

        if(laptopFinded.isPresent()){
            return ResponseEntity.ok(laptopFinded.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/api/laptops")
    public ResponseEntity<Laptop> create(@RequestBody Laptop laptop){
        if(laptop.getId() != null){
            return ResponseEntity.badRequest().build();
        }
        Laptop laptopCreated = laptopRepository.save(laptop);
        return ResponseEntity.ok(laptopCreated);
    }

    @PutMapping("/api/laptops")
    public ResponseEntity<Laptop> update(@RequestBody Laptop laptop){
        if(laptop.getId() == null){
            return ResponseEntity.badRequest().build();
        }
        if(!laptopRepository.existsById(laptop.getId())){
            return ResponseEntity.notFound().build();
        }
        Laptop laptopSaved = laptopRepository.save(laptop);
        return ResponseEntity.ok(laptopSaved);
    }

    @DeleteMapping("/api/laptops/{id}")
    public ResponseEntity<Laptop> delete(@PathVariable Long id){
        if(!laptopRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        laptopRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("api/laptops/deleteall")
    public ResponseEntity<Laptop> deleteAll(){
        if(laptopRepository.count() > 0){
            laptopRepository.deleteAll();
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}