package TurnMatrix;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

/**
 * Created by Z.Turabayev on 23.11.2016.
 */
public class TurnMatrixTest {
    @Test
    public void turn() throws Exception {

        int[][] matrixA = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        int[][] expected = {
                {7,4,1},
                {8,5,2},
                {9,6,3}
        };

        TurnMatrix turnMatrix = new TurnMatrix();
        assertThat(turnMatrix.turn(matrixA), equalTo(expected));
    }

}