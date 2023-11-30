package com.co.MauricioMunoz.PruebaTecnica.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
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
    @NotBlank
    @NotNull
    @NotEmpty
    @Column(name = "NAME", length = 100, nullable = false)
    private String name;
    @Column(name = "PASSWORD", length = 50, nullable = false)
    private String password;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "client")
    private List<Phone> phones= new ArrayList<>();


    @Column(name = "CREATION_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;

    @Column(name = "MODIFICATION_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificationDate;

    @Column(name = "STATUS")
    private boolean active;

    @Column(name = "TOKEN")
    private String token;

    @Column(name = "LAST_LOGIN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastLogin;




}
