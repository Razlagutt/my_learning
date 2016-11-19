package task1_4_2;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Z.Turabayev on 20.11.2016.
 */
public class FactTest {
    @Test
    public void calculate() throws Exception {
        Fact fact = new Fact(5);
        Assert.assertEquals(120,fact.calculate(5), 0);
    }

}