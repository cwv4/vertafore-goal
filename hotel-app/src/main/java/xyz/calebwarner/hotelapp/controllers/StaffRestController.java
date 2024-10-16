package xyz.calebwarner.hotelapp.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.calebwarner.hotelapp.models.Staff;
import xyz.calebwarner.hotelapp.services.StaffService;

import java.util.List;

@RestController
@RequestMapping("/api/staff")
public class StaffRestController {
    private final StaffService staffService;

    public StaffRestController(StaffService staffService) {
        this.staffService = staffService;
    }

    @GetMapping
    public List<Staff> getAllRooms() {
        return staffService.getAllStaff();
    }
}
