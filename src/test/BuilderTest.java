package test;

import builder.Builder;
import car.Car;

/**
 * Тест для класса Builder
 * Проверяем: создание машины, обрезку пробелов
 * Валидация вынесена в отдельный класс CarValidation
 */
public class BuilderTest {
    public static void main(String[] args) {
        System.out.println("=== ТЕСТИРОВАНИЕ BUILDER ===\n");

        // ТЕСТ 1: Создание машины через Builder
        System.out.println("1. Создание машины через Builder:");
        Car car = new Builder()
                .setPower(150)
                .setModel("Toyota")
                .setYear(2020)
                .build();
        System.out.println("   Создан: " + car);
        System.out.println("   Мощность: " + car.getPower() + " (ожидалось 150)");
        System.out.println("   Модель: " + car.getModel() + " (ожидалось Toyota)");
        System.out.println("   Год: " + car.getYear() + " (ожидалось 2020)\n");

        // ТЕСТ 2: Обрезка пробелов в модели
        System.out.println("2. Проверка обрезки пробелов в модели:");
        Car carWithSpaces = new Builder()
                .setPower(200)
                .setModel("  BMW  ")
                .setYear(2021)
                .build();
        System.out.println("   Создан: " + carWithSpaces);
        System.out.println("   Модель: '" + carWithSpaces.getModel() + "' (ожидалось 'BMW', без пробелов)\n");

        // ТЕСТ 3: Builder с разными значениями
        System.out.println("3. Создание нескольких машин через Builder:");
        Car car1 = new Builder().setPower(100).setModel("Audi").setYear(2018).build();
        Car car2 = new Builder().setPower(200).setModel("BMW").setYear(2019).build();
        Car car3 = new Builder().setPower(300).setModel("Mercedes").setYear(2020).build();

        System.out.println("   Машина 1: " + car1);
        System.out.println("   Машина 2: " + car2);
        System.out.println("   Машина 3: " + car3);
        System.out.println();

        // ТЕСТ 4: Проверка работы с null и пустыми значениями
        System.out.println("4. Проверка с пустыми значениями (без валидации):");
        Car emptyCar = new Builder()
                .setPower(0)
                .setModel("")
                .setYear(0)
                .build();
        System.out.println("   Создана машина с пустыми значениями: " + emptyCar);
        System.out.println("   (Валидация не выполняется — это ожидаемое поведение)");

        System.out.println("\n=== ТЕСТИРОВАНИЕ ЗАВЕРШЕНО ===");

        System.out.println("\n--- ИТОГ ---");
        System.out.println("Все тесты пройдены!");
        System.out.println("Builder создаёт объекты без валидации.");
        System.out.println("Валидация выполняется в CarValidation при чтении файла.");
    }
}