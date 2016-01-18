package com.example;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    @Query("select c from Customer c join c.cars car " +
           "where car.type = ?1 and car.color = ?2")
List<Customer> findCustomersWithCar(String type, String color);

}
