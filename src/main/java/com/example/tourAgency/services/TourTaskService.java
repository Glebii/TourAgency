package com.example.tourAgency.services;

import com.example.tourAgency.models.Status;
import com.example.tourAgency.models.TourTasks;
import com.example.tourAgency.repositories.StatusRepository;
import com.example.tourAgency.repositories.TourTaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TourTaskService {
    private final TourTaskRepository tourTaskRepository;
    private final StatusRepository statusRepository;
    public TourTaskService(TourTaskRepository tourTaskRepository, StatusRepository statusRepository) {
        this.tourTaskRepository = tourTaskRepository;
        this.statusRepository = statusRepository;
    }

    public void createTask(TourTasks tourTasks){
        tourTaskRepository.save(tourTasks);
    }
    public List<TourTasks> tourTasksList(){
        return tourTaskRepository.findAll();
    }
    public List<Status> statusList(){
        return statusRepository.findAll();
    }
    public void deleteTask(Long id) {
        tourTaskRepository.deleteById(id);
    }
    public TourTasks find(Long id){
        return tourTaskRepository.findById(id).get();
    }
}
