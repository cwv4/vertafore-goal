package xyz.calebwarner.clr.service;

import org.slf4j.Logger; // BTW: slf4j stands for Simple Logging Facade for Java
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import xyz.calebwarner.clr.models.Room;
import xyz.calebwarner.clr.models.Staff;

import java.util.List;
import java.util.Objects;

public class ClrService {

    private static final Logger LOG = LoggerFactory.getLogger(ClrService.class);

    public void getRooms(RestTemplate restTemplate) {
        LOG.info("");
        LOG.info("Begin fetching Rooms");

        ResponseEntity<List<Room>> rooms = restTemplate.exchange(
                "http://localhost:8000/api/rooms",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Room>>() {}
        );

        for (Room room : Objects.requireNonNull(rooms.getBody())) {
            LOG.info("{}", room);
        }

        LOG.info("End fetching Rooms");
        LOG.info("");
    }

    public void getStaff(RestTemplate restTemplate) {
        LOG.info("");
        LOG.info("Begin fetching Staff");

        ResponseEntity<List<Staff>> staff = restTemplate.exchange(
                "http://localhost:8000/api/staff",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {}
        );

        for (Staff employee : Objects.requireNonNull(staff.getBody())) {
            LOG.info("{}", employee);
        }

        LOG.info("End fetching Staff");
        LOG.info("");
    }

    public void getFizzBuzz(RestTemplate restTemplate) {
        LOG.info("");
        LOG.info("Begin fetching FizzBuzz");

        ResponseEntity<List<String>> fizzBuzzValues = restTemplate.exchange(
                "http://localhost:8010/api/fizzbuzz",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<String>>() {
                }
        );

        for (String fizzBuzzValue : Objects.requireNonNull(fizzBuzzValues.getBody())) {
            LOG.info(fizzBuzzValue);
        }

        LOG.info("End fetching FizzBuzz");
        LOG.info("");
    }
}
