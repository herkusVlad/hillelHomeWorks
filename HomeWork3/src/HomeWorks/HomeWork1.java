package HomeWorks;

public class HomeWork1  implements HomeWorkManager {
    @Override
    public void run() {
        for (int i=0;i<100;i++){
            if(i % 2 != 0) System.out.println(i);
        }
    }
}
