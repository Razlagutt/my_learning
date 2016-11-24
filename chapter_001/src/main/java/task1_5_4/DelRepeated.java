package task1_5_4;

import java.util.Arrays;

/**
 * Created by Z.Turabayev on 23.11.2016.
 */
public class DelRepeated {



    public int [] delRepeated (int []  massive ){
        int [] temp = new int[massive.length];
        int nlenth = 0;
        int j = 0;
        int k = 0;
        for (int i =0; i<massive.length-1; i++){
            k++;
            if (massive[i] != massive[k]){
                temp[j] = massive[i];
                nlenth++;
                j++;
            }
            if((i == (massive.length -2))) {
                temp[j] = massive[i+1];
                nlenth++;

            }


        }
       return Arrays.copyOf(temp,nlenth);

    }
}



