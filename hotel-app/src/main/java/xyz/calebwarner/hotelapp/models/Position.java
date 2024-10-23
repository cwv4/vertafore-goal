package xyz.calebwarner.hotelapp.models;

public enum Position {
    CONCIERGE, FRONT_DESK, HOUSEKEEPING, SECURITY;

    @Override
    public String toString() {
        return switch (this) {
            case CONCIERGE -> "Concierge";
            case HOUSEKEEPING -> "Housekeeping";
            case FRONT_DESK -> "Front Desk";
            case SECURITY -> "Security";
        };
    }
}
