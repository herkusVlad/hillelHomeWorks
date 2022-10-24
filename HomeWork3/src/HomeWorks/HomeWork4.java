package HomeWorks;

public class HomeWork4 implements HomeWorkManager {

    @Override
    public void run() {
        int i=0;
        do{
            if(i % 2 != 0) System.out.println(i);
            i++;
        }while (i<100);

        i=1;
        int fact = 5;
        int result =1;

        System.out.println("Factorial:");
        do{
            result*=i;
            i++;
        } while(i<=fact);

        if(fact <= 0) System.out.println(0);
        System.out.println(result);
    }
}
