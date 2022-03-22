package com.example.tourAgency.repositories;

import com.example.tourAgency.models.TourTasks;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TourTaskRepository extends JpaRepository<TourTasks, Long> {
}
