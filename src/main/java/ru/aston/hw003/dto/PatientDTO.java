package ru.aston.hw003.dto;

public class PatientDTO {

    private String name;

    public PatientDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
