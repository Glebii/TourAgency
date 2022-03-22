package com.example.tourAgency.services;

import com.example.tourAgency.models.Staff;
import com.example.tourAgency.repositories.StaffRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffService {
    private final StaffRepository staffRepository;
    public StaffService(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }
    public void creatStaff(Staff staff) {
        staffRepository.save(staff);}
    public List<Staff> staffList(){
        return staffRepository.findAll();
    }
    public Staff findById(Long id) {
        return staffRepository.findById(id).get();
    }
    public void deletePost(Long id) {
        staffRepository.deleteById(id);
    }
}
