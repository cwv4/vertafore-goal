package xyz.calebwarner.webapp.models;

public class Staff {
    private String id;
    private String firstName;
    private String lastName;
    private xyz.calebwarner.webapp.models.Position position;

    public Staff() {
    }

    public Staff(String id, String firstName, String lastName, xyz.calebwarner.webapp.models.Position position) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public xyz.calebwarner.webapp.models.Position getPosition() {
        return position;
    }

    public void setPosition(xyz.calebwarner.webapp.models.Position position) {
        this.position = position;
    }
}
