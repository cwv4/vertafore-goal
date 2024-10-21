package xyz.calebwarner.embeddeddata.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import xyz.calebwarner.embeddeddata.data.MusicianRepository;
import xyz.calebwarner.embeddeddata.model.Musician;

import java.util.ArrayList;
import java.util.List;

public class MusicianService {

    private static final Logger LOG = LoggerFactory.getLogger(MusicianService.class);

    private final MusicianRepository musicianRepository;

    public MusicianService(MusicianRepository musicianRepository) {
        this.musicianRepository = musicianRepository;
    }


    public void saveDefaultMusicians() {
        List<Musician> musicianList = new ArrayList<>();

        musicianList.add(Musician.builder().name("Kurt Perry").band("Hailey Concert Band").instrument("Clarinet").build());
        musicianList.add(Musician.builder().name("Alan Ankle").band("Hailey Concert Band").instrument("Saxophone").build());
        musicianList.add(Musician.builder().name("Sandra Jefferson").band("Hailey Concert Band").instrument("French Horn").build());
        musicianList.add(Musician.builder().name("Lewis Patrick").band("Hailey Concert Band").instrument("Bass Drum").build());
        musicianList.add(Musician.builder().name("Shirley Freeman").band("Elton John Memorial Band").instrument("Trumpet").build());
        musicianList.add(Musician.builder().name("Chris Hamilton").band("Elton John Memorial Band").instrument("Trombone").build());
        musicianList.add(Musician.builder().name("James Kennedy").band("Six Toned Saxes").instrument("Saxophone").build());
        musicianList.add(Musician.builder().name("Karen Boyd").band("Six Toned Saxes").instrument("Saxophone").build());
        musicianList.add(Musician.builder().name("Coby Flynn").band("University Band").instrument("Trumpet").build());
        musicianList.add(Musician.builder().name("Emmy Reed").band("University Band").instrument("Clarinet").build());
        musicianList.add(Musician.builder().name("Miles Simpson").band("University Band").instrument("Cymbals").build());
        musicianList.add(Musician.builder().name("Daisy Campbell").band("Green Women Group").instrument("Snare Drum").build());
        musicianList.add(Musician.builder().name("Belle Pearce").band("Green Women Group").instrument("Bass Drum").build());
        musicianList.add(Musician.builder().name("Esmee Hughes").band("Green Women Group").instrument("Snare Drum").build());

        musicianRepository.saveAll(musicianList);
    }

    public void testMusicianClass() {
        saveDefaultMusicians();

        LOG.info("--------------------------------------------");
        LOG.info("findAll(), expecting 4 books:");
        for (Musician musician : musicianRepository.findAll()) {
            LOG.info("{}", musician);
        }
        LOG.info("");

        LOG.info("--------------------------------------------");
        LOG.info("findByInstrument('Saxophone'):");
        for (Musician musician : musicianRepository.findByInstrument("Saxophone")) {
            LOG.info("{}", musician);
        }
        LOG.info("");

        LOG.info("--------------------------------------------");
        LOG.info("deleteById(5L):");
        musicianRepository.deleteById(5L);
        for (Musician musician : musicianRepository.findAll()) {
            LOG.info("{}", musician);
        }
        LOG.info("");
    }
}
