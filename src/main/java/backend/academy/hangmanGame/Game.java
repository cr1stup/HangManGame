package backend.academy.hangmanGame;

import java.io.InputStream;
import java.io.PrintStream;

public class Game {
    private final GameState game;
    private final GameRenderer renderer;
    private final InputProcess input;

    public Game(InputStream inputStream, PrintStream printStream) {
        game = new GameState();
        renderer = new GameRenderer(printStream);
        input = new InputProcess(inputStream, printStream);
    }

    public void gameLoop() {
        GameStatus status = GameStatusChecker.check();

        while (status == GameStatus.ONGOING) {
            renderer.render(game);

            char guess = input.inputLetter();

            game.checkGuess(guess);

            status = GameStatus.ERROR;
        }
    }
}
