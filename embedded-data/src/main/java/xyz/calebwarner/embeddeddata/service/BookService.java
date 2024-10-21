package xyz.calebwarner.embeddeddata.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import xyz.calebwarner.embeddeddata.data.BookRepository;
import xyz.calebwarner.embeddeddata.model.Book;

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

    public void saveDefaultBooks() {
        List<Book> books = new ArrayList<>();
        books.add(new Book("Book A", "George Nelson", BigDecimal.valueOf(9.99), LocalDate.of(2023, 8, 31)));
        books.add(new Book("Book B", "Bryan Cooper", BigDecimal.valueOf(19.99), LocalDate.of(2023, 7, 31)));
        books.add(new Book("Book C", "Cody Kenny", BigDecimal.valueOf(29.99), LocalDate.of(2023, 6, 10)));
        books.add(new Book("Book D", "Daniel Fisher", BigDecimal.valueOf(39.99), LocalDate.of(2023, 5, 5)));

        bookRepository.saveAll(books);
    }

    public void testBookClass() {
        saveDefaultBooks();

        LOG.info("--------------------------------------------");
        LOG.info("findAll(), expecting 4 books:");
        for (Book book : bookRepository.findAll()) {
            LOG.info("{}", book);
        }
        LOG.info("");

        Optional<Book> optionalBook = bookRepository.findById(1L);
        optionalBook.ifPresent(obj -> {
            LOG.info("--------------------------------------------");
            LOG.info("Book found with findById(1L):");
            LOG.info(obj.toString());
            LOG.info("");
        });

        LOG.info("--------------------------------------------");
        LOG.info("Book found with findByTitle('Book B')");
        bookRepository.findByTitle("Book B").forEach(b -> {
            LOG.info(b.toString());
            LOG.info("");
        });

        LOG.info("--------------------------------------------");
        bookRepository.deleteById(2L);
        LOG.info("Book delete where ID = 2L");
        for (Book book : bookRepository.findAll()) {
            LOG.info("{}", book);
        }
        LOG.info("");

        LOG.info("--------------------------------------------");
        bookRepository.save(new Book("Book E", "Evelyn Tucker", BigDecimal.valueOf(39.99), LocalDate.of(2023, 10, 5)));
        LOG.info("Added book with title: 'Book E'");
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
    }
}
