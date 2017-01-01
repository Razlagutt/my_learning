package Task_2_2_1.start;
import Task_2_2_1.models.*;

import java.util.*;

/**
 * Created by Z.Turabayev on 07.12.2016.
 */
public class Tracker {
    private Item [] items = new Item[10];
    private int position = 0;
    private static final Random RN = new Random();

    public  static void main (String [] args){
        Tracker tracker = new Tracker();




        tracker.add(new Task("firstTask", "description1", "123"));
        tracker.add(new Task("secondTask", "description2", "123 "));
        tracker.add(new Task("ThirdItem", "description3", "1212"));


        for (Item item : tracker.getAll()){
            System.out.println(item.getName()+ " " + item.getDescription()+ " "+ item.getId()+" "+ item.getComment());

        }
        System.out.println("//////////////////////////");
        for (Item item : tracker.filterByName("Item")){
            System.out.println(item.getName()+ " " + item.getDescription()+ " "+ item.getId()+" "+ item.getComment());

        }

        tracker.delByname("ThirdItem");
        System.out.println("/////////////////////////23/");
        for (Item item : tracker.getAll()){
           tracker.addComment(item, "sdsd");
            System.out.println(item.getName()+ " " + item.getDescription()+ " "+ item.getId()+" "+ item.getComment());

        }






}
    protected Item[] getAll(){
        Item[] result = new Item[this.position];
        for (int index =0; index!= this.position; index++){
            result[index] = items[index];
        }
        return result;
    }


    protected Item add(Item item) {
        item.setId(String.valueOf(RN.nextInt()));
        this.items[position++] = item;
        return item;
    }


    protected Item addComment( Item item, String comment) {
        item.setComment(comment);
        return item;
    }


    protected Item findById( String id ) {
        Item result =null;
        for (Item item : items){
            if(item != null && item.getId().equals(id)){
                result = item;
                break;
            }
        }
        return result;
    }
    protected Item findByname( String name ) {
        Item result =null;
        for (Item item : items){
            if(item != null && item.getName().equals(name)){
                result = item;
                break;
            }
        }
        return result;
    }
    //записать null при удалении
    protected void delByname( String name ) {
       for (int i= 0; i<items.length; i++){
            if(items[i] != null && name.equals(items[i].getName())){
                items[i] = null;
                break;
            }
        }

    }
    //
    protected void updateItem( Item newItem) {
        for (int i= 0; i<items.length; i++){
            if(items[i] != null&& newItem.getId().equals(items[i].getId())){
                items[i] = newItem;
                break;
            }
        }

    }
    protected Item[] filterByName(String name){
        int count = 0;
        for (Item item:items){
            if (item !=null && item.getName().contains(name)){
                count++;
            }
        }
        Item[] allitemsfilter = new Item[count];
        count = 0;
        for (Item item:items){
            if (item !=null && item.getName().contains(name)){
                allitemsfilter[count]=item;
                count++;
            }
        }
        return allitemsfilter;
    }


}
