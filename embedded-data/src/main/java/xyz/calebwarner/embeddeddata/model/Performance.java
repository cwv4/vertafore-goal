package xyz.calebwarner.embeddeddata.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Performance {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String location;
    private LocalDate date;
    private String description;


    private Performance(Builder builder) {
        this.title = builder.title;
        this.location = builder.location;
        this.date = builder.date;
        this.description = builder.description;
    }

    public Performance() {
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getTitle() {
        return title;
    }

    public String getLocation() {
        return location;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getDate() {
        return date;
    }

    public static class Builder {
        private String title;
        private String location;
        private String description;
        private LocalDate date;

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder location(String location) {
            this.location = location;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder date(LocalDate date) {
            this.date = date;
            return this;
        }

        public Performance build() {
            return new Performance(this);
        }
    }

    @Override
    public String toString() {
        return title + ", " + location + ", " + description;
    }
}
