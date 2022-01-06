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
   @BeforeEach
   void setup() {
       bank = mock(Bank.class);
       atm = new ATM(bank);
   }

    // Test for PIN input.
    @Test
    void check_pin() {

        when(bank.getPin()).thenReturn(123);
        when(bank.getPinCounter()).thenReturn(0);

        int expected = 123;
        int actual = atm.checkPin(bank);

        assertEquals(expected, actual);
    }

    // Check if card is frozen.
    @Test
    void check_If_Card_Is_Locked() {

        when(bank.isLockedCard()).thenReturn(false);

        boolean expected = false;
        boolean actual = atm.isCardFrozen(bank);

        assertEquals(expected, actual);

    }

    // Not enough funds on the account.
    @Test
    void should_Return_False_If_Not_Enough_Funds(){

        when(bank.getCurrency()).thenReturn(1);

        boolean expected = false;
        boolean actual = atm.withdrawAccepted(bank);

        System.out.println("Withdraw successful = " + atm.withdrawAccepted(bank));
        assertEquals(expected,actual);

    }

    // Deposit currency.
    @Test
    void deposit_Currency_To_Account(){

        int getCurrencyReturn = 100;
        when(bank.getCurrency()).thenReturn(getCurrencyReturn);
        when(bank.depositFunds(500, bank.getCurrency())).thenReturn(600);

        int expected = 600;
        int actual = atm.depositCurrency(bank);

        assertEquals(expected, actual);
        verify(bank).depositFunds(anyInt(), anyInt());

    }

    // Withdraw currency.
    @Test
    void withdraw_Amount_From_Account(){

        int getCurrencyReturn = 1000;
        when(bank.getCurrency()).thenReturn(getCurrencyReturn);
        when(bank.withdrawFunds(500, bank.getCurrency())).thenReturn(500);

        int expected = 500;
        int actual = atm.withdrawAmount(bank);

        assertEquals(expected, actual);
        verify(bank).withdrawFunds(anyInt(), anyInt());
    }

    // Check amount of currency.
    @Test
    void check_Amount_On_Account(){

        when(bank.getCurrency()).thenReturn(1000);

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