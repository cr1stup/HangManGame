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
    private final WordSelector wordSelector = new WordSelector();

    public GameState() {
        hiddenWord = "";
        hiddenViewWord = "";
        hint = "";
        category = 1;
    }

    public void checkGuess(char guess) {
    }

    public void settingHiddenWord(int category) {
        hiddenWord = wordSelector.getRandomWord(category);
        hint = wordSelector.hint();
        hiddenViewWord = "_".repeat(hiddenWord.length());
        this.category = category;
    }
}
