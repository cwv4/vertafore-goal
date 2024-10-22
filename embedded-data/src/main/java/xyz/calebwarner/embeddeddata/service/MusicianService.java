package xyz.calebwarner.embeddeddata.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import xyz.calebwarner.embeddeddata.data.MusicianRepository;
import xyz.calebwarner.embeddeddata.model.Book;
import xyz.calebwarner.embeddeddata.model.Musician;
import xyz.calebwarner.embeddeddata.model.Performance;

import java.util.ArrayList;
import java.util.List;

public class MusicianService {

    private static final Logger LOG = LoggerFactory.getLogger(MusicianService.class);

    private final MusicianRepository musicianRepository;

    public MusicianService(MusicianRepository musicianRepository) {
        this.musicianRepository = musicianRepository;
    }


    public void saveDefaultMusicians(List<Performance> performanceList, List<Book> bookList) {
        List<Musician> musicianList = new ArrayList<>();

        musicianList.add(Musician.builder().name("Kurt Perry").band("Hailey Concert Band").instrument("Clarinet").performance(performanceList.get(0)).books(List.of(bookList.get(0), bookList.get(1))).build());
        musicianList.add(Musician.builder().name("Alan Ankle").band("Hailey Concert Band").instrument("Saxophone").performance(performanceList.get(0)).books(List.of(bookList.get(0))).build());
        musicianList.add(Musician.builder().name("Sandra Jefferson").band("Hailey Concert Band").performance(performanceList.get(0)).instrument("French Horn").books(List.of(bookList.get(2), bookList.get(3))).build());
        musicianList.add(Musician.builder().name("Lewis Patrick").band("Hailey Concert Band").performance(performanceList.get(0)).instrument("Bass Drum").books(List.of(bookList.get(0), bookList.get(4))).build());
        musicianList.add(Musician.builder().name("Shirley Freeman").band("Elton John Memorial Band").performance(performanceList.get(1)).instrument("Trumpet").books(List.of(bookList.get(4))).build());
        musicianList.add(Musician.builder().name("Chris Hamilton").band("Elton John Memorial Band").performance(performanceList.get(1)).instrument("Trombone").books(List.of(bookList.get(0), bookList.get(1), bookList.get(2), bookList.get(3), bookList.get(4))).build());
        musicianList.add(Musician.builder().name("James Kennedy").band("Six Toned Saxes").performance(performanceList.get(2)).instrument("Saxophone").books(List.of(bookList.get(0), bookList.get(3))).build());
        musicianList.add(Musician.builder().name("Karen Boyd").band("Six Toned Saxes").performance(performanceList.get(2)).instrument("Saxophone").books(List.of(bookList.get(1))).build());
        musicianList.add(Musician.builder().name("Coby Flynn").band("University Band").performance(performanceList.get(3)).instrument("Trumpet").books(List.of(bookList.get(0), bookList.get(1), bookList.get(2))).build());
        musicianList.add(Musician.builder().name("Emmy Reed").band("University Band").performance(performanceList.get(3)).instrument("Clarinet").books(List.of(bookList.get(2), bookList.get(4))).build());
        musicianList.add(Musician.builder().name("Miles Simpson").band("University Band").performance(performanceList.get(3)).instrument("Cymbals").books(List.of(bookList.get(3))).build());
        musicianList.add(Musician.builder().name("Daisy Campbell").band("Green Women Group").performance(performanceList.get(4)).instrument("Snare Drum").books(List.of(bookList.get(1), bookList.get(3), bookList.get(4))).build());
        musicianList.add(Musician.builder().name("Belle Pearce").band("Green Women Group").performance(performanceList.get(4)).instrument("Bass Drum").books(List.of(bookList.get(1), bookList.get(3))).build());
        musicianList.add(Musician.builder().name("Esmee Hughes").band("Green Women Group").performance(performanceList.get(4)).instrument("Snare Drum").books(List.of(bookList.get(2))).build());

        musicianRepository.saveAll(musicianList);
    }

    public void testMusicianClass(List<Performance> performanceList, List<Book> bookList) {
        saveDefaultMusicians(performanceList, bookList);

        LOG.info("--------------------------------------------");
        LOG.info("findAll():");
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
