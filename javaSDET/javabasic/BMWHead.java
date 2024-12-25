package javabasic;

public class BMWHead extends CarFactory{
    @Override
    public void viewCar() {
        System.out.println("BMV view");
    }

    @Override
    public void driveCar() {
        System.out.println("BMV drive");
    }

    @Override
    public void buyCar() {
        System.out.println("BMV buy");
    }
}
