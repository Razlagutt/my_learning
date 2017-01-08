package tracker.start;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Z.Turabayev on 07.01.2017.
 */
public class StartUITest {
    @Test
    public void menu() throws Exception {

        String[] answers = {"Zaurbek", "1", "problem with PC", "cant open programm", "4", "6", "problem with PC",  "PC name ALPC0012", "7"};
        StubInput stubInput = new StubInput(answers);
        new StartUI(stubInput).menu();

    }



}