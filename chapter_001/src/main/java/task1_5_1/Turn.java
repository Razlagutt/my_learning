package task1_5_1;

/**
 * Created by Z.Turabayev on 20.11.2016.
 */
public class Turn {
    public static void main(String args[]){
        Turn turn = new Turn();
        int[] massive = {1, 2, 3, 4, 5};
        turn.back(massive);

    }

    public int[] back(int[] massive) {
        for (int i = 0; i < massive.length / 2; i++) {
            int tmp = massive[i];
            massive[i] = massive[massive.length - i - 1];
            massive[massive.length - i - 1] = tmp;
        }
        return massive;
    }

}
