package square_1_4_1;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Z.Turabayev on 20.11.2016.
 */
public class SquareTest {
    @Test
    public void calculate() throws Exception {
        Square square = new Square(2, 2, 3);
        Assert.assertEquals(7,square.calculate(1), 0);
    }

}