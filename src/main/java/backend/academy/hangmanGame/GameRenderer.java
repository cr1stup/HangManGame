package backend.academy.hangmanGame;

import java.io.PrintStream;

@SuppressWarnings("MultipleStringLiterals")
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

    public void showEndOfGame(GameStatus status, GameState game) {
        if (status == GameStatus.WIN) {
            printStream.println("You win!");
        } else {
            printStream.println("You lose!");
            printStream.println("Hidden word: " + game.hiddenWord());
        }
        printStream.println();
    }

    public void printError() {
        printStream.format("%nSomething went wrong! Word is not hidden.%n");
    }

    public void showCategory(GameState game) {
        printStream.println("Your category: " + game.getCategoryName());
    }

    public void showComplexity(GameState game) {
        printStream.println("Your complexity: " + game.getComplexityName());
        printStream.println();
    }
}
