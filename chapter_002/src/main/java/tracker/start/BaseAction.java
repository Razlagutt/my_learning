package tracker.start;

/**
 * Created by Z.Turabayev on 22.01.2017.
 * Класс BaseAction абстракнтый класс применяет интерфейс UserAction сождержит общий параметр для всех действий name и
 * общий метод info
 * @author Zaur Turabayev
 * @since 22.01.2017
 * @version 1
 */
public abstract class BaseAction implements UserAction {
    private String name;
    public BaseAction(String name) {
        this.name =name;
    }
    /**
     * абстракный метод  key
     */
    @Override
    public abstract int key();
    /**
     * абстракный метод  execute
     */
    @Override
    public abstract void execute(Input input, Tracker tracker);
    /**
     * имплементация общего метода info
     */
    @Override
    public String info() {
        return String.format("%s. %s", this.key(), this.name);
    }
}
