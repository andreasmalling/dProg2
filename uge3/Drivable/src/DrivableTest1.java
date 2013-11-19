public class DrivableTest1 {
    public static void main(String[] args) {
        Drivable myCar = new SolarCar();
        assert myCar.drive(1000);
        assert myCar.drive(1000);
        assert myCar.getMileage() == 2000;
        Truck myTruck = new Truck();
        myTruck.fill(100);
        assert myTruck.drive(499);
        assert !myTruck.drive(2);
        myTruck.fill(10);
        assert myTruck.drive(2);
        assert myTruck.getMileage() == 501;
        HorseCarriage myCarriage = new HorseCarriage();
        myCarriage.restHorses();
        assert myCarriage.drive(99);
        assert !myCarriage.drive(2);
        myCarriage.restHorses();
        assert myCarriage.drive(2);
        assert myCarriage.getMileage() == 101;
        //assert (myCarriage instanceof Drivable);
        try {
            assert false;
            System.out.println("Please enable assertions!");
        }
        catch(AssertionError e) {
            System.out.println("Success!");
        }
    }
}