package com.example.tourAgency.models;

import javax.persistence.*;

@Entity
@Table(name = "tour_type")
public class TourType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String type;
    public Long getId() {
        return id;
    }
    public String getType() {
        return type;
    }
    public TourType(Long id, String type) {
        this.id = id;
        this.type = type;
    }
    public TourType(){}
}
