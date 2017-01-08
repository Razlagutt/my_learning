package tracker.start;

/**
 * Created by Z.Turabayev on 05.01.2017.
 */
public class StubInput implements Input {
    private String[] answers;
    private int positions = 0;
    public StubInput(String[] answers) {
        this.answers = answers;
    }
    public String ask(String question) {
        return answers[positions++];
    }
}

