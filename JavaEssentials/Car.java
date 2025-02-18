package JavaEssentials;

public class Car {
    public static void main(String[] args) {
        // Constructor is used based on how we call this class.
        Vehicle c1 = new Vehicle();
        System.out.println(c1);

        Vehicle c2 = new Vehicle(5);
        System.out.println(c2.seats);
    }
}


class Vehicle {
    int seats = 2;
    int wheels;
    double weight;
    double mileage;

    Vehicle() {                     // This is a Constructor
        mileage = 0;
        wheels = 4;
    }

    Vehicle(int numberofSeats) {    // This is a Constructor
        this();                     // To call the Car() for defaults.
        seats = numberofSeats;
    }

    boolean isFourSeater() {
        return seats == 4;
    }

    boolean canSeat(int seats) {
        return this.seats >= seats;

    }
}
