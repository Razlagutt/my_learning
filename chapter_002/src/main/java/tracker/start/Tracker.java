package tracker.start;
import tracker.models.*;

import java.util.Random;

/**
 * Class Tracker для работы с заявками
 * @author Zaur Turabayev
 * @since 07.12.2016
 * @version 1
 */


public class Tracker {
    private Item[] items = new Item[10];
    private int position = 0;
    private static final Random RN = new Random();




    protected Item[] getAll() {
        Item[] result = new Item[this.position];
        for (int index = 0; index != this.position; index++) {
            result[index] = items[index];
        }
        return result;
    }


    protected Item add(Item item) {
        Tracker tracker = new Tracker();
        item.setId(String.valueOf(tracker.RN.nextInt()));
        this.items[position++] = item;
        return item;
    }


    protected Item addComment(Item item, String comment) {
        item.setComment(comment);
        return item;
    }


    protected Item findById(String id) {
        Item result = null;
        for (Item item : items) {
            if (item != null && item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }
    protected Item findByname(String name) {
        Item result = null;
        for (Item item : items) {
            if (item != null && item.getName().equals(name)) {
                result = item;
                break;
            }
        }
        return result;
    }
    //записать null при удалении
    protected void delByid(String id) {
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null && id.equals(items[i].getId())) {
                items[i] = null;
                break;
            }

        }

    }
    //
    protected void updateItem(Item newitem) {
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null && newitem.getId().equals(items[i].getId())) {
                items[i] = newitem;
                break;
            }

        }

    }
    protected Item[] filterByName(String name) {
        int count = 0;
        for (Item item:items) {
            if (item != null && item.getName().contains(name)) {
                count++;
            }
        }
        Item[] allitemsfilter = new Item[count];
        count = 0;
        for (Item item:items) {
            if (item != null && item.getName().contains(name)) {
                allitemsfilter[count] = item;
                count++;
            }
        }
        return allitemsfilter;
    }


}