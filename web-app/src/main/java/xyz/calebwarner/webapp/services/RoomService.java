package xyz.calebwarner.webapp.services;

import org.springframework.stereotype.Service;
import xyz.calebwarner.webapp.models.Room;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoomService {

    private static List<Room> rooms = new ArrayList<>();

    static {
        for (int i = 1; i <= 10; i++) {
            rooms.add(new Room(i, "Room " + i, "R" + i, "Q"));
        }
    }

    public List<Room> getAllRooms() {
        return rooms;
    }
}
