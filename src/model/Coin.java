package model;

public class Coin {
    private int value;
    private String country;

    public Coin(int value, String country) {
        this.value = value;
        this.country = country;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
