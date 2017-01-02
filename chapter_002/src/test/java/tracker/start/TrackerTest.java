package tracker.start;

import tracker.models.Item;
import tracker.models.Task;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;

/**
 * Created by Z.Turabayev on 12.12.2016.
 */
public class TrackerTest {
    @Test
    public void filterByName() throws Exception {
        Tracker tracker = new Tracker();
        Task task1 = new Task("1stname", "1stDescription", "1stcoment");
        Task task2 = new Task("2ndname", "2ndDescription", "2ndcomment");
        Task task3 = new Task("3rdname", "3rdDescription", "3rdcoment");
        tracker.add(task1);
        tracker.add(task2);
        tracker.add(task3);
        Item[] items = new Item[10];
        items = tracker.getAll();
        Item[] newitem = new Item[10];
        newitem = tracker.filterByName("name");
        int i = 0;
        for (Item item: tracker.getAll()) {
                   Assert.assertThat(newitem[i], equalTo(items[i]));
        }
    }



    @Test
    public void updateItem() throws Exception {
        Tracker tracker = new Tracker();
        Task task1 = new Task("1stname", "1stDescription", "1stcoment");
        Task task2 = new Task("2ndname", "2ndDescription", "2ndcomment");
        Task task3 = new Task("3rdname", "3rdDescription", "3rdcoment");
        tracker.add(task1);
        tracker.add(task2);
        tracker.add(task3);
        Item newItem = new Item("NewName_2ndTask",
                "2rdDescription", 22, "new_commentrdcoment");
        for (Item item: tracker.getAll()) {
            if (item.getName() == "2ndname") {
                newItem.setId(item.getId());
            }
        }
        tracker.updateItem(newItem);
        int i =0;
        for (Item item: tracker.getAll()) {
          if (i == 1) {
              Assert.assertThat(newItem, equalTo(task2));
          }
        }

    }

    @Test
    public void findById() throws Exception {

    }

    @Test
    public void delByname() throws Exception {
        Tracker tracker = new Tracker();
        Task task1 = new Task("1stname", "1stDescription", "1stcoment");
        Task task2 = new Task("2ndname", "2ndDescription", "2ndcomment");
        Task task3 = new Task("3rdname", "3rdDescription", "3rdcoment");
        tracker.add(task1);
        tracker.add(task2);
        tracker.add(task3);
        tracker.delByname("2ndname");
        if (task2 == null) {
            System.out.print("Item deleted");
        }
    }

    @Test
    public void findByname() throws Exception {
        Tracker tracker = new Tracker();
        Task task1 = new Task("1stname", "1stDescription", "1stcoment");
        Task task2 = new Task("2ndname", "2ndDescription", "2ndcomment");
        Task task3 = new Task("3rdname", "3rdDescription", "3rdcoment");
        tracker.add(task1);
        tracker.add(task2);
        tracker.add(task3);
       Item geted = tracker.findByname("3rdname");
        Assert.assertThat(geted, equalTo(task3));

    }

    @Test
    public void getAll() throws Exception {
        Tracker tracker = new Tracker();
        Task task1 = new Task("1stname", "1stDescription", "1stcoment");
        Task task2 = new Task("2ndname", "2ndDescription", "2ndcomment");
        Task task3 = new Task("3rdname", "3rdDescription", "3rdcoment");
        tracker.add(task1);
        tracker.add(task2);
        tracker.add(task3);
        Item[] geted = tracker.getAll();
        int i = 0;
        for (Item item : tracker.getAll()) {
            Assert.assertThat(geted[i],equalTo(item));
            i++;
        }



    }

    @org.junit.Test
    public void add() throws Exception {
        Tracker tracker = new Tracker();

        Task task1 = new Task("1stname", "1stDescription", "1stcoment");
        Task task2 = new Task("2ndname", "2ndDescription", "2ndcomment");
        Task task3 = new Task("3rdname", "3rdDescription", "3rdcoment");
        tracker.add(task1);
        tracker.add(task2);
        tracker.add(task3);
        boolean[] result ={false, true, false};
        boolean[] geted = new boolean[3];
        int i = 0;
        for (Item item : tracker.getAll()) {
            geted[i] = (item.equals(task2));
            i++;
        }
        Assert.assertThat(geted, equalTo(result));


    }


}