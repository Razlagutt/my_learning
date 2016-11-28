package Test_task_for_ch1;

import java.util.Arrays;

/**
 * Created by Z.Turabayev on 25.11.2016.
 */
public class CheckContain {

    public static void main (String [] args){
        CheckContain check = new CheckContain();
        String first = "echo123";
        String second = "echo";

        System.out.println(check.contains(first, second));

    }

    public boolean contains(String origin, String sub) {
        String[] arrOrigin = origin.split("");
        System.out.println(Arrays.toString(arrOrigin));
        String[] arrSub = sub.split("");
        System.out.println(Arrays.toString(arrSub));

        int equals = 0;
        boolean result = false;
        if (arrOrigin.length >= arrSub.length) {
            for (int i = 0; i < arrSub.length; i++)
                for (int j = 0; j < arrOrigin.length; j++)
                    if (arrOrigin[j].equals(arrSub[i])) {
                        System.out.println(arrSub[i]);
                        equals++;
                    }

            System.out.println(equals);
            System.out.println(arrSub.length);
            if (equals == arrSub.length) {
                result = true;
            }
        }
        return result;
    }
}
