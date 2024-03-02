package ru.aston.hw003;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {

    private Long id;
    private String name;
    private String postCode;
    private String profession;

    @Override
    public String toString() {
        return "id =" + id + ", name='" + name + '\'' + ", postCode=" + postCode + ", profession='" + profession + '\'' +
                '}';
    }
}
