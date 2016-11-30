package task1_4_3;

/**
 * Created by Z.Turabayev on 22.11.2016.
 */
public class Paint {


    public String piramid(int h) {
        StringBuilder sbuilder = new StringBuilder();
        for (int i = 0; i < h; i++) {
            //sbuilder.append("\n");
            int a = (h - 1) - i;
            for (int b = a; b > 0; b--) {
                sbuilder.append(" ");
            }
            int c = (i * 2) + 1;
            for (int d = c; d > 0; d--) {
                sbuilder.append("^");
            }
            for (int b = a; b > 0; b--) {
                sbuilder.append(" ");
            }
            sbuilder.append("\n");
        }

        String finalString = sbuilder.toString();
        return finalString;
    }
}

