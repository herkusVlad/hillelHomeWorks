package Subscriber;

import Subscriber.Subscriber;

import java.util.Locale;

public class SubscriberServiceImpl implements SubscriberService {

    private Subscriber[] subsArr;

    public SubscriberServiceImpl(Subscriber[] subsArr){
        this.subsArr = subsArr;
    }

    @Override
    public void exceededCityTime(double value) {
        for(Subscriber sub : subsArr){
            if(sub.getCityTime() > value){
                System.out.println(sub);
            }
        }
    }

    @Override
    public void whoUseIntercityTime() {
        for(Subscriber sub : subsArr){
            if(sub.getIntercityTime() > 0){
                System.out.println(sub);
            }
        }
    }

    @Override
    public void findAllUsersLNameStartWith(char symbol) {
        for(Subscriber sub : subsArr){
            if(sub.getLastName().toUpperCase(Locale.ROOT).charAt(0) == symbol){
                System.out.println(sub.getLastName() + " " + sub.getFirstName() + " " + sub.getThirdName() + " " +
                        sub.getPhone() + " " + sub.getBalance());
            }
        }
    }

    @Override
    public void getAllInternetTrafficFromCity(String city) {
        double allTraffic = 0;
        for(Subscriber sub : subsArr){
            if(sub.getCity().equals(city)){
                allTraffic+=sub.getInternetTraffic();
            }
        }
        System.out.printf("All internet traffic from %s: %.2f",city, allTraffic);
    }

    @Override
    public void findAllUsersWithNegativeBalance() {
        for(Subscriber sub : subsArr){
            if(sub.getBalance() < 0){
                System.out.println(sub);
            }
        }
    }
}
