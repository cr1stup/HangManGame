package backend.academy.hangmanGame;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class GameStatusChecker {
    public static GameStatus check(GameState game) {
        if (game.hiddenWord() == null || game.hiddenWord().isBlank()) {
            return GameStatus.ERROR;
        } else if (game.getRemainingAttempts() == 0) {
            return GameStatus.LOSS;
        } else if (game.numOfGuessedLetters() == game.hiddenViewWord().length()) {
            return GameStatus.WIN;
        }

        return GameStatus.ONGOING;
    }
}
