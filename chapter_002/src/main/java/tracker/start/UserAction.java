package tracker.start;

/**
 * Created by Z.Turabayev on 10.01.2017.
 */
public interface UserAction {
    int key();
    void execute(Input input, Tracker tracker);
    String info();

}




