package task1_4_3;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.equalTo;
/**
 * Created by Z.Turabayev on 23.11.2016.
 */
public class PaintTest {
    @Test
    public void piramid() throws Exception {
        Paint paint = new Paint();
         String expectedString = "  ^  \n ^^^ \n^^^^^\n";

        Assert.assertThat(expectedString, equalTo(paint.piramid(3)) );
    }

}