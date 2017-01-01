package Task_2_2_1.models;

/**
 * Created by Z.Turabayev on 07.12.2016.
 */
public class Item {
    private String id;
    public  String name;
    public  String description;
    public  long create;
    public String comment;

    public Item(){

    }

    public Item ( String name, String description, long create, String comment){
        this.name = name;
        this.description = description;
        this.create = create;
        this.comment = comment;
    }
    public String getName(){
        return this.name;
    }
    public String getDescription(){
        return this.description;
    }
    public long getCreate(){
        return this.create;
    }
    public String getId() {
        return this.id;
    }
    public void setId(String id){
        this.id = id;
    }
    public void setComment(String comment){
        this.comment = comment;
    }
    public String  getComment(){
        return this.comment;
    }

}

