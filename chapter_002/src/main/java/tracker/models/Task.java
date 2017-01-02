package tracker.models;

/**
 * Class Task Описание заявки.
 * @author Zaur Turabayev
 * @since 07.12.2016
 * @version 1
 */
public class Task extends Item {


    public Task(String name, String desc, String comment) {
        this.name = name;
        this.description = desc;
        this.comment = comment;
    }



}
