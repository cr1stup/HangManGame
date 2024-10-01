package backend.academy.hangmanTests;

import backend.academy.hangmanGame.Categories;
import backend.academy.hangmanGame.WordSelector;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import java.security.SecureRandom;

public class CorrectHiddenWordTest {

    private String hiddenWord;

    @BeforeEach
    public void setUp() {
        WordSelector wordSelector = new WordSelector();
        SecureRandom random = new SecureRandom();
        int randomCategory = random.nextInt(Categories.values().length);
        hiddenWord = wordSelector.getRandomWord(randomCategory);
    }

    @RepeatedTest(3)
    @DisplayName("hidden word is not null")
    public void testWordNotNull() {
        Assertions.assertNotNull(hiddenWord);
    }

    @RepeatedTest(3)
    @DisplayName("hidden word is not blank")
    public void testWordNotBlank() {
        Assertions.assertFalse(hiddenWord.isBlank());
    }

    @RepeatedTest(3)
    @DisplayName("hidden word not contains digit")
    public void testWordNotContainDigit() {
        Assertions.assertFalse(hiddenWord.matches("-?\\d+(\\.\\d+)?"));
    }

    @RepeatedTest(3)
    @DisplayName("hidden word in lower case")
    public void testHiddenWordInLowerCase() {
        Assertions.assertEquals(hiddenWord.toLowerCase(), hiddenWord);
    }
}
