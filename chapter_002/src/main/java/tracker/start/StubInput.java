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

    @Override
    public int ask(String question, int[] range) throws MenuOutException  {
       return Integer.valueOf(this.answers[positions++]);
     /*   int key = Integer.valueOf(this.ask(question));
        boolean exist = false;
        for (int value : range) {
            if (value == key) {
                exist = true;
                break;
            }
        }
        if (exist) {
            return key;
        } else {
            throw new MenuOutException("out of range");
        }
        */
    }
}

