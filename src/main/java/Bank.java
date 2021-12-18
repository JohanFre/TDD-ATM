public class Bank {

    // Bank variables.
    private String user;
    private int id, pin, pinCounter, currency;
    private boolean lockedCard;
    private static String bank;

    // Constructor for variables.
    public Bank(String user, int id, int pin, int pinCounter, int currency, boolean lockedCard) {
        this.user = user;
        this.id = id;
        this.pin = pin;
        this.pinCounter = pinCounter;
        this.currency = currency;
        this.lockedCard = lockedCard;
    }

    // Getters and setters for variables.

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public int getPinCounter() {
        return pinCounter;
    }

    public void setPinCounter(int pinCounter) {
        this.pinCounter = pinCounter;
    }

    public int getCurrency() {
        return currency;
    }

    public void setCurrency(int currency) {
        this.currency = currency;
    }

    public boolean isLockedCard() {
        return lockedCard;
    }

    public void setLockedCard(boolean lockedCard) {
        this.lockedCard = lockedCard;
    }

    public static String getBank() {
        return bank;
    }

    public static String setBank(String bank) {
        Bank.bank = bank;
        return bank;
    }

    public static int depositFunds(int amount, int currency){

        int total = amount + currency;

        return total;
    }
    public static int withdrawFunds(int amount, int currency){


        int total = currency - amount;

        return total;
    }

    public static String bankName(){
        return getBank();
    }

}

