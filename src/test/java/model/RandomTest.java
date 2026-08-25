package model;

import random.CustomRandom;
import model.Car;
import java.util.ArrayList;
import java.util.List;

public class RandomTest {
    public static void main(String[] args) {
        System.out.println("=== ТЕСТИРОВАНИЕ RANDOM ===\n");

        // Создаём список
        List<Car> cars = new ArrayList<>();
        System.out.println("1. Создан пустой список ✅");

        // Заполняем рандомом
        System.out.println("\n2. Заполнение рандомом:");
        CustomRandom random = new CustomRandom();
        random.FIllRandom(cars);
        
        System.out.println("   Создано автомобилей: " + cars.size());
        
        // Выводим первые 5 машин (если есть)
        System.out.println("\n3. Первые 5 машин (пример):");
        int count = Math.min(5, cars.size());
        for (int i = 0; i < count; i++) {
            System.out.println("   " + (i + 1) + ". " + cars.get(i));
        }

        System.out.println("\n=== ТЕСТИРОВАНИЕ ЗАВЕРШЕНО ===");
    }
}