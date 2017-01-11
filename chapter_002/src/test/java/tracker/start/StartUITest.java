package tracker.start;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Z.Turabayev on 07.01.2017.
 */
public class StartUITest {
    @Test
    public void init() throws Exception {
        String[] answers = {"0", "problem with PC", "cant open programm", "n", "1", "n", "4", "problem with PC", "n", "5",
                "problem with PC", "PLS solve ASAP" , "n", "1", "y"};
        StubInput stubInput = new StubInput(answers);
        new StartUI(stubInput).init();
    }

  /* @Test
    public void menu() throws Exception {

        String[] answers = {"Zaurbek", "1", "problem with PC", "cant open programm", "4", "6", "problem with PC",  "PC name ALPC0012", "7"};
        StubInput stubInput = new StubInput(answers);
        new StartUI(stubInput).menu();

    } */



}