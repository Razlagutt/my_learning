package tracker.start;

/**
 * Interface UserAction определяет интерфейс внутренних классов MenuTracker.
 * @author Zaur Turabayev
 * @since 10.01.2017
 * @version 1
 */
public interface UserAction {
    int key();
    void execute(Input input, Tracker tracker);
    String info();

}




