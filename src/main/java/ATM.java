import java.util.Scanner;

public class ATM {

    private static Bank bank;

    public ATM(Bank bank) {
        this.bank = bank;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public int checkPin(Bank bank) {

        // inputByUser represents users pin-input in test.
        int inputByUser = 123;
        int pin = bank.getPin();
        int pinAttempts = bank.getPinCounter();
        int counter = 3;

        while(pinAttempts < 3) {

            // Scanner should exist here for user input.

            if (inputByUser == pin) {
                System.out.println("Pin accepted. Welcome " + bank.getUser() + ".");
                return pin;
            }
            // If all attempts has been made the card gets frozen.
            else if (counter == 1){
                System.out.println("0 attempts left. Your card has been frozen.");
                bank.setLockedCard(true);
                return inputByUser;
            }
            // Wrong pin adds and removes from attempts and counter.
            else {
                pinAttempts++;
                counter--;
                System.out.println("You have " + counter + " attempts left before card gets locked.");
            }
        }

        return inputByUser;

    }

    public boolean isCardFrozen(Bank bank) {

        if(bank.isLockedCard() == false){
            System.out.println("Card is valid.");
            return false;
        }
        else {
            System.out.println("Card is frozen.");
            return true;
        }

    }


    public int checkAmount(Bank bank) {
        return bank.getCurrency();
    }

    public int depositCurrency(Bank bank) {

        return Bank.depositFunds(amountInput(), bank.getCurrency());

    }

    public int amountInput(){
        // TEST
        return 500;
    }


    public int withdrawAmount(Bank bank) {
        return bank.withdrawFunds(amountInput(), bank.getCurrency());
    }

    public boolean withdrawAccepted(Bank bank) {

        if(amountInput() >= bank.getCurrency()){
            return false;
        }
        else{
            return true;
        }

    }

    public boolean closeProcess() {

        //Scanner sc = new Scanner(System.in);
        String sc = "PLEASE CLOSE";

        if(sc.equals("DON'T CLOSE")){
            System.out.println("Open for business");
            return false;
        }else{
            //sc.close();
            return true;
        }
    }
}
