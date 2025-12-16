import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

class StateMachineTest {

    @ParameterizedTest(name = "Input: \"{0}\" -> Expected State: {1}")
    @CsvSource({
            "abcTESTabc, F",
            "abcTES,     3",
            "abTE,       2",
            "abT,        1",
            "abc,        S",

            "TEST,       F",
            "'',         S",
            "FAIL,       S",

            "TTEST,      F",
            "TETEST,     F",
            "TTTEST,     F"
    })
    void testStateMachineLogic(String input, String expectedState) {
        StateMachine sm = new StateMachine();

        String textToProcess = (input == null) ? "" : input;

        String actualState = sm.process(textToProcess);

        assertEquals(expectedState, actualState,
                "Помилка для вхідного рядка: '" + input + "'");
    }
}
