package backend.academy.hangmanGame;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class GameStatusChecker {
    public static GameStatus check() {
        return GameStatus.ONGOING;
    }
}
