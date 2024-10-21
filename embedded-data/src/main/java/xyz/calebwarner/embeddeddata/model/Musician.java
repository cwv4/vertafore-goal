package xyz.calebwarner.embeddeddata.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Musician {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String band;
    private String instrument;


    private Musician(Builder builder) {
        this.name = builder.name;
        this.band = builder.band;
        this.instrument = builder.instrument;
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

    public static class Builder {
        private String name;
        private String band;
        private String instrument;

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

        public Musician build() {
            return new Musician(this);
        }
    }

    @Override
    public String toString() {
        return name + ", " + band + ", " + instrument;
    }
}
