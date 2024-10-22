package xyz.calebwarner.embeddeddata.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

import java.util.List;

@Entity
public class Musician {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String band;
    private String instrument;
    @ManyToOne
    @JoinColumn(name = "performance_id")
    private Performance performance;
    @ManyToMany
    @JoinTable(
            name = "musician_book",
            joinColumns = @JoinColumn(name = "musician_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id")
    )
    private List<Book> books;


    private Musician(Builder builder) {
        this.name = builder.name;
        this.band = builder.band;
        this.instrument = builder.instrument;
        this.performance = builder.performance;
        this.books = builder.books;
    }

    public Musician() {
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getName() {
        return name;
    }

    public String getBand() {
        return band;
    }

    public String getInstrument() {
        return instrument;
    }

    public Performance getPerformance() {
        return performance;
    }

    public List<Book> getBooks() {
        return books;
    }

    public static class Builder {
        private String name;
        private String band;
        private String instrument;
        private Performance performance;
        private List<Book> books;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder band(String band) {
            this.band = band;
            return this;
        }

        public Builder instrument(String instrument) {
            this.instrument = instrument;
            return this;
        }

        public Builder performance(Performance performance) {
            this.performance = performance;
            return this;
        }

        public Builder books(List<Book> books) {
            this.books = books;
            return this;
        }

        public Musician build() {
            return new Musician(this);
        }
    }

    @Override
    public String toString() {
        return name + ", " + band + ", " + instrument;
    }
}
