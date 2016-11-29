package Test_task;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

/**
 * Created by Z.Turabayev on 29.11.2016.
 */
public class SortMassiveTest {
    @Test
    public void addandsort() throws Exception {
        int[] first = new int[]{1, 5, 6, 8,45};
        int[] second = new int[]{3, 10, 16, 18, 95, 110, 130};
        int[] expected = new int []{1, 3, 5, 6, 8, 10, 16, 18, 45, 95, 110, 130};
        SortMassive sortmassive = new SortMassive();
        int[] result =  sortmassive.addandsort(first,second);
        assertThat(expected, equalTo(result));
    }

}