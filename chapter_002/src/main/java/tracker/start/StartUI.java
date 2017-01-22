package tracker.start;
import tracker.models.*;

import java.util.Arrays;

/**
 * Class StartUI класс реализующий запуск  меню пользователя.
 * @author Zaur Turabayev
 * @since 04.01.2016
 * @version 1
 */
public class StartUI {
    private int[] range;
    private Input input;
    private Tracker tracker;
    /**
     * Description.
     * Конструктор  класса.
     * @param input объект ввода пользователя
     * @param tracker объект заявок
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }
    /**
     * Метод init  запускает меню через класс MenuTracker.
     */
    public void init() {

        MenuTracker menu = new MenuTracker(this.input, tracker);

        menu.fillActions();
        range = menu.getRange();
        do {
            menu.show();
          //  int key = Integer.valueOf(input.ask("Select:"));
            menu.select(input.ask("Select:", range));
        } while (!"y".equals(this.input.ask("Exit? Y")));
    }

    /**
     * Метод main  главный метод.
     */

    public static void main(String[] args) {
        //Input input =  new StubInput(new String[] {"create stub task"});
        Input input = new ValidateInput();
        Tracker tracker = new Tracker();
        //new StartUI(input, tracker).menu();
        new StartUI(input, tracker).init();
    }
}