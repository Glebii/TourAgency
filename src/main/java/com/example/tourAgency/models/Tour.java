package com.example.tourAgency.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "tour")
@AllArgsConstructor
@NoArgsConstructor
public class Tour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "tour_number")
    private int tourNumber;
    @Column(name = "start_date")
    private Date startDate;
    @Column(name = "end_date")
    private Date endDate;
    @Column(name = "tour_name")
    private String tour_name;
    private String status;
    private String description;
    @ManyToOne
    @JoinColumn(name="type_id",referencedColumnName = "id")
    private TourType tourType;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "country_id")
    private Country country;
    @OneToMany(mappedBy = "tour", fetch = FetchType.LAZY)
    private List<Events> eventsList;
    @OneToOne(mappedBy = "tour")
    private Order orders;
    @OneToMany(mappedBy = "tour")
    private List<TourFlights> tourFlightsList;
    @OneToMany(mappedBy = "tour")
    private List<Hotel> hotelList;
    @OneToMany(mappedBy = "tour")
    private List<Contract> contractList;
}
