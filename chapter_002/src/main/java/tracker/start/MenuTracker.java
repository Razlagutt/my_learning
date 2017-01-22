package tracker.start;

import tracker.models.Task;
import tracker.models.Item;

import javax.jws.soap.SOAPBinding;


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
    private int position = 0;
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
        this.action[1] = this.new AddItem("add item");
        this.action[2] = new MenuTracker.UpdateItem("update item");
        this.action[3] = new MenuTracker.DeleteItem("delete item");
        this.action[4] = new MenuTracker.ShowAll("show all");
        this.action[5] = new MenuTracker.FilterItem("find item");
        this.action[6] = new MenuTracker.AddComment("add comment");
    }
    public void addAction(UserAction action) {
        this.action[position++] = action;

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
     * Метод  getRange получает в массиве значения которые может выбрать пользователь для
     * дальнейщей валидации
     */
    public int[] getRange() {
        int i = 0;
        int [] temp = new int[20];
        for (UserAction action: this.action) {
            if (action != null) {
              temp[i] = Integer.valueOf(action.key());
              i++;
            }
        }
        int [] range = new int[i++];
        int j = 0;
        int k;
        for (k = 0; k < temp.length; k++) {
            if (temp[k] != 0) {
                range[j] = temp[k];
                j++;
            }
        }
        return range;
    }
    /**
     * Class AddItem внутренний класс реализующий добавление заявки.
     * применяет интерфейс  UserAction
     * @author Zaur Turabayev
     * @since 10.01.2017
     * @version 1
     */
    private class AddItem extends BaseAction {
        public AddItem(String name) {
            super(name);
        }

        public  int key() {
           return 1;
       }
       public void execute(Input input, Tracker tracker) {
           String name = input.ask("Please enter TaksName");
           String description = input.ask("Please enter TaksDescription");
           tracker.add(new Task(name, description, ""));
       }

    }
    /**
     * Class ShowAll внутренний класс реализующий вывод всех заявок.
     * применяет интерфейс  UserAction
     * @author Zaur Turabayev
     * @since 10.01.2017
     * @version 1
     */
    private class ShowAll extends BaseAction {
        public ShowAll(String name) {
            super(name);
        }

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

    }
    /**
     * Class DeleteItem внутренний класс реализующий удаление заявки.
     * применяет интерфейс  UserAction
     * @author Zaur Turabayev
     * @since 10.01.2017
     * @version 1
     */
    private class DeleteItem extends BaseAction {
        public DeleteItem(String name) {
            super(name);
        }

        public  int key() {
            return 3;
        }
        public void execute(Input input, Tracker tracker) {
          tracker.delByid(input.ask("Please enter TaksIDtoDelete"));
          System.out.println("Item deleted");
        }

    }
    /**
     * Class UpdateItem внутренний класс реализующий корректировку заявки.
     * применяет интерфейс  UserAction
     * @author Zaur Turabayev
     * @since 10.01.2017
     * @version 1
     */
    private class UpdateItem extends BaseAction {
        public UpdateItem(String name) {
            super(name);
        }

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

    }
    /**
     * Class FilerItem внутренний класс реализующий поиск заявки.
     * применяет интерфейс  UserAction
     * @author Zaur Turabayev
     * @since 10.01.2017
     * @version 1
     */
    private class FilterItem extends BaseAction {
        public FilterItem(String name) {
            super(name);
        }

        public  int key() {
            return 5;
        }
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Please enter TaksName you want find");
            for (Item item : tracker.filterByName(name)) {
                System.out.println(String.format("%s. %s. %s. %s", item.getId(), item.getName(), item.getDescription(), item.getComment()));
            }
        }

    }
    /**
     * Class AddComment внутренний класс реализующий добавление коментария к заявке.
     * применяет интерфейс  UserAction
     * @author Zaur Turabayev
     * @since 10.01.2017
     * @version 1
     */
    private class AddComment extends BaseAction {
        public AddComment(String name) {
            super(name);
        }

        public  int key() {
            return 6;
        }
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Please enter TaksName you want to add comment");
            String commnet = input.ask("Please enter commnet you want to add");
            Item geted = tracker.findByname(name);
            tracker.addComment(geted,commnet);
        }

    }
}
