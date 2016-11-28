package Test_task_for_ch1;

import java.util.Arrays;

/**
 * Created by Z.Turabayev on 25.11.2016.
 */
public class CheckContain {



    public boolean contains(String origin, String sub) {
        String[] arrOrigin = origin.split("");
        String[] arrSub = sub.split("");
        int equals = 0;
        boolean result = false;
        if (arrOrigin.length >= arrSub.length) {
            for (int i = 0; i < arrSub.length; i++)
                for (int j = 0; j < arrOrigin.length; j++)
                    if (arrOrigin[j].equals(arrSub[i])) {
                        equals++;
                    }

            if (equals == arrSub.length) {
                result = true;
            }
        }
        return result;
    }
}
