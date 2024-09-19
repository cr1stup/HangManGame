package backend.academy.hangmanTests;

import backend.academy.hangmanGame.GameState;
import backend.academy.hangmanGame.GameStatus;
import backend.academy.hangmanGame.GameStatusChecker;
import backend.academy.hangmanGame.InputProcess;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class GameStatusTest {

    private GameState game;

    @BeforeEach
    public void setUp() {
        game = new GameState();
    }

    @Test
    @DisplayName("game not start with incorrect hidden word")
    public void testGameNotStartWithIncorrectHiddenWord() {
        game.hiddenWord("");

        GameStatus actualStatus = GameStatusChecker.check(game);

        Assertions.assertEquals(GameStatus.ERROR, actualStatus);
    }

    @Test
    @DisplayName("game return loss after attempts over")
    public void testGameReturnLossAfterAttemptsOver() {
        inputWrongLettersToLoss();

        Assertions.assertEquals(GameStatus.LOSS, GameStatusChecker.check(game));
    }

    private void inputWrongLettersToLoss() {
        game.hiddenWord("word");
        game.hiddenViewWord("_".repeat("word".length()));

        String wrongLetters = String.format("q%np%nl%nh%nm%nc%n");

        ByteArrayInputStream inputStream = new ByteArrayInputStream(wrongLetters.getBytes());
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        PrintStream ps = new PrintStream(byteArrayOutputStream);
        InputProcess inputProcess = new InputProcess(inputStream, ps);

        while (GameStatusChecker.check(game) == GameStatus.ONGOING) {
            char guess = inputProcess.inputLetter(game);
            game.checkGuess(guess);
        }
    }
}
