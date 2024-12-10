package xyz.calebwarner.embeddeddata.model;

public enum Genre {
    FICTION, NONFICTION, MYSTERY, FANTASY, BIOGRAPHY, THRILLER, SCIENCE_FICTION;

    @Override
    public String toString() {
        return switch (this) {
            case FICTION -> "Fiction";
            case NONFICTION -> "Nonfiction";
            case MYSTERY -> "Mystery";
            case FANTASY -> "Fantasy";
            case BIOGRAPHY -> "Biography";
            case THRILLER -> "Thriller";
            case SCIENCE_FICTION -> "Science Fiction";
        };
    }
}
