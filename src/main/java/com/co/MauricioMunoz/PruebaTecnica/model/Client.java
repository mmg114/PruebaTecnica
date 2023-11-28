package com.co.MauricioMunoz.PruebaTecnica.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Getter
@Setter
@Builder
@AllArgsConstructor
@Entity
@Table(name="CLIENT")
public class Client {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "ID_CLIENT", columnDefinition = "VARCHAR(255)")
    private UUID id;
    @Column(name = "EMAIL", length = 50, nullable = false)
    private String email;
    @Column(name = "NAME", length = 100, nullable = false)
    private String name;
    @Column(name = "PASSWORD", length = 50, nullable = false)
    private String password;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "client")
    private List<Phone> phones= new ArrayList<>();

    //TODO fecha de creacion modificacion ultimo ingreso generacion de jwt isactivo

}
