package com.example.tourAgency.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

// Задания для составителя туров
@Entity
@Data
@Table(name = "tour_tasks")
@AllArgsConstructor
@NoArgsConstructor
public class TourTasks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String definition;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "executing_time")
    private Date executingTime;
    @ManyToOne
    @JoinColumn(name="status_id",referencedColumnName = "id")
    private Status status;
}
