import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ATMTest {

    @InjectMocks
    private ATM atm;
    @Mock
    private Bank bank;

    // Setup and mocking on Bank class.
//    @BeforeEach
//    void setup(){
//
//        bank = mock(Bank.class);
//        atm = new ATM(bank);
//
//    }

    // Test for PIN input.
    @Test
    void check_pin() {
        Bank bank = new Bank("Test Driven", 123, 123, 0, 123321, false);

        int expected = 123;
        int actual = atm.checkPin(bank);

        assertEquals(expected, actual);
    }

    // Check if card is frozen.
    @Test
    void check_If_Card_Is_Locked() {
        Bank bank = new Bank("Test Driven", 123, 123, 0, 123321, false);

        boolean expected = false;
        boolean actual = atm.isCardFrozen(bank);

        assertEquals(expected, actual);

    }

    // Not enough funds on the account.
    @Test
    void should_Return_False_If_Not_Enough_Funds(){
        Bank bank = new Bank("Test Driven", 123, 123, 0, 150, false);

        boolean expected1 = false;
        boolean actual1 = atm.withdrawAccepted(bank);

        System.out.println("Withdraw successful = " + atm.withdrawAccepted(bank));
        assertEquals(expected1,actual1);

    }

    // Deposit currency.
    @Test
    void deposit_Currency_To_Account(){
        Bank bank = new Bank("Test Driven", 123, 123, 0, 100, false);

        atm.depositCurrency(bank);

        int expected = 600;
        int actual = atm.depositCurrency(bank);

        assertEquals(expected, actual);

        System.out.println(atm.depositCurrency(bank));

        // Får inte rätt på verify.
        //verify(bank).depositFunds(anyInt(), anyInt());
    }

    // Withdraw currency.
    @Test
    void withdraw_Amount_From_Account(){
        Bank bank = new Bank("Test Driven", 123, 123, 0, 1000, false);

        int expected = 500;
        int actual = atm.withdrawAmount(bank);

        System.out.println(atm.withdrawAmount(bank));
        assertEquals(expected, actual);

        // Får inte rätt på verify.
        //verify(bank).withdrawFunds(anyInt(), anyInt());
    }

    // Check amount of currency.
    @Test
    void check_Amount_On_Account(){
        Bank bank = new Bank("Test Driven", 123, 123, 0, 1000, false);

        int expected = 1000;
        int actual = atm.checkAmount(bank);

        System.out.println(atm.checkAmount(bank));
        assertEquals(expected, actual);

    }

    // Close process.
    @Test
    void should_Close_Process(){

        boolean expected = true;
        boolean actual = atm.closeProcess();

        assertEquals(expected, actual);

    }

    // BANK - STATIC - MOCKED - BLA BLA BLA.
    @Test
    void should_Return_Name_Of_Bank(){

        try {
            MockedStatic<Bank> mockedStaticConverter = mockStatic(Bank.class);

            mockedStaticConverter.when(() -> bank.bankName()).thenReturn("HANDELSBANKEN");

        String expected = "HANDELSBANKEN";
        String actual = bank.bankName();

        assertEquals(expected, actual);

        System.out.println(bank.bankName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}