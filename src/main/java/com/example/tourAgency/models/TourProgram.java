package com.example.tourAgency.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "tour_program")
@AllArgsConstructor
@NoArgsConstructor
public class TourProgram {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int  programmNumber;
    private String description;
}
