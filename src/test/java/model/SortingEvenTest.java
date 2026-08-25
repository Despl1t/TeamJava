package model;

import strategy.BubbleSortStrategy;
import strategy.InsertionSortStrategy;
import strategy.MergeSortStrategy;
import strategy.SortStrategy;
import model.Car;
import java.util.ArrayList;
import java.util.List;

public class SortingEvenTest {
    public static void main(String[] args) {
        System.out.println("=== ТЕСТИРОВАНИЕ СОРТИРОВКИ ПО ЧЁТНЫМ ГОДАМ ===\n");

        List<Car> cars = new ArrayList<>();
        cars.add(new Car(300, "BMW", 2021));    // нечётный
        cars.add(new Car(100, "Audi", 2018));    // чётный
        cars.add(new Car(200, "Mercedes", 2020)); // чётный
        cars.add(new Car(250, "Toyota", 2022));   // чётный
        cars.add(new Car(350, "Honda", 2019));   // нечётный

        System.out.println("Исходный список:");
        for (Car c : cars) {
            System.out.println("  " + c);
        }

        System.out.println("\nПосле сортировки по году (только чётные годы):");
        SortStrategy bubble = new BubbleSortStrategy();
        List<Car> copy = new ArrayList<>(cars);
        bubble.sortCustom(copy, 4);
        for (Car c : copy) {
            System.out.println("  " + c);
        }

        System.out.println("\n=== ТЕСТИРОВАНИЕ ЗАВЕРШЕНО ===");
    }
}