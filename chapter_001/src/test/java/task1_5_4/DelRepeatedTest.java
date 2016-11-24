package task1_5_4;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

/**
 * Created by Z.Turabayev on 24.11.2016.
 */
public class DelRepeatedTest {
    @Test
    public void delRepeated() throws Exception {
        DelRepeated dRepeated = new DelRepeated();
        int[] numbers = {1, 1, 3, 3, 3, 6, 8, 8, 8};
        int [] expected  = {1, 3, 6, 8};
        assertThat( dRepeated.delRepeated(numbers), equalTo(expected));
    }

}