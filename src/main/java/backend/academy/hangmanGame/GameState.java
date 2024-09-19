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
    private final Set<Character> errorChar;
    private final WordSelector wordSelector;
    private final ComplexitySelector complexitySelector;

    public GameState() {
        errorChar = new HashSet<>();
        wordSelector = new WordSelector();
        complexitySelector = new ComplexitySelector();
        hangmanPicture = HangmanPicture.ZERO;
        hiddenWord = "";
        hiddenViewWord = "";
        hint = "";
        category = 1;
        complexity = 1;
        errorCount = 0;
        maxAttempt = complexitySelector.getMaxError(complexity);
        complexityPattern = complexitySelector.getComplexityPattern(complexity);
    }

    public void checkGuess(char guess) {
        if (guess == ' ') {
            return;
        }

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

    public int getRemainingAttempts() {
        return maxAttempt - errorCount;
    }

    public String getCategoryName() {
        return wordSelector.categories()[category];
    }

    public String getComplexityName() {
        return complexitySelector.complexities()[complexity];
    }
}
