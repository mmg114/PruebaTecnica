package com.co.MauricioMunoz.PruebaTecnica.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@Entity
@Table(name="PHONE")
public class Phone {


    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "ID_PHONE", columnDefinition = "VARCHAR(255)")
    private UUID id;

    @Column(name = "NUMBER", length = 20, nullable = false)
    private String number;

    @Column(name = "CITY_CODE", length = 20, nullable = false)
    private String cityCode;

    @Column(name = "COUNTRY_CODE", length = 20, nullable = false)
    private String countryCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_CLIENT")
    private Client client;
}
