package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;


import javax.persistence.*;
import java.util.Date;

@Entity @Data
public class Livre {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(length = 50,nullable = false)
    private String titre;
    @Column(nullable = false,updatable = false) @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String maison;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date dsortie;
    @Column(nullable = false) @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private  String auteur;
    @Column(nullable = false)
    private int npages;
    @Column(nullable = false,unique = true,updatable = false) @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private long isbn ;
    @Column(nullable = false)
    private boolean disponible;
    @Temporal(TemporalType.TIMESTAMP) @CreationTimestamp
    @Column(nullable = false) @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Date dderniereConsultation;

}
