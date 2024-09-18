package backend.academy.hangmanGame;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GameState {
    private String hiddenWord;
    private String hiddenViewWord;
    private String hint;
    private int category;
    private int complexity;
    private int maxAttempt;
    private String[] complexityPattern;
    private final WordSelector wordSelector = new WordSelector();
    private final ComplexitySelector complexitySelector = new ComplexitySelector();

    public GameState() {
        hiddenWord = "";
        hiddenViewWord = "";
        hint = "";
        category = 1;
        complexity = 1;
    }

    public void checkGuess(char guess) {
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
