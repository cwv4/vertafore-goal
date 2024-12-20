package parameterizedtest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class ParameterizedTestApplicationTest {

    /*
     * Conclusion: If you have more than two similar tests, use parameterized tests.
     * If you have just a few, use @CsvSource (unless value/field source are sufficient)
     * If you have a medium amount, use @MethodSource.
     * If you have a lot, put them in a file and use @CsvFileSource.
     */
    @ParameterizedTest
    @CsvFileSource(resources = "/data.csv", numLinesToSkip = 1)
    void testApplication(String option, String input, String expectedOutput) {
        String testInput = option + "\n" + input + "\n";
        ByteArrayInputStream testIn = new ByteArrayInputStream(testInput.getBytes());
        System.setIn(testIn);

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        ParameterizedTestApplication.main(new String[0]);
        Assertions.assertEquals(expectedOutput + "\r\n", output.toString());
    }
}
