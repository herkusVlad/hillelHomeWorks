import Car.*;

public class RunApplication {
    public static void main(String[] args) throws CarFuelException {
        Car car = new Car(20, 10);
        double priceFuel = Double.parseDouble(args[0]);
        double totalPriceForFuel = 0;
        double distanceToKiev = 474.2d;
        double distanceToKrivoeOsero = 178.5d;
        double distanceToZashkov = 153d;

        car.overcomingKilometers(distanceToKrivoeOsero);
        distanceToKiev -= distanceToKrivoeOsero;
        totalPriceForFuel += car.neededFuel() * priceFuel;
        car.addFullFuel();

        car.overcomingKilometers(distanceToZashkov);
        distanceToKiev -= distanceToZashkov;
        totalPriceForFuel += car.getRemainingInTank() * priceFuel;
        car.addFullFuel();

        car.overcomingKilometers(distanceToKiev);
        System.out.println("Total price for Fuel : " + roundAvoid(totalPriceForFuel,2) +
                "\nRemaining fuel in the car: " + roundAvoid(car.getRemainingInTank(),2));
    }

    public static double roundAvoid(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }
}
