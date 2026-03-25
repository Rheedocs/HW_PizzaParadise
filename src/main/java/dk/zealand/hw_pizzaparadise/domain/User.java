package dk.zealand.hw_pizzaparadise.domain;

public class User {

    private int id;
    private String name;
    private String email;
    private String address;
    private int bonusPoints;

    public User(int id, String name, String email, String address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.bonusPoints = 0;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getAddress() { return address; }
    public int getBonusPoints() { return bonusPoints; }

    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
    public void setAddress(String address) { this.address = address; }
    public void setBonusPoints(int bonusPoints) { this.bonusPoints = bonusPoints; }

    public void addBonusPoints(int points) {
        this.bonusPoints += points;
    }
}