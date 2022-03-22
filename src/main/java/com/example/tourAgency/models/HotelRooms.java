package com.example.tourAgency.models;


import com.example.tourAgency.enums.HotelRoomCategory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="hotel_rooms")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HotelRooms {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "check_in")
    private Date checkIn;
    @Column(name = "room_number")
    private int roomNumber;
    @Column(name = "check_out")
    private Date check_out;
    @Enumerated(EnumType.STRING)
    private HotelRoomCategory hotelRoomCategory;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;
    @ManyToMany
    @JoinTable(name = "hotelRooms_travelPackage",
    joinColumns = @JoinColumn(name = "hotel_room_id"),
    inverseJoinColumns = @JoinColumn(name = "travel_package_id"))
    private List<TravelPackage> travelPackageList;
}
