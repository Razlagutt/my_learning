package task1_4_3;

/**
 * Created by Z.Turabayev on 20.11.2016.
 */
public class Paint {


    public static void main(String args[]){
        Paint paint = new Paint();
        paint.piramid(3);

    }
    public int piramid(int h){
        StringBuffer sBuffer = new StringBuffer();

            for(int i=0;i<h;i++){
                sBuffer.append("\n");
            int a=(h-1)-i;
            for(int b=a;b>0;b--){
                sBuffer.append(" ");
            }
            int c=(i*2)+1;
            for(int d=c;d>0;d--){
                sBuffer.append("^");
            }
            for(int b=a;b>0;b--){
                sBuffer.append(" ");
            }


               // System.out.println(sBuffer);
                //System.out.println( sBuffer.toString());
               // System.out.println("\n");
            }
        System.out.println( sBuffer.toString());

    return 0;
    }



}
