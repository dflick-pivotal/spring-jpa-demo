package com.example;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {
	
	protected Customer() {}
	public Customer(String name, List<Car> cars) {
        this.name = name;
        this.cars = cars;
    }
	
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    String name;
    
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    List<Car> cars;
    
    @Override
    public String toString() {
        return String.format(
                "Customer[id=%d, name='%s']",
                id, name);
    }

}
