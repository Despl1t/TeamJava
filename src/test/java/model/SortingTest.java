package model;

import strategy.BubbleSortStrategy;
import strategy.SortStrategy;
import model.Car;
import java.util.ArrayList;
import java.util.List;

public class SortingTest {
    public static void main(String[] args) {
        System.out.println("=== ТЕСТИРОВАНИЕ СОРТИРОВКИ ===\n");

        // Создаём список машин
        List<Car> cars = new ArrayList<>();
        cars.add(new Car(300, "BMW", 2020));
        cars.add(new Car(100, "Audi", 2018));
        cars.add(new Car(200, "Mercedes", 2019));

        System.out.println("Исходный список:");
        for (Car c : cars) {
            System.out.println("  " + c);
        }

        // Тест 1: Сортировка по году (параметр 1)
        System.out.println("\n1. Сортировка по году:");
        List<Car> copy1 = new ArrayList<>(cars);
        SortStrategy bubble = new BubbleSortStrategy();
        bubble.sortCustom(copy1, 1);
        for (Car c : copy1) {
            System.out.println("  " + c);
        }

        // Тест 2: Сортировка по мощности (параметр 2)
        System.out.println("\n2. Сортировка по мощности:");
        List<Car> copy2 = new ArrayList<>(cars);
        bubble.sortCustom(copy2, 2);
        for (Car c : copy2) {
            System.out.println("  " + c);
        }

        // Тест 3: Сортировка по модели (параметр 3)
        System.out.println("\n3. Сортировка по модели:");
        List<Car> copy3 = new ArrayList<>(cars);
        bubble.sortCustom(copy3, 3);
        for (Car c : copy3) {
            System.out.println("  " + c);
        }

        System.out.println("\n=== ТЕСТИРОВАНИЕ ЗАВЕРШЕНО ===");
    }
}