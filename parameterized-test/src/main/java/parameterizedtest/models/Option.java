package parameterizedtest.models;

public enum Option {
    ASCENDING, DESCENDING, RANDOM, ALTERNATING;

    @Override
    public String toString() {
        return switch (this) {
            case ASCENDING -> "Ascending";
            case DESCENDING -> "Descending";
            case RANDOM -> "Random";
            case ALTERNATING -> "Alternating";
        };
    }
}
