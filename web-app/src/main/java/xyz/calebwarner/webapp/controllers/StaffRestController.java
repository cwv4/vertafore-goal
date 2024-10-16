package xyz.calebwarner.vertafore_goal.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.calebwarner.vertafore_goal.models.Staff;
import xyz.calebwarner.vertafore_goal.services.StaffService;

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
