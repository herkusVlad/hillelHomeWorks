package HomeWorks;

public class HomeWork5 implements HomeWorkManager {
    @Override
    public void run() {
        int x = 10;
        int n = 5;
        int result = 1;
        for (int i=0;i<n;i++){
            result*= x;
        }
        System.out.println(result);
    }
}
