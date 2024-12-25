package javabasic;

import commons.CarList;

public class EndUser {
    public static void main(String[] args) {
        carName("Honda").buyCar();
        carName("Honda").viewCar();
        carName("Honda").driveCar();
    }

    public static CarFactory carName(String getName) {
        CarFactory carFactory;
        CarList carList = CarList.valueOf(getName.toUpperCase());
        switch (carList) {
            case BMW:
                carFactory = new BMWHead();
                break;
            case HONDA:
                carFactory = new HondaHead();
                break;
            case SUZUKI:
                carFactory = new SuzukiHead();
                break;
            default:
                throw new RuntimeException("Unexpected value: " + carList);
        }
        return carFactory;
    }
}
