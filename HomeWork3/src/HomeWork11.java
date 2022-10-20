public class HomeWork11 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, -5, 3, 10};
        int minIndex = 0;
        int maxIndex = 0;
        for (int i = 0, minValue = arr[0], maxValue = arr[0]; i < arr.length; i++) {
            if (minValue > arr[i]) {
                minIndex = i;
            }
            if (maxValue < arr[i]) {
                maxIndex = i;
            }
        }
        int tmpValue =arr[minIndex];
        arr[minIndex] = arr[maxIndex];
        arr[maxIndex] = tmpValue;

        for (int i: arr) {
            System.out.print(i+" ");
        }
    }
}
