package test;

import car.Car;

public class CarTest {
    public static void main(String[] args) {
        System.out.println("=== ТЕСТИРОВАНИЕ CAR ===\n");

        Car car = new Car(150, "Toyota", 2020);
        System.out.println("1. Создание машины:");
        System.out.println("   " + car);

        System.out.println("\n2. Проверка геттеров:");
        System.out.println("   Мощность: " + car.getPower() + " (ожидалось 150)");
        System.out.println("   Модель: " + car.getModel() + " (ожидалось Toyota)");
        System.out.println("   Год: " + car.getYear() + " (ожидалось 2020)");

        System.out.println("\n3. Проверка equals:");
        Car car2 = new Car(150, "Toyota", 2020);
        System.out.println("   car.equals(car2) = " + car.equals(car2) + " (ожидалось true)");

        System.out.println("\n4. Проверка compareTo:");
        Car carA = new Car(100, "Audi", 2018);
        Car carB = new Car(200, "BMW", 2019);
        System.out.println("   carA.compareTo(carB) = " + carA.compareTo(carB) + " (ожидалось отрицательное число)");

        System.out.println("\n=== ТЕСТИРОВАНИЕ ЗАВЕРШЕНО ===");
    }
}