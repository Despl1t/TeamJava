package test;

import builder.Builder;
import car.Car;

public class BuilderTest {
    public static void main(String[] args) {
        System.out.println("=== ТЕСТИРОВАНИЕ BUILDER ===\n");

        // Тест 1: Создание машины через Builder
        System.out.println("1. Создание машины через Builder:");
        Car car = new Builder()
                .setPower(150)
                .setModel("Toyota")
                .setYear(2020)
                .build();
        System.out.println("   Создан: " + car);
        System.out.println("   Мощность: " + car.getPower() + " (ожидалось 150)");
        System.out.println("   Модель: " + car.getModel() + " (ожидалось Toyota)");
        System.out.println("   Год: " + car.getYear() + " (ожидалось 2020)");

        // Тест 2: Проверка на отрицательную мощность
        System.out.println("\n2. Проверка на отрицательную мощность:");
        try {
            new Builder().setPower(-100);
            System.out.println("   ❌ Ошибка: отрицательная мощность была добавлена!");
        } catch (IllegalArgumentException e) {
            System.out.println("   ✅ Исключение перехвачено: " + e.getMessage());
        }

        // Тест 3: Проверка на пустую модель
        System.out.println("\n3. Проверка на пустую модель:");
        try {
            new Builder().setModel("");
            System.out.println("   ❌ Ошибка: пустая модель была добавлена!");
        } catch (IllegalArgumentException e) {
            System.out.println("   ✅ Исключение перехвачено: " + e.getMessage());
        }

        // Тест 4: Проверка на неверный год
        System.out.println("\n4. Проверка на неверный год:");
        try {
            new Builder().setYear(1800);
            System.out.println("   ❌ Ошибка: неверный год был добавлен!");
        } catch (IllegalArgumentException e) {
            System.out.println("   ✅ Исключение перехвачено: " + e.getMessage());
        }

        // Тест 5: Проверка build() без заполнения полей
        System.out.println("\n5. Проверка build() без заполнения полей:");
        try {
            new Builder().build();
            System.out.println("   ❌ Ошибка: объект создан без полей!");
        } catch (IllegalStateException e) {
            System.out.println("   ✅ Исключение перехвачено: " + e.getMessage());
        }

        System.out.println("\n=== ТЕСТИРОВАНИЕ ЗАВЕРШЕНО ===");
    }
}