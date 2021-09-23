package martinmazas.java.ATM.model;

import java.util.Random;

public class User {
    private String name, pin, id;
    private int  account;
    private final int minRandom = 100;
    private final int maxRandom = 100000;

    public User(String id, String name, String pin) {
        this.id = id;
        this.name = name;
        Random rand = new Random();
        this.account = (rand.nextInt(maxRandom-minRandom) + minRandom);
        this.pin = pin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", pin='" + pin + '\'' +
                ", id='" + id + '\'' +
                ", account=" + account +
                ", minRandom=" + minRandom +
                ", maxRandom=" + maxRandom +
                '}';
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAccount() {
        return account;
    }

    public void setAccount(int account) {
        this.account = account;
    }
}
