package xyz.calebwarner.embeddeddata;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import xyz.calebwarner.embeddeddata.data.BookRepository;
import xyz.calebwarner.embeddeddata.data.MusicianRepository;
import xyz.calebwarner.embeddeddata.data.PerformanceRepository;
import xyz.calebwarner.embeddeddata.model.Book;
import xyz.calebwarner.embeddeddata.model.Performance;
import xyz.calebwarner.embeddeddata.service.BookService;
import xyz.calebwarner.embeddeddata.service.MusicianService;
import xyz.calebwarner.embeddeddata.service.PerformanceService;

import java.util.List;

@SpringBootApplication
public class EmbeddedDataApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmbeddedDataApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(BookRepository bookRepository, MusicianRepository musicianRepository, PerformanceRepository performanceRepository) {
        return args -> {
            BookService bookService = new BookService(bookRepository);
            List<Book> bookList = bookService.testBookClass();

            PerformanceService performanceService = new PerformanceService(performanceRepository);
            List<Performance> performanceList = performanceService.testPerformanceClass();

            MusicianService musicianService = new MusicianService(musicianRepository);
            musicianService.testMusicianClass(performanceList, bookList);


        };
    }
}
