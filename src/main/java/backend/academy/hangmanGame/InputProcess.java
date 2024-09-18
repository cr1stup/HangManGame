package backend.academy.hangmanGame;

import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.Scanner;

public class InputProcess {
    private final Scanner scanner;
    private final PrintStream printStream;
    private final SecureRandom random;
    private final String digits;
    private final String errorMessage;

    public InputProcess(InputStream inputStream, PrintStream printStream) {
        Charset charset = StandardCharsets.UTF_8;
        this.scanner = new Scanner(inputStream, charset);
        this.printStream = printStream;
        random = new SecureRandom();
        digits = "-?\\d+(\\.\\d+)?";
        errorMessage = "%nInvalid input! Try again";
    }

    public char inputLetter(GameState game) {
        while (true) {
            printStream.print("Enter letter: ");
            String input = scanner.nextLine().toLowerCase();

            if ("hint".equals(input)) {
                printStream.println("hint: " + game.hint());
                printStream.println();
            } else if (input.isBlank()
                    || input.matches(digits)
                    || input.length() > 1
            ) {
                printStream.format(errorMessage);
            } else if (game.hiddenViewWord().contains((input))
                || game.errorChar().contains(input.charAt(0))) {
                printStream.format("You have already input this letter!%n");
            } else {
                printStream.println();
                return input.charAt(0);
            }
        }
    }

    public int inputCategory() {
        WordSelector wordSelector = new WordSelector();
        while (true) {
            for (int i = 1; i < wordSelector.categories().length; i++) {
                printStream.println(i + ". " + wordSelector.categories()[i]);
            }

            printStream.format("%nEnter category: ");
            String category = scanner.nextLine();

            if (category.isBlank()) {
                printStream.println();
                return getRandomNum(wordSelector.categories().length);
            } else if (!category.matches(digits)
                || Integer.parseInt(category) <= 0
                || Integer.parseInt(category) >= wordSelector.categories().length
            ) {
                printStream.format(errorMessage);
            } else {
                printStream.println();
                return Integer.parseInt(category);
            }
        }
    }

    public int inputComplexity() {
        ComplexitySelector complexitySelector = new ComplexitySelector();
        while (true) {
            for (int i = 1; i < complexitySelector.complexities().length; i++) {
                printStream.format("%d. %s (%d attempts)%n",
                    i, complexitySelector.complexities()[i], complexitySelector.getMaxError(i));
            }

            printStream.format("%nEnter complexity: ");
            String complexity = scanner.nextLine();

            if (complexity.isBlank()) {
                printStream.println();
                return getRandomNum(complexitySelector.complexities().length);
            } else if (!complexity.matches(digits)
                || Integer.parseInt(complexity) <= 0
                || Integer.parseInt(complexity) >= complexitySelector.complexities().length
            ) {
                printStream.format(errorMessage);
            } else {
                printStream.println();
                return Integer.parseInt(complexity);
            }
        }
    }

    public int getRandomNum(int max) {
        return random.nextInt(max - 1) + 1;
    }
}
