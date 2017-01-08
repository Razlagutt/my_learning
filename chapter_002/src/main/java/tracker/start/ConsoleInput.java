package tracker.start;

import java.util.Scanner;

/**
 * Class Task Описание заявки.
 * @author Zaur Turabayev
 * @since 04.01.2016
 * @version 1
 */
public class ConsoleInput implements Input {
    private Scanner scanner = new Scanner(System.in);

    public String ask(String question) {
        System.out.println(question);
        return scanner.nextLine();
    }
}

