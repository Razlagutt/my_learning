package tracker.models;

/**
 * Class Item Описание заявки.
 * @author Zaur Turabayev
 * @since 07.12.2016
 * @version 1
 */

/**
 * Description.
 * Class Item Описание заявки.
 */
public class Item {
    /**
     * @param id – description: описывает входящий параметр;
     */
    protected String id;
    /**
     * @param name – description: описывает входящий параметр;
     */
    protected String name;
    /**
     * @param description – description: описывает входящий параметр;
     */
    protected String description;
    /**
     * @param create – description: описывает входящий параметр;
     */
    protected long create;
    /**
     * @param comment – description: описывает входящий параметр;
     */
    protected String comment;
    /**
     * Description.
     * Конструктор Item Описание заявки.
     */
    public Item() {

    }
    /**
     * Description.
     * Конструктор Item Описание заявки.
     * @param name описание
     * @param description описание
     * @param create описание
     * @param comment описание
     */
    public Item(String name, String description, long create, String comment) {
        this.name = name;
        this.description = description;
        this.create = create;
        this.comment = comment;
    }
    /**
     * Description.
     * Метод Item Описание заявки.
     * @return name
     */
    public String getName() {
        return this.name;
    }
    /**
     * Description.
     * Метод Item Описание заявки.
     * @return description
     *
     */
    public String getDescription() {
        return this.description;
    }
    /**
     * Description.
     * Метод Item Описание заявки.
     * @return create
     */
    public long getCreate() {
        return this.create;
    }
    /**
     * Description.
     * Метод Item Описание заявки.
     * @return id
     */
    public String getId() {
        return this.id;
    }
    /**
     * Description.
     * Метод Item Описание заявки.
     * @param  id
     */
    public void setId(String id) {
        this.id = id;
    }
    /**
     * Description.
     * Метод Item Описание заявки.
     */
    public void setComment(String comment) {
        this.comment = comment;
    }
    /**
     * Description.
     * Метод Item Описание заявки.
     * @return comment
     */
    public String  getComment() {
        return this.comment;
    }

}

