package tracker.start;

import tracker.models.Task;
import tracker.models.Item;
/**
 * Class StartUI класс реализующий меню пользователя.
 * @author Zaur Turabayev
 * @since 10.01.2017
 * @version 1
 */
public class MenuTracker {
    /**
     * input объект ввода пользователя.
     */
    private Input input;
    /**
     * tracker объект для работы с заявками.
     */
    private Tracker tracker;
    /**
     *  action объект для выбора  действия.
     */
    private UserAction[] action =  new UserAction[7];
    /**
     * Description.
     * Конструктор  меню.
     * @param input объект ввода пользователя
     * @param tracker объект для работы с заявками
     */
    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;

    }
    /**
     * Метод fillActions  расперделяет внутрение классы по ячейкам массива action.
     */
    public void fillActions() {
        this.action[1] = this.new AddItem();
        this.action[2] = new MenuTracker.UpdateItem();
        this.action[3] = new MenuTracker.DeleteItem();
        this.action[4] = new MenuTracker.ShowAll();
        this.action[5] = new MenuTracker.FilterItem();
        this.action[6] = new MenuTracker.AddComment();
    }
    /**
     * Метод  select при выборе ключа в меню запускает на выполнение выбранной задачи.
     * пользователь выбирает в меню номер, номер попадает в параметр key,  и запускется метод execute
     * одного из внутренниз классов
     */
    public void select( int key) {
        this.action[key].execute(this.input, this.tracker);

    }
    /**
     * Метод  show вызывает метод info каждого внутренноего класса
     * для показа меню
     */
    public void show() {
        for (UserAction action: this.action) {
            if (action != null) {
                System.out.println(action.info());
            }
        }

    }
    /**
     * Class AddItem внутренний класс реализующий добавление заявки.
     * применяет интерфейс  UserAction
     * @author Zaur Turabayev
     * @since 10.01.2017
     * @version 1
     */
    private class AddItem implements UserAction {
       public  int key() {
           return 1;
       }
       public void execute(Input input, Tracker tracker) {
           String name = input.ask("Please enter TaksName");
           String description = input.ask("Please enter TaksDescription");
           tracker.add(new Task(name, description, ""));
       }
       public String info() {
          return String.format("%s. %s", this.key(), "add new item");
       }
    }
    /**
     * Class ShowAll внутренний класс реализующий вывод всех заявок.
     * применяет интерфейс  UserAction
     * @author Zaur Turabayev
     * @since 10.01.2017
     * @version 1
     */
    private class ShowAll implements UserAction {
        public  int key() {
            return 4;
        }
        public void execute(Input input, Tracker tracker) {
            for (Item item : tracker.getAll()) {
                if (item != null) {
                    System.out.println(String.format("%s. %s. %s. %s", item.getId(), item.getName(), item.getDescription(), item.getComment()));
                }
            }
        }
        public String info() {
            return String.format("%s. %s", this.key(), "show all items");
        }
    }
    /**
     * Class DeleteItem внутренний класс реализующий удаление заявки.
     * применяет интерфейс  UserAction
     * @author Zaur Turabayev
     * @since 10.01.2017
     * @version 1
     */
    private class DeleteItem implements UserAction {
        public  int key() {
            return 3;
        }
        public void execute(Input input, Tracker tracker) {
          tracker.delByid(input.ask("Please enter TaksIDtoDelete"));
          System.out.println("Item deleted");
        }
        public String info() {
            return String.format("%s. %s", this.key(), "delete item");
        }
    }
    /**
     * Class UpdateItem внутренний класс реализующий корректировку заявки.
     * применяет интерфейс  UserAction
     * @author Zaur Turabayev
     * @since 10.01.2017
     * @version 1
     */
    private class UpdateItem implements UserAction {
        public  int key() {
            return 2;
        }
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Please enter TaksId you want update");
            String name = input.ask("Please enter TaksName");
            String description = input.ask("Please enter TaksDescription");
            String commnet = input.ask("Please enter Takscomment");
            Item newItem = new Item(name, description, 22, commnet);
            newItem.setId(id);
            tracker.updateItem(newItem);
        }
        public String info() {
            return String.format("%s. %s", this.key(), "update item");
        }
    }
    /**
     * Class FilerItem внутренний класс реализующий поиск заявки.
     * применяет интерфейс  UserAction
     * @author Zaur Turabayev
     * @since 10.01.2017
     * @version 1
     */
    private class FilterItem implements UserAction {
        public  int key() {
            return 5;
        }
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Please enter TaksName you want find");
            for (Item item : tracker.filterByName(name)) {
                System.out.println(String.format("%s. %s. %s. %s", item.getId(), item.getName(), item.getDescription(), item.getComment()));
            }
        }
        public String info() {
            return String.format("%s. %s", this.key(), "find item");
        }
    }
    /**
     * Class AddComment внутренний класс реализующий добавление коментария к заявке.
     * применяет интерфейс  UserAction
     * @author Zaur Turabayev
     * @since 10.01.2017
     * @version 1
     */
    private class AddComment implements UserAction {
        public  int key() {
            return 6;
        }
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Please enter TaksName you want to add comment");
            String commnet = input.ask("Please enter commnet you want to add");
            Item geted = tracker.findByname(name);
            tracker.addComment(geted,commnet);
        }
        public String info() {
            return String.format("%s. %s", this.key(), "add comment");
        }
    }
}
