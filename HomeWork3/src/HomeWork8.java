import java.util.Arrays;

public class HomeWork8 {
    public static void main(String[] args) {
        int[] arr = new int[10];
        for (int i=1, j =0; j<10; i++){
            if(i % 2 != 0){
                arr[j++]=i;
            }
        }
        for(int i : arr){
            if(arr[arr.length-1] == i){
                System.out.print(i);
            }else{
                System.out.print(i +", ");
            }
        }
    }
}
