package javabasic;

public class HondaHead extends CarFactory {
    @Override
    public void viewCar() {
        System.out.println("Honda view");
    }

    @Override
    public void driveCar() {
        System.out.println("Honda drive");
    }

    @Override
    public void buyCar() {
        System.out.println("Honda buy");
    }
}
