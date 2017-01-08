package tracker.start;

/**
 * Created by Z.Turabayev on 05.01.2017.
 */
public class StartUItest {
    public static void main(String[] args) {
        Input input =  new StubInput(new String[] {"create stub task"});
        new StartUI(input).init();
    }


}
