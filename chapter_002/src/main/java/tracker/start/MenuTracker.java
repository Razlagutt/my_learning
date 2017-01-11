package tracker.start;

import tracker.models.Task;
import tracker.models.Item;
/**
 * Created by Z.Turabayev on 10.01.2017.
 */
public class MenuTracker {
    private Input input;
    private Tracker tracker;
    private UserAction[] action =  new UserAction[7];
    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;

    }
    public void fillActions() {
        this.action[0] = this.new AddItem();
        this.action[1]= new MenuTracker.ShowAll();
        this.action[2]= new MenuTracker.DeleteItem();
        this.action[3]= new MenuTracker.UpdateItem();
        this.action[4]= new MenuTracker.FilterItem();
        this.action[5]= new MenuTracker.AddComment();
    }

    public void select( int key) {
        this.action[key].execute(this.input, this.tracker);

    }
    public void show() {
        for (UserAction action: this.action) {
            if (action != null) {
                System.out.println(action.info());
            }
        }

    }

    private class AddItem implements UserAction {
       public  int key() {
           return 0;
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
    private class ShowAll implements UserAction {
        public  int key() {
            return 1;
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
    private class DeleteItem implements UserAction {
        public  int key() {
            return 2;
        }
        public void execute(Input input, Tracker tracker) {
          tracker.delByid(input.ask("Please enter TaksIDtoDelete"));
          System.out.println("Item deleted");
        }
        public String info() {
            return String.format("%s. %s", this.key(), "delete item");
        }
    }
    private class UpdateItem implements UserAction {
        public  int key() {
            return 3;
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
    private class FilterItem implements UserAction {
        public  int key() {
            return 4;
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
    private class AddComment implements UserAction {
        public  int key() {
            return 5;
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
