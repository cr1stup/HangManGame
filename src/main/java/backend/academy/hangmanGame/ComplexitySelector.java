package backend.academy.hangmanGame;

import java.util.HashMap;
import java.util.Map;
import lombok.Getter;

@Getter
@SuppressWarnings("MultipleStringLiterals")
public class ComplexitySelector {
    private final String[] complexities;
    private final Map<String, String[]> mapOfPatterns;

    public ComplexitySelector() {
        complexities = new String[] {"null", "Easy", "Medium", "Hard"};
        mapOfPatterns = new HashMap<>();
        mapOfPatterns.put("Easy", new String[] {"ZERO", "ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX"});
        mapOfPatterns.put("Medium", new String[] {"ZERO", "ONE", "THREE", "FOUR", "FIVE", "SIX"});
        mapOfPatterns.put("Hard", new String[] {"ZERO", "ONE", "THREE", "FIVE", "SIX"});
    }

    public String[] getComplexityPattern(int complexity) {
        return mapOfPatterns.get(complexities[complexity]);
    }

    public int getMaxError(int complexity) {
        return getComplexityPattern(complexity).length - 1;
    }
}
