package task1_5_2;

import com.sun.org.apache.xpath.internal.operations.Equals;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;
import static org.junit.matchers.JUnitMatchers.*;
/**
 * Created by Z.Turabayev on 21.11.2016.
 */
public class BublesTest {
    @Test
    public void sort() throws Exception {
            Bubles buble = new Bubles();
            int[] massive = {8, 7, 36, 64, 59};
            int[] result = buble.sort(massive);
            int[] expected = {7, 8, 36, 59, 64};
        assertThat(expected, equalTo(massive));
        }

    }

