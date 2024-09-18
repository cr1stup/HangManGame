package backend.academy.hangmanTests;

import backend.academy.hangmanGame.HangmanPicture;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;

public class GameStateAfterCorrectInputTest extends TestUtils {

    @ParameterizedTest
    @MethodSource("provideDataForPictureTest")
    @DisplayName("test change hangman picture")
    public void testHangmanPicture(String hiddenWord, char guess, HangmanPicture expectedPicture) {
        Assertions.assertEquals(expectedPicture, getActualHangmanPicture(hiddenWord, guess));
    }

    @ParameterizedTest
    @MethodSource("provideDataForWordTest")
    @DisplayName("test change hidden view word")
    public void testHiddenViewWord(String hiddenWord, char guess, String expectedView) {
        Assertions.assertEquals(expectedView, getActualHiddenViewWord(hiddenWord, guess));
    }

    @ParameterizedTest
    @MethodSource("provideDataForAttemptsTest")
    @DisplayName("test change remaining attempts")
    public void testRemainingAttempts(String hiddenWord, char guess, int expectedAttempts) {
        Assertions.assertEquals(expectedAttempts, getActualRemainingAttempts(hiddenWord, guess));
    }

    private static Stream<Arguments> provideDataForPictureTest() {
        return Stream.of(
            Arguments.of("test", 't', HangmanPicture.ZERO),
            Arguments.of("word", 't', HangmanPicture.ONE)
        );
    }

    private static Stream<Arguments> provideDataForWordTest() {
        return Stream.of(
            Arguments.of("test", 't', "t__t"),
            Arguments.of("word", 't', "____")
        );
    }

    private static Stream<Arguments> provideDataForAttemptsTest() {
        return Stream.of(
            Arguments.of("test", 't', 6),
            Arguments.of("word", 't', 5)
        );
    }
}
