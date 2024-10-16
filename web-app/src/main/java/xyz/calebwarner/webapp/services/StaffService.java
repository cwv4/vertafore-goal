package xyz.calebwarner.vertafore_goal.services;

import org.springframework.stereotype.Service;
import xyz.calebwarner.vertafore_goal.models.Position;
import xyz.calebwarner.vertafore_goal.models.Staff;

import java.util.ArrayList;
import java.util.List;

@Service
public class StaffService {

    private static final List<Staff> staff = new ArrayList<>();

    static {
        staff.add(new Staff("1", "Roy", "Adams", Position.HOUSEKEEPING));
        staff.add(new Staff("2", "Martin", "Alexandar", Position.SECURITY));
        staff.add(new Staff("3", "Roger", "Alvarez", Position.FRONT_DESK));
        staff.add(new Staff("4", "Betty", "Anderson", Position.HOUSEKEEPING));
        staff.add(new Staff("5", "Christopher", "Armstrong", Position.HOUSEKEEPING));
        staff.add(new Staff("6", "David", "Bell", Position.CONCIERGE));
        staff.add(new Staff("7", "Paula", "Berry", Position.SECURITY));
        staff.add(new Staff("8", "Dennis", "Bishop", Position.HOUSEKEEPING));
        staff.add(new Staff("9", "Harold", "Black", Position.FRONT_DESK));
        staff.add(new Staff("10", "Jerry", "Bowman", Position.HOUSEKEEPING));
        staff.add(new Staff("11", "Keith", "Bradley", Position.FRONT_DESK));
        staff.add(new Staff("12", "Samuel", "Brooks", Position.HOUSEKEEPING));
        staff.add(new Staff("13", "Donald", "Bryant", Position.FRONT_DESK));
        staff.add(new Staff("14", "Tammy", "Burke", Position.SECURITY));
    }

    public List<Staff> getAllStaff() {
        return staff;
    }
}
