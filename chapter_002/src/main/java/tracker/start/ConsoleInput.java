package tracker.start;

import java.util.Scanner;

/**
 * Class ConsoleInput для реализации ввода с консоли применяет интерфейс Input.
 * @author Zaur Turabayev
 * @since 04.01.2017
 * @version 1
 */
public class ConsoleInput implements Input {
    /**
     * объект для считывания ввода.
     */
    private Scanner scanner = new Scanner(System.in);
    /**
     * Метод ask запрос ввода.
     * @param question строка вопроса
     * @return возвращает введеный ответ
     */
    public String ask(String question) {
        System.out.println(question);
        return scanner.nextLine();
    }
}

