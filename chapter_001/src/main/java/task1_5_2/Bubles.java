package task1_5_2;
import java.util.Arrays;
/**
 * Created by Z.Turabayev on 21.11.2016.
 */
public class Bubles {

    public static void main(String args[]){
        Bubles buble = new Bubles();
        int[] massive = {8, 7, 36, 64, 59};
        System.out.println(Arrays.toString(buble.sort(massive)));
    }
    public int[] sort(int[] massive) {
        for(int i=0;i<massive.length-1;i++){
            for(int j=i+1;j<massive.length;j++){
                if(massive[i]>massive[j]){
                    int tmp=massive[i];
                    massive[i]=massive[j];
                    massive[j]=tmp;
                }
            }
        }
        return massive;
    }
}
