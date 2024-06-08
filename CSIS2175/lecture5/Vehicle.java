public class Vehicle {
    
    String make;
    String model;
    String year;
    String license_plate_number;

    Vehicle(){
        this.make = "Honda";
    }

    Vehicle(String model, String year)
    {
        this();
        this.model = model;
        this.year = year;
    }
    
    Vehicle(String model, String year, String licence_plate_number){
        this(model, year);
        this.license_plate_number = licence_plate_number;
    }

    static void display(Vehicle car){
        System.out.println("Make: " + car.make);
        System.out.println("model: " + car.model);
        System.out.println("year: " + car.year);
        System.out.println("license_plate_number: " + car.license_plate_number);
    }


    public static void main(String[] args) {
        Vehicle myCar = new Vehicle();

        display(myCar);
        Vehicle myCar2 = new Vehicle("Civic", "2017");
        display(myCar2);
    }
}
