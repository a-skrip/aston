package ru.aston.hw003.entity;

import lombok.Data;



import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "doctor", schema = "public")
@Data

public class Doctor {
//    @OneToMany(mappedBy = "doctor")
//    private List<Patient> patient;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String name;
    @Column
    private String specialization;
    @Column(name = "phone_number")
    private String phoneNumber;

    public Doctor() {
    }
    public Doctor(String name, String specialization, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.specialization = specialization;
        this.phoneNumber = phoneNumber;
    }




    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", specialization='" + specialization + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
