package task1_5_1;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Z.Turabayev on 20.11.2016.
 */
public class TurnTest {
    @Test
    public void back() throws Exception {
        Turn turn = new Turn();
        int[] massive = {1, 2, 3, 4, 6};
        int[] expected = turn.back(massive);
        assertArrayEquals(expected, massive);
    }

}