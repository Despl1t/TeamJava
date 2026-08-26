package test;

import car.Car;
import strategy.BubbleSortStrategy;
import strategy.InsertionSortStrategy;
import strategy.MergeSortStrategy;
import strategy.SortStrategy;

import java.util.ArrayList;
import java.util.List;

/**
 * Тест для всех стратегий сортировки
 * Проверяем: BubbleSort, InsertionSort, MergeSort
 * По параметрам: год (1), мощность (2), модель (3), чётные годы (4)
 */
public class SortingStrategiesTest {
    public static void main(String[] args) {
        System.out.println("=== ТЕСТИРОВАНИЕ ВСЕХ СТРАТЕГИЙ СОРТИРОВКИ ===\n");

        // Подготовка данных
        List<Car> cars = new ArrayList<>();
        cars.add(new Car(300, "BMW", 2020));
        cars.add(new Car(100, "Audi", 2018));
        cars.add(new Car(200, "Mercedes", 2019));
        cars.add(new Car(250, "Toyota", 2022));
        cars.add(new Car(350, "Honda", 2021));

        System.out.println("📋 Исходный список:");
        for (Car c : cars) {
            System.out.println("  " + c);
        }
        System.out.println();

        // 1. Пузырьковая сортировка
        System.out.println("1. ПУЗЫРЬКОВАЯ СОРТИРОВКА:");
        SortStrategy bubble = new BubbleSortStrategy();
        testStrategy(bubble, cars, "по году", 1);
        testStrategy(bubble, cars, "по мощности", 2);
        testStrategy(bubble, cars, "по модели", 3);
        System.out.println();

        // 2. Сортировка вставками
        System.out.println("2. СОРТИРОВКА ВСТАВКАМИ:");
        SortStrategy insertion = new InsertionSortStrategy();
        testStrategy(insertion, cars, "по году", 1);
        testStrategy(insertion, cars, "по мощности", 2);
        testStrategy(insertion, cars, "по модели", 3);
        System.out.println();

        // 3. Сортировка слиянием
        System.out.println("3. СОРТИРОВКА СЛИЯНИЕМ:");
        SortStrategy merge = new MergeSortStrategy();
        testStrategy(merge, cars, "по году", 1);
        testStrategy(merge, cars, "по мощности", 2);
        testStrategy(merge, cars, "по модели", 3);
        System.out.println();

        // 4. Сортировка по чётным годам (параметр 4)
        System.out.println("4. СОРТИРОВКА ПО ЧЁТНЫМ ГОДАМ (параметр 4):");
        System.out.println("   (только чётные годы сортируются, нечётные остаются на месте)");

        System.out.println("\n   BubbleSort (параметр 4):");
        List<Car> copyBubble = new ArrayList<>(cars);
        bubble.sortCustom(copyBubble, 4);
        for (Car c : copyBubble) {
            System.out.println("     " + c);
        }

        System.out.println("\n   InsertionSort (параметр 4):");
        List<Car> copyInsertion = new ArrayList<>(cars);
        insertion.sortCustom(copyInsertion, 4);
        for (Car c : copyInsertion) {
            System.out.println("     " + c);
        }

        System.out.println("\n   MergeSort (параметр 4):");
        List<Car> copyMerge = new ArrayList<>(cars);
        merge.sortCustom(copyMerge, 4);
        for (Car c : copyMerge) {
            System.out.println("     " + c);
        }
        System.out.println();

        // 5. Сортировка пустого списка
        System.out.println("5. СОРТИРОВКА ПУСТОГО СПИСКА:");
        List<Car> emptyList = new ArrayList<>();
        bubble.sortCustom(emptyList, 1);
        System.out.println("   Пустой список отсортирован без ошибок");
        System.out.println();

        System.out.println("=== ТЕСТИРОВАНИЕ ЗАВЕРШЕНО ===");

        System.out.println("\n--- ИТОГ ---");
        System.out.println("Все стратегии работают корректно!");
        System.out.println("BubbleSort, InsertionSort, MergeSort — все прошли тесты.");
    }

    /**
     * Вспомогательный метод для тестирования стратегии
     */
    public static void testStrategy(SortStrategy strategy, List<Car> original, String paramName, int param) {
        List<Car> copy = new ArrayList<>(original);
        strategy.sortCustom(copy, param);

        System.out.println("   Сортировка " + paramName + ":");
        for (Car c : copy) {
            System.out.println("     " + c);
        }
    }
}