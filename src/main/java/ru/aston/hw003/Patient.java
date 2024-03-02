package ru.aston.hw003;

public class Patient {

    private Long id;
    private Long doctorId;
    private String name;

    public Patient(Long id, Long doctorId, String name) {
        this.id = id;
        this.doctorId = doctorId;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


