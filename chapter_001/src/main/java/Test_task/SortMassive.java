package Test_task;



/**
 * Created by Z.Turabayev on 29.11.2016.
 */
public class SortMassive {



    public int [] addandsort (int [] first, int[] second){
        int [] result = new int[(first.length + second.length)];
        int i = 0;
        int j = 0;
        int k = 0;
        while (( i < first.length)&&( j < second.length)){

            if (first[i] < second[j]){
            result[k]= first[i];
                k++;
                i++;
            }
            else {
            result[k]= second[j];
                k++;
                j++;
            }

        }
        while (i< first.length){
            result[k] = first[i];
            k++;
            i++;
        }
        while (j< second.length){
            result[k] = second[j];
            k++;
            j++;
        }
        return result;
    }

}
