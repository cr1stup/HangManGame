package backend.academy.hangmanTests;

import backend.academy.hangmanGame.GameState;
import backend.academy.hangmanGame.HangmanPicture;

public class TestUtils {

    private final GameState game = new GameState();

    public HangmanPicture getActualHangmanPicture(String hiddenWord, char guess) {
        game.hiddenWord(hiddenWord);
        game.hiddenViewWord("_".repeat(hiddenWord.length()));
        game.checkGuess(guess);
        return game.hangmanPicture();
    }

    public String getActualHiddenViewWord(String hiddenWord, char guess) {
        game.hiddenWord(hiddenWord);
        game.hiddenViewWord("_".repeat(hiddenWord.length()));
        game.checkGuess(guess);
        return game.hiddenViewWord();
    }

    public int getActualRemainingAttempts(String hiddenWord, char guess) {
        game.hiddenWord(hiddenWord);
        game.hiddenViewWord("_".repeat(hiddenWord.length()));
        game.checkGuess(guess);
        return game.getRemainingAttempts();
    }
}
