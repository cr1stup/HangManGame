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
        game.settingHiddenWord(input.inputCategory());
        game.settingComplexity(input.inputComplexity());

        GameStatus status = GameStatusChecker.check(game);

        renderer.showCategory(game);
        renderer.showComplexity(game);

        while (status == GameStatus.ONGOING) {
            renderer.render(game);
            char guess = input.inputLetter(game);
            game.checkGuess(guess);
            status = GameStatusChecker.check(game);
        }

        if (status == GameStatus.ERROR) {
            renderer.printError();
        } else {
            renderer.render(game);
            renderer.showEndOfGame(status, game);
        }
    }
}
