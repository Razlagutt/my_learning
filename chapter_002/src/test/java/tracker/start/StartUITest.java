package tracker.start;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertNull;

/**
 * Class StartUITest класс реализующий тестирование, имитирующий ввод пользователя и проверку состояния.
 * @author Zaur Turabayev
 * @since 07.01.2017
 * @version 1
 */
public class StartUITest {
    private StartUI Select;
    private Tracker tracker = new Tracker();
    private Input input;
    private  MenuTracker menuTracker = new MenuTracker(this.input, tracker);

    /**
     * Метод initTest  реализован запуск тестирования метода init.
     *  @param enters данные автоввода
     */
    private void initTest(String[] enters) {
        StubInput stubInput = new StubInput(enters);
        this.Select = new StartUI(stubInput,this.tracker);
        Select.init();
    }


    /**
     * Метод TestInitAddItem тестирует метод init  на добавление заявок с проверкой состояния.
     */
    @Test
    public void TestInitAddItem() throws Exception {
        String[] firstAnswers = new String[] {"1", "firstTask", "descTask1", "n", "1", "secondTask", "descTask2", "y"};
        this.initTest(firstAnswers);
        assertThat(tracker.getAll()[0].getName(), is ("firstTask"));
        assertThat(tracker.getAll()[1].getName(), is ("secondTask"));
    }
    /**
     * Метод TestInitUpdateItem тестирует метод init  на измеение заявки с проверкой состояния.
     */
    @Test
    public void TestInitUpdateItem() throws Exception {
        String[] firstAnswers = new String[] {"1", "firstTask", "descTask1", "y"};
        this.initTest(firstAnswers);
        String[] secondAnswers = new String[] {"2",this.tracker.findByname("firstTask").getId(), "UpdatedTask",
                "descTask1", "ASAP", "y"};
        this.initTest(secondAnswers);
        assertThat(tracker.getAll()[0].getName(), is ("UpdatedTask"));
    }
    /**
     * Метод TestInitDeleteItem тестирует метод init  на удаление с проверкой состояния.
     */
    @Test
    public void TestInitDeleteItem() throws Exception {
        String[] firstAnswers = new String[] {"1", "firstTask", "descTask1", "y"};
        this.initTest(firstAnswers);
        String[] secondAnswers = new String[] {"3",this.tracker.findByname("firstTask").getId(),"y"};
        this.initTest(secondAnswers);

        assertNull(this.tracker.getAll()[0]);
    }
    /**
     * Метод TestInitShowAllItem тестирует метод init  на измеение вовод заявок с проверкой состояния.
     */
    @Test
    public void TestInitShowAllItem() throws Exception {
        String[] firstAnswers = new String[] {"1", "firstTask", "descTask1", "n", "1", "secondTask", "descTask2", "y"};
        this.initTest(firstAnswers);
        assertThat(tracker.getAll()[0].getName(), is ("firstTask"));
        assertThat(tracker.getAll()[1].getName(), is ("secondTask"));
    }
    /**
     * Метод TestInitShowWithFilter тестирует метод init  на поиск  проверкой состояния.
     */
    @Test
    public void TestInitShowWithFilter() throws Exception {
        String[] firstAnswers = new String[] {"1", "firstTask", "descTask1","n", "1", "secondTask", "descTask2", "y"};
        this.initTest(firstAnswers);
        String[] secondAnswers = new String[] {"5","second","y"};
        this.initTest(secondAnswers);
        assertThat(tracker.getAll()[1].getName(), is ("secondTask"));
    }
    /**
     * Метод TestInitAddComment тестирует метод init  на  добавлениекоментария с проверкой состояния.
     */
    @Test
    public void TestInitAddComment() throws Exception {
        String[] firstAnswers = new String[] {"1", "firstTask", "descTask1", "n", "1", "secondTask", "descTask2", "y"};
        this.initTest(firstAnswers);
        String[] secondAnswers = new String[] {"6","secondTask", "solve ASAP", "y"};
        this.initTest(secondAnswers);
        assertThat(tracker.findByname("secondTask").getComment(), is ("solve ASAP"));
    }
    /**
     * Метод TestInitValidateInput тестирует метод init на неправильный ввод.
     */

}