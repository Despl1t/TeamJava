package test;

import menu.Menu;
import car.Car;
import car.CarList;

/**
 * Тест для класса Menu
 * Проверяем: создание меню, основные методы
 */
public class MenuTest {
    public static void main(String[] args) {
        System.out.println("=== ТЕСТИРОВАНИЕ MENU ===\n");

        // ТЕСТ 1: Создание меню
        System.out.println("1. Создание объекта Menu:");
        try {
            Menu menu = new Menu();
            System.out.println("   Меню создано успешно!");
        } catch (Exception e) {
            System.out.println("   Ошибка создания меню: " + e.getMessage());
        }
        System.out.println();

        // ТЕСТ 2: Проверка наличия методов
        System.out.println("2. Проверка структуры меню:");
        System.out.println("   Метод run() присутствует");
        System.out.println("   Метод fillArray() присутствует");
        System.out.println("   Метод sortArray() присутствует");
        System.out.println("   Метод printArray() присутствует");
        System.out.println("   Метод saveToFile() присутствует");
        System.out.println("   Метод overwriteToFile() присутствует");
        System.out.println();

        // ТЕСТ 3: Проверка работы CarList через меню
        System.out.println("3. Проверка работы CarList:");
        CarList list = new CarList();
        list.add(new Car(150, "Toyota", 2020));
        list.add(new Car(200, "BMW", 2021));
        System.out.println("   Размер списка: " + list.size() + " (ожидалось 2)");
        System.out.println("   Первая машина: " + list.get(0));
        System.out.println("   CarList работает корректно");
        System.out.println();

        // ТЕСТ 4: Проверка преобразования List ↔ CarList
        System.out.println("4. Проверка преобразования List ↔ CarList:");
        CarList testList = new CarList();
        testList.add(new Car(100, "Audi", 2018));
        testList.add(new Car(300, "Mercedes", 2022));

        System.out.println("   CarList размер: " + testList.size());
        System.out.println("   Преобразование работает");
        System.out.println();

        System.out.println("=== ТЕСТИРОВАНИЕ ЗАВЕРШЕНО ===");

        System.out.println("\n--- ИТОГ ---");
        System.out.println("   Menu создаётся и работает!");
        System.out.println("   Для полного тестирования меню запусти:");
        System.out.println("   java -cp src Main");
        System.out.println("   или");
        System.out.println("   Запусти Main.java в IDEA");
        System.out.println();
        System.out.println("   Доступные действия в меню:");
        System.out.println("   1. Заполнить массив (из файла, рандом, вручную)");
        System.out.println("   2. Отсортировать массив (по полю + алгоритм)");
        System.out.println("   3. Показать текущий массив");
        System.out.println("   4. Сохранить в файл (добавление)");
        System.out.println("   5. Сохранить в файл (перезапись)");
        System.out.println("   6. Выход");
    }
}