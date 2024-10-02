package backend.academy.hangmanGame;

import java.util.EnumMap;
import java.util.Map;

@SuppressWarnings("MultipleStringLiterals")
public class ComplexitySelector {
    private final Map<Complexities, String[]> mapOfPatterns;

    public ComplexitySelector() {
        mapOfPatterns = new EnumMap<>(Complexities.class);
        mapOfPatterns.put(Complexities.EASY, new String[] {"ZERO", "ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX"});
        mapOfPatterns.put(Complexities.MEDIUM, new String[] {"ZERO", "ONE", "THREE", "FOUR", "FIVE", "SIX"});
        mapOfPatterns.put(Complexities.HARD, new String[] {"ZERO", "ONE", "THREE", "FIVE", "SIX"});
    }

    public String[] getComplexityPattern(int complexity) {
        return mapOfPatterns.get(Complexities.values()[complexity]);
    }

    public int getMaxError(int complexity) {
        return getComplexityPattern(complexity).length - 1;
    }
}
