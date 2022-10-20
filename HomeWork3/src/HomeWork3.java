public class HomeWork3 {
    public static void main(String[] args) {
        int i=0;
        while(i<100){
            if(i % 2 != 0) System.out.println(i);
            i++;
        }
        i=1;

        int fact = 5;
        int result =1;

        System.out.println("Factorial:");
        while(i<=fact){
            result*=i;
            i++;
        }
        if(fact <= 0) System.out.println(0);
        System.out.println(result);
    }
}
