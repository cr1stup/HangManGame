package backend.academy.hangmanGame;

import java.io.PrintStream;

public class GameRenderer {
    private final PrintStream printStream;

    public GameRenderer(PrintStream printStream) {
        this.printStream = printStream;
    }

    public void render(GameState game) {
        printStream.println("Welcome to Hangman Game");
    }
}
