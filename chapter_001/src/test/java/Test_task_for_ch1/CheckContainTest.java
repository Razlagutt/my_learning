package Test_task_for_ch1;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Z.Turabayev on 28.11.2016.
 */
public class CheckContainTest {
    @Test
    public void contains() throws Exception {


        CheckContain check = new CheckContain();
        String first = "echo123";
        String second = "echo";
        if (check.contains(first, second))
            System.out.println("it is a substring");
        else System.out.println("it is not a substring");
    }

}