package test;

import car.Car;  // импортируем класс Car из пакета car

/**
 * Тест для класса Car
 * Проверяем: создание, геттеры, equals, hashCode, compareTo, toString
 */
public class CarTest {
    public static void main(String[] args) {
        System.out.println("=== ТЕСТИРОВАНИЕ CAR ===\n");
        
        // ТЕСТ 1: Создание машины через конструктор
        System.out.println("1. Создание автомобиля:");
        Car car = new Car(150, "Toyota", 2020);
        System.out.println("   Создан: " + car);
        System.out.println("   Ожидалось: Автомобиль: Мощность - 150, Модель - Toyota, 2020 г.\n");

        // ТЕСТ 2: Проверка геттеров
        System.out.println("2. Проверка геттеров:");
        System.out.println("   getPower() = " + car.getPower() + " (ожидалось 150)");
        System.out.println("   getModel() = " + car.getModel() + " (ожидалось Toyota)");
        System.out.println("   getYear()  = " + car.getYear() + " (ожидалось 2020)");
        System.out.println();

        // ТЕСТ 3: Проверка equals
        System.out.println("3. Проверка equals:");
        Car car1 = new Car(150, "Toyota", 2020);
        Car car2 = new Car(150, "Toyota", 2020);
        Car car3 = new Car(200, "BMW", 2021);

        System.out.println("   car1.equals(car2) = " + car1.equals(car2) + " (ожидалось true)");
        System.out.println("   car1.equals(car3) = " + car1.equals(car3) + " (ожидалось false)");
        System.out.println("   car1.equals(null) = " + car1.equals(null) + " (ожидалось false)");
        System.out.println();

        // ТЕСТ 4: Проверка hashCode
        System.out.println("4. Проверка hashCode:");
        System.out.println("   hashCode car1 = " + car1.hashCode());
        System.out.println("   hashCode car2 = " + car2.hashCode());
        System.out.println("   hashCode равны? " + (car1.hashCode() == car2.hashCode()) + " (ожидалось true)");
        System.out.println();

        // ТЕСТ 5: Проверка compareTo
        System.out.println("5. Проверка compareTo (сравнение):");
        Car carA = new Car(100, "Audi", 2018);
        Car carB = new Car(200, "BMW", 2019);
        Car carC = new Car(100, "Audi", 2018); // такая же как carA

        System.out.println("   carA.compareTo(carB) = " + carA.compareTo(carB) + " (ожидалось отрицательное число)");
        System.out.println("   carB.compareTo(carA) = " + carB.compareTo(carA) + " (ожидалось положительное число)");
        System.out.println("   carA.compareTo(carC) = " + carA.compareTo(carC) + " (ожидалось 0)");

        // Проверка сравнения по модели (при одинаковой мощности)
        System.out.println("\n   Сравнение по модели (при одинаковой мощности):");
        Car carD = new Car(100, "BMW", 2018);
        Car carE = new Car(100, "Audi", 2018);
        System.out.println("   Audi.compareTo(BMW) = " + carE.compareTo(carD) + " (ожидалось отрицательное)");

        System.out.println("\n=== ТЕСТИРОВАНИЕ ЗАВЕРШЕНО ===");

        // ИТОГ (ручная проверка)
        System.out.println("\n--- ИТОГ ---");
        System.out.println("Все тесты должны быть пройдены!");
        System.out.println("Если есть ошибки — проверь вывод выше.");
    }
}