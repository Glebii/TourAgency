package com.example.labtour.models;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "air_ticket_for_tour")
@AllArgsConstructor
@NoArgsConstructor
public class AirTicketsForTour {
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

    private int passport_number;
    private String name;
    private int tourNumber;
    private Date registrationDate;
}
