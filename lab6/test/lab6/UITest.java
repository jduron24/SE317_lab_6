package lab6;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.InputStream;
import java.io.PrintStream;

public class UITest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final String simulatedUserInput = "testUser\npassword123\nl\n";
    private InputStream originalIn;
    private PrintStream originalOut;

    @BeforeEach
    public void setUp() {
        // Save the original System.in and System.out
        originalIn = System.in;
        originalOut = System.out;

        // Redirect System.in to simulate user inputs
        ByteArrayInputStream in = new ByteArrayInputStream(simulatedUserInput.getBytes());
        System.setIn(in);
        // Redirect System.out to capture outputs for verification
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreSystemInOut() {
        // Restore System.in and System.out to their original settings
        System.setIn(originalIn);
        System.setOut(originalOut);
    }

    @Test
    public void testLoginProcess() {
        ATM.main(new String[]{});  // This will run the main method which starts the interaction
        assertTrue(outContent.toString().contains("Login successful"));
    }
}
