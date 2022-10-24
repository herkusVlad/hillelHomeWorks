import HomeWorks.*;

public class HomeWorkFactory {
    private HomeWorkManager homeWorkManager;

    public void getHomeWork(int numberHomeWork){
        switch (numberHomeWork){
            case 1:
                homeWorkManager = new HomeWork1();
                homeWorkManager.run();
                break;
            case 2:
                homeWorkManager = new HomeWork2();
                homeWorkManager.run();
                break;
            case 3:
                homeWorkManager = new HomeWork3();
                homeWorkManager.run();
                break;
            case 4:
                homeWorkManager = new HomeWork4();
                homeWorkManager.run();
                break;
            case 5:
                homeWorkManager = new HomeWork5();
                homeWorkManager.run();
                break;
            case 6:
                homeWorkManager = new HomeWork6();
                homeWorkManager.run();
                break;
            case 7:
                homeWorkManager = new HomeWork7();
                homeWorkManager.run();
                break;
            case 8:
                homeWorkManager = new HomeWork8();
                homeWorkManager.run();
                break;
            case 9:
                homeWorkManager = new HomeWork9();
                homeWorkManager.run();
                break;
            case 10:
                homeWorkManager = new HomeWork10();
                homeWorkManager.run();
                break;
            case 11:
                homeWorkManager = new HomeWork11();
                homeWorkManager.run();
                break;
            case 12:
                homeWorkManager = new HomeWork12();
                homeWorkManager.run();
                break;
            case 13:
                homeWorkManager = new HomeWork13();
                homeWorkManager.run();
                break;
        }
    }
}
