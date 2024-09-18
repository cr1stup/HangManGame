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

    public InputProcess(InputStream inputStream, PrintStream printStream) {
        Charset charset = StandardCharsets.UTF_8;
        this.scanner = new Scanner(inputStream, charset);
        this.printStream = printStream;
        random = new SecureRandom();
    }

    public char inputLetter() {
        printStream.print("Enter your letter: ");
        return scanner.nextLine().charAt(0);
    }

    public int inputCategory() {
        WordSelector wordSelector = new WordSelector();
        while (true) {
            for (int i = 1; i < wordSelector.categories().length; i++) {
                printStream.println(i + ". " + wordSelector.categories()[i]);
            }

            printStream.print("\nEnter category: ");
            String category = scanner.nextLine();

            if (category.isBlank()) {
                printStream.println();
                return getRandomNum(wordSelector.categories().length);
            } else if (!category.matches("-?\\d+(\\.\\d+)?")
                || Integer.parseInt(category) <= 0
                || Integer.parseInt(category) >= wordSelector.categories().length) {
                printStream.println("\nInvalid input! Try again");
            } else {
                printStream.println();
                return Integer.parseInt(category);
            }
        }
    }

    public int getRandomNum(int max) {
        return random.nextInt(max - 1) + 1;
    }
}
