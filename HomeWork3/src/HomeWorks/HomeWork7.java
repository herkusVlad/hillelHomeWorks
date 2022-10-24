package HomeWorks;

public class HomeWork7 implements HomeWorkManager {

    @Override
    public void run() {
        double x = 5;

        System.out.println("┌------------------------------------------┐");
        double[] arr = new double[3];
        for (int i = 1, j = 0; i < 11; i++, j++) {
            arr[0] = x;
            arr[1] = i;
            arr[2] = x * i;

            System.out.printf("\t%s\t\t*\t%s\t\t=\t%s\t\t\n", arr[0], arr[1], arr[2]);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (i != 10) {
                System.out.print("├------------------------------------------┤\n");
            }
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("└------------------------------------------┘");
    }
}
