package com.tarabadi;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

/**
 * Created by Matt on 01/05/2017.
 */
@Data
@Entity
public class Employee {

    private @Id @GeneratedValue Long id;


    private String firstShift;
    private String secondShift;
    private String thirdShift;

    private String day;

    private @Version @JsonIgnore Long version;

    private @ManyToOne Manager manager;

    private Employee() {}

    public Employee(String day, String first, String second, String third, Manager manager) {
        this.day = day;

        this.firstShift = first;
        this.secondShift = second;
        this.thirdShift = third;

        this.manager = manager;
    }
}
