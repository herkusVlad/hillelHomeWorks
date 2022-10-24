package HomeWorks;

import java.util.Random;

public class HomeWork10 implements HomeWorkManager {
    @Override
    public void run() {
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
        int max = arr[0][0];
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                if(max == arr[i][j]){
                    counterRepeat++;
                }
                if(max < arr[i][j]){
                    max= arr[i][j];
                    counterRepeat=0;
                }
            }
        }

        System.out.println("\nMax value: ");
        for (int i=-1;i<counterRepeat;i++){
            System.out.print(max+" ");
        }
    }
}
