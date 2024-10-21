package xyz.calebwarner.embeddeddata.data;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.calebwarner.embeddeddata.model.Musician;

import java.util.List;

public interface MusicianRepository extends JpaRepository<Musician, Long> {

    List<Musician> findByInstrument(String instrument);
}
