package Subscriber;

import java.util.UUID;

public class Subscriber {
    private String ID;
    private String lastName;
    private String firstName;
    private String thirdName;

    private String city;

    private String phone;
    private String contractNumber;

    private double balance;

    private double cityTime;

    private double intercityTime;

    private double internetTraffic;

    public Subscriber(){
        ID = UUID.randomUUID().toString();
    };

    public Subscriber(String lastName, String firstName, double balance, double cityTime, double intercityTime, double internetTraffic) {
        ID = UUID.randomUUID().toString();
        this.lastName = lastName;
        this.firstName = firstName;
        this.balance = balance;
        this.cityTime = cityTime;
        this.intercityTime = intercityTime;
        this.internetTraffic = internetTraffic;
    }

    @Override
    public String toString() {
        return "Student: " + ID + " "
                + lastName +
                " " + firstName +
                " " + thirdName + ',' +
                " " + city + ',' +
                " " + phone + ',' +
                " " + contractNumber + ',' +
                " " + balance + ',' +
                " " + cityTime + ',' +
                " " + intercityTime + ',' +
                " " + internetTraffic;
    }

    public String getID() {
        return ID;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getThirdName() {
        return thirdName;
    }

    public void setThirdName(String thirdName) {
        this.thirdName = thirdName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getCityTime() {
        return cityTime;
    }

    public void setCityTime(double cityTime) {
        this.cityTime = cityTime;
    }

    public double getIntercityTime() {
        return intercityTime;
    }

    public void setIntercityTime(double intercityTime) {
        this.intercityTime = intercityTime;
    }

    public double getInternetTraffic() {
        return internetTraffic;
    }

    public void setInternetTraffic(double internetTraffic) {
        this.internetTraffic = internetTraffic;
    }

}
