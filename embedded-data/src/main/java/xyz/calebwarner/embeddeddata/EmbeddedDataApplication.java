package xyz.calebwarner.embeddeddata;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import xyz.calebwarner.embeddeddata.data.BookRepository;
import xyz.calebwarner.embeddeddata.data.MusicianRepository;
import xyz.calebwarner.embeddeddata.service.BookService;
import xyz.calebwarner.embeddeddata.service.MusicianService;

@SpringBootApplication
public class EmbeddedDataApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmbeddedDataApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(BookRepository bookRepository, MusicianRepository musicianRepository) {
        return args -> {
            BookService bookService = new BookService(bookRepository);
            bookService.testBookClass();

            MusicianService musicianService = new MusicianService(musicianRepository);
            musicianService.testMusicianClass();
        };
    }
}
