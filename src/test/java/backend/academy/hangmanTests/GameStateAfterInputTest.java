package backend.academy.hangmanTests;

import backend.academy.hangmanGame.HangmanPicture;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.stream.Stream;

public class GameStateAfterInputTest extends TestUtils {

    @ParameterizedTest
    @MethodSource("provideDataForPictureTest")
    @DisplayName("test change hangman picture")
    public void testHangmanPicture(String hiddenWord, String input, HangmanPicture expectedPicture) {
        Assertions.assertEquals(expectedPicture, getActualHangmanPicture(hiddenWord, input));
    }

    @ParameterizedTest
    @MethodSource("provideDataForWordTest")
    @DisplayName("test change hidden view word")
    public void testHiddenViewWord(String hiddenWord, String input, String expectedView) {
        Assertions.assertEquals(expectedView, getActualHiddenViewWord(hiddenWord, input));
    }

    @ParameterizedTest
    @MethodSource("provideDataForAttemptsTest")
    @DisplayName("test change remaining attempts")
    public void testRemainingAttempts(String hiddenWord, String input, int expectedAttempts) {
        Assertions.assertEquals(expectedAttempts, getActualRemainingAttempts(hiddenWord, input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"aa", "bb", "asd"})
    @DisplayName("test again input after typo")
    public void testAgainInputAfterTypo(String input) {
        Assertions.assertTrue(getOutput(input).contains("Enter letter: "));
    }

    private static Stream<Arguments> provideDataForPictureTest() {
        return Stream.of(
            Arguments.of("test", "t", HangmanPicture.ZERO),
            Arguments.of("test", "T", HangmanPicture.ZERO),
            Arguments.of("word", "n", HangmanPicture.ONE),
            Arguments.of("word", "N", HangmanPicture.ONE),
            Arguments.of("test", "1", HangmanPicture.ZERO),
            Arguments.of("test", "aa", HangmanPicture.ZERO),
            Arguments.of("test", " ", HangmanPicture.ZERO)
        );
    }

    private static Stream<Arguments> provideDataForWordTest() {
        return Stream.of(
            Arguments.of("test", "t", "t__t"),
            Arguments.of("test", "T", "t__t"),
            Arguments.of("word", "n", "____"),
            Arguments.of("word", "N", "____"),
            Arguments.of("test", "1", "____"),
            Arguments.of("test", "aa", "____"),
            Arguments.of("test", " ", "____")
        );
    }

    private static Stream<Arguments> provideDataForAttemptsTest() {
        return Stream.of(
            Arguments.of("test", "t", 6),
            Arguments.of("test", "T", 6),
            Arguments.of("word", "n", 5),
            Arguments.of("word", "N", 5),
            Arguments.of("test", "1", 6),
            Arguments.of("test", "aa", 6),
            Arguments.of("test", " ", 6)
        );
    }
}
