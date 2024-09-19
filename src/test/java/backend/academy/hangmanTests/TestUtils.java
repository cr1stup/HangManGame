package backend.academy.hangmanTests;

import backend.academy.hangmanGame.GameState;
import backend.academy.hangmanGame.HangmanPicture;
import backend.academy.hangmanGame.InputProcess;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class TestUtils {

    private final GameState game;
    private final PrintStream ps;
    private final ByteArrayOutputStream byteArrayOutputStream;

    public TestUtils() {
        game = new GameState();
        byteArrayOutputStream = new ByteArrayOutputStream();
        ps = new PrintStream(byteArrayOutputStream);
    }

    public HangmanPicture getActualHangmanPicture(String hiddenWord, String input) {
        input = input + String.format("%n");
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        InputProcess inputProcess = new InputProcess(inputStream, ps);

        char guess = inputProcess.inputLetter(new GameState());

        game.hiddenWord(hiddenWord);
        game.hiddenViewWord("_".repeat(hiddenWord.length()));
        game.checkGuess(guess);

        return game.hangmanPicture();
    }

    public String getActualHiddenViewWord(String hiddenWord, String input) {
        input = input + String.format("%n");
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        InputProcess inputProcess = new InputProcess(inputStream, ps);

        char guess = inputProcess.inputLetter(new GameState());

        game.hiddenWord(hiddenWord);
        game.hiddenViewWord("_".repeat(hiddenWord.length()));
        game.checkGuess(guess);

        return game.hiddenViewWord();
    }

    public int getActualRemainingAttempts(String hiddenWord, String input) {
        input = input + String.format("%n");
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        InputProcess inputProcess = new InputProcess(inputStream, ps);

        char guess = inputProcess.inputLetter(new GameState());

        game.hiddenWord(hiddenWord);
        game.hiddenViewWord("_".repeat(hiddenWord.length()));
        game.checkGuess(guess);

        return game.getRemainingAttempts();
    }

    public String getOutput(String input) {
        input = input + String.format("%n");
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());

        InputProcess inputProcess = new InputProcess(inputStream, ps);
        inputProcess.inputLetter(new GameState());

        return byteArrayOutputStream.toString();
    }
}
