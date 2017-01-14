package tracker.start;
import tracker.models.*;
/**
 * Class StartUI класс реализующий запуск  меню пользователя.
 * @author Zaur Turabayev
 * @since 04.01.2016
 * @version 1
 */
public class StartUI {
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
        do {
            menu.show();
            int key = Integer.valueOf(input.ask("Select:"));
            menu.select(key);
        } while (!"y".equals(this.input.ask("Exit? Y")));
    }
    /**
     * Метод menu запускает меню без класса MenuTracker.
     */
    public void menu() {


        int action = 0;
        String choice = "0";
        while (action != 7) {

            System.out.println("Main Menu");
            System.out.println("1. Create  new Task");
            System.out.println("2. Update Task");
            System.out.println("3. Delete Task");
            System.out.println("4. Show All");
            System.out.println("5. Show with filter");
            System.out.println("6. Add comment");
            System.out.println("7. Exit");
            choice = input.ask("Please enter action number");
            if (choice.equals("1")) {
                action = 1;
                String name = input.ask("Please enter TaksName");
                String description = input.ask("Please enter TaksDescription");
                tracker.add(new Task(name, description, ""));
            } else if (choice.equals("2")) {
                action = 2;
                String id = input.ask("Please enter TaksId you want update");
                String name = input.ask("Please enter TaksName");
                String description = input.ask("Please enter TaksDescription");
                String commnet = input.ask("Please enter Takscomment");
                Item newItem = new Item(name, description, 22, commnet);
                newItem.setId(id);
                tracker.updateItem(newItem);

            } else if (choice.equals("3")) {
                action = 3;
                String id = input.ask("Please enter TaksId you want delete");
                tracker.delByid(id);

            } else if (choice.equals("4")) {
                action = 4;
                for (Item item : tracker.getAll()) {
                    System.out.println("Task id: " + item.getId() + "Task name: " + item.getName() + "Task description: " + item.getDescription() + "Task comment: " + item.getComment());
                }
            } else if (choice.equals("5")) {
                action = 5;
                String name = input.ask("Please enter TaksName you want find");
                for (Item item : tracker.filterByName(name)) {
                    System.out.println("Task id: " + item.getId() + "Task name: " + item.getName() + "Task description: " + item.getDescription() + "Task comment: " + item.getComment());
                }
            } else if (choice.equals("6")) {
                action = 6;
                String name = input.ask("Please enter TaksName you want to add comment");
                String commnet = input.ask("Please enter commnet you want to add");
                Item geted = tracker.findByname(name);
                tracker.addComment(geted, commnet);

            } else if (choice.equals("7")) {
                action = 7;


            }

        }


    }
    /**
     * Метод main  главный метод.
     */

    public static void main(String[] args) {
        //Input input =  new StubInput(new String[] {"create stub task"});
        ConsoleInput input = new ConsoleInput();
        Tracker tracker = new Tracker();
        //new StartUI(input, tracker).menu();
        new StartUI(input, tracker).init();
    }
}