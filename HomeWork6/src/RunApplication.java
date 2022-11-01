import Subscriber.*;

public class RunApplication {
    public static void main(String[] args) {
        Subscriber[] subsArr = {
          new Subscriber("Herkus","Vladyslav",3500,45,0,300),
          new Subscriber("Van","Black",450,120,23,100),
          new Subscriber("Bil","Lly",300,0,0,150),
          new Subscriber("Van","Dark",-400,100,50,10),
          new Subscriber("Nani","Omaewa",-100,30,25,100),
        };
        subsArr[0].setCity("Odessa");
        subsArr[1].setCity("Kiev");
        subsArr[2].setCity("Odessa");
        subsArr[3].setCity("Kiev");
        subsArr[4].setCity("Odessa");

        subsArr[0].setThirdName("Konstantinovich");
        subsArr[1].setThirdName("Beer");
        subsArr[2].setThirdName("Herington");
        subsArr[3].setThirdName("Holm");
        subsArr[4].setThirdName("Shindeyru");

        subsArr[1].setPhone("380987624986");
        subsArr[3].setPhone("380677624952");

        SubscriberServiceImpl service = new SubscriberServiceImpl(subsArr);
        System.out.println("Users with exceeded city time (45): ");
        service.exceededCityTime(45);

        System.out.println("\nUsers who use intercity time: ");
        service.whoUseIntercityTime();

        System.out.println("\nUsers who lastname start with: V");
        service.findAllUsersLNameStartWith('V');

        System.out.println("\nGet all internet traffic from Odessa: ");
        service.getAllInternetTrafficFromCity("Odessa");

        System.out.println("\n\nUsers who have negative balance: ");
        service.findAllUsersWithNegativeBalance();
    }
}
