package HomeWorks;

import java.util.Random;

public class HomeWork12 implements HomeWorkManager {
    @Override
    public void run() {
        int n = 3;
        int [][]arr = new int[n][n];
        int result =0;
        int pow = n*n;
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                arr[i][j] = new Random().nextInt(10);
                result+=arr[i][j];
            }
        }
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println((double) result/pow);
    }
}
