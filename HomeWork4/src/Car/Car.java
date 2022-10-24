package Car;

public class Car {
    private double volume;
    private double remainingInTank;
    private double fuelConsumption;

    public Car(){}

    public Car(double volume, double fuelConsumption) {
        this.volume = volume;
        this.remainingInTank = volume;
        this.fuelConsumption = fuelConsumption;
    }

    public void addFullFuel(){
        this.remainingInTank+= neededFuel();
    }

    public void addFullFuel(double kilometers) throws CarFuelException {
        this.remainingInTank+= neededFuel(kilometers);
    }

    public void overcomingKilometers(double kilometers) throws CarFuelException {
        if(remainingInTank - kilometers / 100 * fuelConsumption < 0){
            throw new CarFuelException("The car ran out of fuel");
        }
        remainingInTank= remainingInTank - kilometers / 100 * fuelConsumption;
    }

    public double neededFuel(){
        return volume - remainingInTank;
    }

    public double neededFuel(double kilometers) throws CarFuelException {
        overcomingKilometers(kilometers);
        return volume - remainingInTank;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public double getRemainingInTank() {
        return remainingInTank;
    }

    public void setRemainingInTank(double remainingInTank) {
        this.remainingInTank = remainingInTank;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }
}
