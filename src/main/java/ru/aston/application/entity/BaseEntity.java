package ru.aston.application.entity;


import lombok.Data;

import javax.persistence.*;

@Data
@MappedSuperclass
abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long id;
}
