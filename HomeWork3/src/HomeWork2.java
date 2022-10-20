public class HomeWork2 {
    public static void main(String[] args) {
        int fact = 5;
        int result =1;
        for (int i=1;i<=fact;i++){
            result*=i;
        }
        if(fact <= 0) System.out.println(0);
        System.out.println(result);
    }
}
