import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HomeWork9 {
    public static void main(String[] args) {
        int n = 5;
        int [][]arr = new int[5][5];
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                arr[i][j] = new Random().nextInt(10);
            }
        }
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        int counterRepeat = 0;
        int min = arr[0][0];
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
               if(min == arr[i][j]){
                    counterRepeat++;
               }
               if(min > arr[i][j]){
                   min= arr[i][j];
                   counterRepeat=0;
               }
            }
        }

        System.out.println("\nMin value: ");
        for (int i=-1;i<counterRepeat;i++){
            System.out.print(min+" ");
        }
    }
}
