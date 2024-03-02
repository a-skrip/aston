package ru.aston.hw003.entity;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {

    private Long id;
    private String name;
    private String postCode;
    private String profession;


    }

