package HomeWorks;

public class HomeWork2  implements HomeWorkManager {
    @Override
    public void run() {
        int fact = 5;
        int result =1;
        for (int i=1;i<=fact;i++){
            result*=i;
        }
        if(fact <= 0) System.out.println(0);
        System.out.println(result);
    }
}
