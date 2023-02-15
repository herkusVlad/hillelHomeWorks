import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int []arr = {1,2,3,4,5,6,9};

        boolean found = Arrays.stream(arr)
                .mapToObj(e-> e + "")
                .anyMatch(e-> e.contains("7"));
        System.out.println( found ? "found" : "not found");
        digitSum(99892);
    }

    private static int digitSum(int number){
        String []arr = String.valueOf(number).split("");
        int sum= Arrays.stream(arr)
                .map(Integer::parseInt)
                .mapToInt(e->e)
                .sum();
        System.out.println(sum);
        if(sum>=10){
            sum = digitSum(sum);
        }

        return sum;
    }
}
