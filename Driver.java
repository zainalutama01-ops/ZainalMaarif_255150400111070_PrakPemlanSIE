public class Driver {
    private Car myCar;
    
    public Driver() {
        System.out.println("Driver is created.");
        myCar = new Car();
    }
    
    public void driving() {
        System.out.println("Driver is driving.");
        System.out.println("Using a car that has " + myCar.numWheel + " wheels.");
    }
}