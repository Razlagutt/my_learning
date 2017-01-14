package tracker.start;

import org.junit.Test;
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
    /**
     * Метод menuTest   реализован запуск тестирования метода menu.
     * @param enters данные автоввода
     */
    private void menuTest(String[] enters) {
        Input input = new StubInput(enters);
        this.Select = new StartUI(input,this.tracker);
        Select.menu();
    }
    /**
     * Метод initTest  реализован запуск тестирования метода init.
     *  @param enters данные автоввода
     */
    private void initTest(String[] enters) {
        Input input = new StubInput(enters);
        this.Select = new StartUI(input,this.tracker);
        Select.init();
    }

    /**
     * Метод menu воодит данные не тестирует состояние.
     */
   @Test
    public void menu() throws Exception {
        String[] answers = { "1", "problem with PC", "cant open programm", "4", "6", "problem with PC",  "PC name ALPC0012", "7"};
        StubInput stubInput = new StubInput(answers);
        Tracker tracker = new Tracker();
        new StartUI(stubInput, tracker).menu();
    }
    /**
     * Метод TestAddItem тестирует метод menu  на добавление заявки с проверкой состояния.
     */
    @Test
    public void TestAddItem() throws Exception {
        Tracker tracker = new Tracker();
        String[] answers = {"1", "firstTask","descTask1","7"};
        StubInput stubInput = new StubInput(answers);
        new StartUI(stubInput, tracker).menu();
        assertThat(tracker.getAll()[0].getName(), is ("firstTask"));
        assertThat(tracker.getAll()[0].getDescription(), is ("descTask1"));
    }
    /**
     * Метод TestUpdateItem тестирует метод menu  на обновление заявки с проверкой состояния.
     */
    @Test
    public void TestUpdateItem() throws Exception {
        String[] firstAnswers = new String[] {"1", "firstTask", "descTask1", "7"};
        this.menuTest(firstAnswers);
        String[] secondAnswers = new String[] {"2",this.tracker.findByname("firstTask").getId(), "UpdatedTask",
                "descTask1", "ASAP", "7"};
        this.menuTest(secondAnswers);
        assertThat(tracker.getAll()[0].getName(), is ("UpdatedTask"));

    }
    /**
     * Метод TestDeleteItem тестирует метод menu  на удаление заявки с проверкой состояния.
     */
     @Test
     public void TestDeleteItem() throws Exception {
        String[] firstAnswers = new String[] {"1", "firstTask", "descTask1", "7"};
        this.menuTest(firstAnswers);
        String[] secondAnswers = new String[] {"3",this.tracker.findByname("firstTask").getId(),"7"};
        this.menuTest(secondAnswers);

        assertNull(this.tracker.getAll()[0]);
    }
    /**
     * Метод TestShowAllItem тестирует метод menu  на вывод заявок с проверкой состояния.
     */
    @Test
    public void TestShowAllItem() throws Exception {
        String[] firstAnswers = new String[] {"1", "firstTask", "descTask1", "1", "secondTask", "descTask2", "7"};
        this.menuTest(firstAnswers);
        assertThat(tracker.getAll()[0].getName(), is ("firstTask"));
        assertThat(tracker.getAll()[1].getName(), is ("secondTask"));
    }
    /**
     * Метод TestShowAllItem тестирует метод menu  на вывод заявок с проверкой состояния
     */
    @Test
    public void TestShowWithFilter() throws Exception {
        String[] firstAnswers = new String[] {"1", "firstTask", "descTask1", "1", "secondTask", "descTask2", "7"};
        this.menuTest(firstAnswers);
        String[] secondAnswers = new String[] {"5","second","7"};
        this.menuTest(secondAnswers);
        assertThat(tracker.getAll()[1].getName(), is ("secondTask"));
    }
    /**
     * Метод TestAddCommen тестирует метод menu  на добавление коментария с проверкой состояния.
     */
    @Test
    public void TestAddComment() throws Exception {
        String[] firstAnswers = new String[] {"1", "firstTask", "descTask1", "1", "secondTask", "descTask2", "7"};
        this.menuTest(firstAnswers);
        String[] secondAnswers = new String[] {"6","secondTask", "solve ASAP", "7"};
        this.menuTest(secondAnswers);
        assertThat(tracker.findByname("secondTask").getComment(), is ("solve ASAP"));
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
}