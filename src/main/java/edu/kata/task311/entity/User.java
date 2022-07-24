package edu.kata.task311.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.*;

@Table
@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "last_name")
    private String lastName;

    @Column
    private String name;

    @Column(name = "middle_name")
    private String middleName;




}
