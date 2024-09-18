package backend.academy.hangmanGame;

import java.io.PrintStream;

public class GameRenderer {
    private final PrintStream printStream;

    public GameRenderer(PrintStream printStream) {
        this.printStream = printStream;
    }

    public void render(GameState game) {
        printStream.println(game.hangmanPicture());
        printStream.println("Hidden word: " + game.hiddenViewWord());
        printStream.println("Remaining attempts: " + game.getRemainingAttempts());
        printStream.println("To use hint type: \"hint\"");
        printStream.println();
    }
}
