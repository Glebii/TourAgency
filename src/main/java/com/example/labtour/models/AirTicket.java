package com.example.labtour.models;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "air_ticket")
public class AirTicket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column(name = "place")
    private String place;
    @Column(name = "flight_code")
    private int flightCode;
    @Column(name = "airline")
    private String airline;
    @Column(name = "class_of_service")
    private String classOfService;
}
