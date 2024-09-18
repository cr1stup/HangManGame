package backend.academy.hangmanGame;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;
import lombok.Getter;

@Getter
@SuppressWarnings("MultipleStringLiterals")
public class WordSelector {
    private String hint;
    private final String[] categories;
    private final Map<String, Word[]> mapOfWords;
    private final SecureRandom random;

    public WordSelector() {
        hint = "";
        categories = new String[] {"null", "Sport", "Animals", "Planets"};
        mapOfWords = new HashMap<>();
        random = new SecureRandom();

        mapOfWords.put("Sport", new Word[] {
            new Word("basketball", "orange ball"),
            new Word("swimming", "no way without water"),
            new Word("golf", "small white ball"),
            new Word("baseball", "with a bat"),
            new Word("cycling", "don't invent it")});

        mapOfWords.put("Animals", new Word[] {
            new Word("horse", "there is a rider"),
            new Word("zebra", "black and white"),
            new Word("bear", "clubfoot"),
            new Word("wolf", "work is not this"),
            new Word("lion", "the king")});

        mapOfWords.put("Planets", new Word[] {
            new Word("mercury", "very hot"),
            new Word("venus", "goddess of beauty"),
            new Word("earth", "our home"),
            new Word("mars", "Elon Mask"),
            new Word("jupiter", "very big"),
            new Word("saturn", "with ring"),
            new Word("neptune", "last")});
    }

    public String getRandomWord(int category) {
        Word[] words = mapOfWords.get(categories[category]);
        int randomWord = random().nextInt(words.length);
        hint = words[randomWord].hint();
        return words[randomWord].word();
    }
}
