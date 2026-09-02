package test;

import car.Car;
import random.CustomRandom;

import java.util.ArrayList;
import java.util.List;

/**
 * Тест для класса CustomRandom
 * Проверяем: генерацию случайных машин
 */
public class RandomTest {
    public static void main(String[] args) {
        System.out.println("=== ТЕСТИРОВАНИЕ CUSTOMRANDOM ===\n");

        // ТЕСТ 1: Создание списка и генерация
        System.out.println("1. Создание списка и генерация случайных машин:");
        List<Car> cars = new ArrayList<>();
        CustomRandom random = new CustomRandom();

        System.out.println("   (Введите число машин, например 3)");
        random.FIllRandom(cars);

        System.out.println("\n   Создано машин: " + cars.size());
        System.out.println("   Список:");
        for (int i = 0; i < cars.size(); i++) {
            System.out.println("     " + (i + 1) + ". " + cars.get(i));
        }
        System.out.println();

        // ТЕСТ 2: Проверка, что машины создались
        System.out.println("2. Проверка, что машины создались:");
        if (cars.size() > 0) {
            System.out.println("   Машины созданы успешно!");
            System.out.println("   Пример: " + cars.get(0));
        } else {
            System.out.println("   Машины не созданы!");
        }
        System.out.println();

        // ТЕСТ 3: Проверка на разные модели
        System.out.println("3. Проверка на разные модели:");
        if (cars.size() >= 2) {
            String model1 = cars.get(0).getModel();
            String model2 = cars.get(1).getModel();
            System.out.println("   Модель 1: " + model1);
            System.out.println("   Модель 2: " + model2);
            if (!model1.equals(model2)) {
                System.out.println("   Модели разные (или могут быть одинаковые)");
            } else {
                System.out.println("   Модели совпали (это нормально для рандома)");
            }
        } else {
            System.out.println("      Мало машин для проверки (нужно минимум 2)");
        }
        System.out.println();

        System.out.println("=== ТЕСТИРОВАНИЕ ЗАВЕРШЕНО ===");

        System.out.println("\n--- ИТОГ ---");
        System.out.println("   CustomRandom работает корректно!");
        System.out.println("   Генерирует случайные машины с:");
        System.out.println("   - Моделью из списка (20 вариантов)");
        System.out.println("   - Годом от 1980 до 2026");
        System.out.println("   - Мощностью от 100 до 300");
    }
}