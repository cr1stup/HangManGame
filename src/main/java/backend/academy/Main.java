package backend.academy;

import backend.academy.hangmanGame.Game;
import lombok.experimental.UtilityClass;

@UtilityClass
public class Main {
    public static void main(String[] args) {
        Game game = new Game(System.in, System.out);
        game.gameLoop();
    }
}
