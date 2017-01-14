package tracker.start;

/**
 * Class StubInput для реализации автоввода с массива применяет интерфейс Input.
 * @author Zaur Turabayev
 * @since 04.01.2017
 * @version 1
 */
public class StubInput implements Input {
    private String[] answers;
    private int positions = 0;
    /**
     * Description.
     * Конструктор  меню.
     * @param answers ввод пользователя
     */
    public StubInput(String[] answers) {
        this.answers = answers;
    }
    public String ask(String question) {
        return answers[positions++];
    }
}

