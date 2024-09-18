package backend.academy.hangmanGame;

import java.util.HashSet;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GameState {
    private String hiddenWord;
    private String hiddenViewWord;
    private String hint;
    private HangmanPicture hangmanPicture;
    private int category;
    private int complexity;
    private int maxAttempt;
    private int errorCount;
    private int numOfGuessedLetters;
    private String[] complexityPattern;
    private final Set<Character> errorChar = new HashSet<>();
    private final WordSelector wordSelector = new WordSelector();
    private final ComplexitySelector complexitySelector = new ComplexitySelector();

    public GameState() {
        hangmanPicture = HangmanPicture.ZERO;
        hiddenWord = "";
        hiddenViewWord = "";
        hint = "";
        category = 1;
        complexity = 1;
    }

    public void checkGuess(char guess) {
        if (hiddenWord.contains(String.valueOf(guess))) {
            char[] tempView = hiddenViewWord.toCharArray();

            for (int i = 0; i < hiddenWord.length(); i++) {
                if (hiddenWord.charAt(i) == guess) {
                    numOfGuessedLetters++;
                    tempView[i] = guess;
                }
            }

            hiddenViewWord = new String(tempView);

        } else {
            errorChar.add(guess);
            errorCount++;
            hangmanPicture = HangmanPicture.valueOf(complexityPattern[errorCount]);
        }
    }

    public void settingHiddenWord(int category) {
        hiddenWord = wordSelector.getRandomWord(category);
        hint = wordSelector.hint();
        hiddenViewWord = "_".repeat(hiddenWord.length());
        this.category = category;
    }

    public void settingComplexity(int complexity) {
        complexityPattern = complexitySelector.getComplexityPattern(complexity);
        maxAttempt = complexitySelector.getMaxError(complexity);
        this.complexity = complexity;
    }
}
