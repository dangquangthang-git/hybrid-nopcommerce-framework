package javabasic;

public class SuzukiHead extends CarFactory {
    @Override
    public void viewCar() {
        System.out.println("suzu view");
    }

    @Override
    public void driveCar() {
        System.out.println("suzu drive");
    }

    @Override
    public void buyCar() {
        System.out.println("suzu buy");
    }
}
