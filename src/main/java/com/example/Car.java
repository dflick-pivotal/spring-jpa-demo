package com.example;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "car")
public class Car {
	
	protected Car() {}
	public Car(String type, String color) {
        this.type = type;
        this.color = color;
    }
	
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String type;

    private String color;
    
    @Override
    public String toString() {
        return String.format(
                "Car[id=%d, type='%s', color='%s']",
                id, type, color);
    }

}
