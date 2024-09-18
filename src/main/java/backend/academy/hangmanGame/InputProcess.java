package backend.academy.hangmanGame;

import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class InputProcess {
    private final Scanner scanner;
    private final PrintStream printStream;

    public InputProcess(InputStream inputStream, PrintStream printStream) {
        Charset charset = StandardCharsets.UTF_8;
        this.scanner = new Scanner(inputStream, charset);
        this.printStream = printStream;
    }

    public char inputLetter() {
        printStream.print("Enter your letter: ");
        return scanner.nextLine().charAt(0);
    }
}
