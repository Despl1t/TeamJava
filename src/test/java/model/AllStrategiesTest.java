package model;

import strategy.BubbleSortStrategy;
import strategy.InsertionSortStrategy;
import strategy.MergeSortStrategy;
import strategy.SortStrategy;
import model.Car;
import java.util.ArrayList;
import java.util.List;

public class AllStrategiesTest {
    public static void main(String[] args) {
        System.out.println("=== ФИНАЛЬНОЕ ТЕСТИРОВАНИЕ ВСЕХ СТРАТЕГИЙ ===\n");

        List<Car> cars = new ArrayList<>();
        cars.add(new Car(300, "BMW", 2020));
        cars.add(new Car(100, "Audi", 2018));
        cars.add(new Car(200, "Mercedes", 2019));
        cars.add(new Car(250, "Toyota", 2022));
        cars.add(new Car(350, "Honda", 2021));

        System.out.println("Исходный список:");
        for (Car c : cars) {
            System.out.println("  " + c);
        }

        testStrategy(new BubbleSortStrategy(), cars, "Пузырьковая");
        testStrategy(new InsertionSortStrategy(), cars, "Вставками");
        testStrategy(new MergeSortStrategy(), cars, "Слиянием");

        System.out.println("\n=== ТЕСТИРОВАНИЕ ЗАВЕРШЕНО ===");
    }

    public static void testStrategy(SortStrategy strategy, List<Car> original, String name) {
        System.out.println("\n" + name + " сортировка по году:");
        List<Car> copy = new ArrayList<>(original);
        strategy.sortCustom(copy, 1);
        for (Car c : copy) {
            System.out.println("  " + c);
        }
    }
}