package xyz.calebwarner.embeddeddata.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import xyz.calebwarner.embeddeddata.data.BookRepository;
import xyz.calebwarner.embeddeddata.model.Book;
import xyz.calebwarner.embeddeddata.model.Genre;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private static final Logger LOG = LoggerFactory.getLogger(BookService.class);

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> saveDefaultBooks() {
        List<Book> books = new ArrayList<>();
        books.add(new Book("Book A", "George Nelson", BigDecimal.valueOf(9.99), LocalDate.of(2023, 8, 31), Genre.FICTION));
        books.add(new Book("Book B", "Bryan Cooper", BigDecimal.valueOf(19.99), LocalDate.of(2023, 7, 31), Genre.FANTASY));
        books.add(new Book("Book C", "Cody Kenny", BigDecimal.valueOf(29.99), LocalDate.of(2023, 6, 10), Genre.NONFICTION));
        books.add(new Book("Book D", "Daniel Fisher", BigDecimal.valueOf(39.99), LocalDate.of(2023, 5, 5), Genre.THRILLER));

        bookRepository.saveAll(books);

        return books;
    }

    public List<Book> testBookClass() {
        List<Book> books = saveDefaultBooks();

        LOG.info("--------------------------------------------");
        LOG.info("findAll():");
        for (Book book : bookRepository.findAll()) {
            LOG.info("{}", book);
        }
        LOG.info("");

        Optional<Book> optionalBook = bookRepository.findById(1L);
        optionalBook.ifPresent(obj -> {
            LOG.info("--------------------------------------------");
            LOG.info("findById(1L):");
            LOG.info(obj.toString());
            LOG.info("");
        });

        LOG.info("--------------------------------------------");
        LOG.info("findByTitle('Book B')");
        bookRepository.findByTitle("Book B").forEach(b -> {
            LOG.info(b.toString());
            LOG.info("");
        });

        LOG.info("--------------------------------------------");
        Book bookE = new Book("Book E", "Evelyn Tucker", BigDecimal.valueOf(39.99), LocalDate.of(2023, 10, 5), Genre.SCIENCE_FICTION);
        books.add(bookE);
        bookRepository.save(bookE);
        LOG.info("save(Book E):");
        for (Book book : bookRepository.findAll()) {
            LOG.info("{}", book);
        }
        LOG.info("");

        LOG.info("--------------------------------------------");
        List<Book> booksAfterSept = bookRepository.findByPublishedDateAfter(LocalDate.of(2023, 9, 30));
        LOG.info("Books after September:");
        for (Book book : booksAfterSept) {
            LOG.info("{}", book);
        }
        LOG.info("");

        LOG.info("--------------------------------------------");
        LOG.info("findByGenre('Fiction')");
        bookRepository.findByGenre(Genre.FICTION).forEach(b -> {
            LOG.info(b.toString());
            LOG.info("");
        });

        return books;
    }
}
