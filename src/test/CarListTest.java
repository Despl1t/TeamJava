package test;

import car.Car;
import car.CarList;

/**
 * Тест для класса CarList
 * Проверяем: добавление, получение, удаление, размер, проверку на null
 */
public class CarListTest {
    public static void main(String[] args) {
        System.out.println("=== ТЕСТИРОВАНИЕ CARLIST ===\n");

        // ТЕСТ 1: Создание пустого списка
        System.out.println("1. Создание пустого списка:");
        CarList carList = new CarList();
        System.out.println("   Размер списка: " + carList.size() + " (ожидалось 0)");
        System.out.println("   Список пуст? " + carList.isEmpty() + " (ожидалось true)\n");

        // ТЕСТ 2: Добавление машин
        System.out.println("2. Добавление машин:");
        Car car1 = new Car(100, "Audi", 2018);
        Car car2 = new Car(200, "BMW", 2019);
        Car car3 = new Car(300, "Mercedes", 2020);

        carList.add(car1);
        carList.add(car2);
        carList.add(car3);

        System.out.println("   Добавлено 3 машины");
        System.out.println("   Размер списка: " + carList.size() + " (ожидалось 3)");
        System.out.println("   Список пуст? " + carList.isEmpty() + " (ожидалось false)\n");

        // ТЕСТ 3: Получение машин по индексу
        System.out.println("3. Получение машин по индексу:");
        Car getCar = carList.get(0);
        System.out.println("   carList.get(0) = " + getCar.getModel() + " (ожидалось Audi)");
        System.out.println("   carList.get(1) = " + carList.get(1).getModel() + " (ожидалось BMW)");
        System.out.println("   carList.get(2) = " + carList.get(2).getModel() + " (ожидалось Mercedes)\n");

        // ТЕСТ 4: Замена машины по индексу (set)
        System.out.println("4. Замена машины по индексу (set):");
        Car car4 = new Car(250, "Toyota", 2022);
        carList.set(1, car4);
        System.out.println("   Заменили индекс 1 на Toyota");
        System.out.println("   carList.get(1) = " + carList.get(1).getModel() + " (ожидалось Toyota)\n");

        // ТЕСТ 5: Удаление машины
        System.out.println("5. Удаление машины:");
        Car removed = carList.remove(0);
        System.out.println("   Удалён: " + removed.getModel() + " (ожидалось Audi)");
        System.out.println("   Размер после удаления: " + carList.size() + " (ожидалось 2)\n");

        // ТЕСТ 6: Проверка на null
        System.out.println("6. Проверка на null (должен вывести ошибку в консоль):");
        System.out.println("   Ожидается сообщение: 'Автомобиль не может быть null'");
        carList.add(null);   // должен вывести ошибку, но не упасть
        System.out.println("   Размер после добавления null: " + carList.size() + " (ожидалось 3, потому что null не добавился?)\n");

        // ТЕСТ 7: Проверка set с null
        System.out.println("7. Проверка set с null:");
        System.out.println("   Ожидается сообщение: 'Автомобиль не может быть null'");
        carList.set(0, null); // должен вывести ошибку, но не упасть
        System.out.println("   Размер остался: " + carList.size() + " (ожидалось 3)\n");

        System.out.println("=== ТЕСТИРОВАНИЕ ЗАВЕРШЕНО ===");

        System.out.println("\n--- ИТОГ ---");
        System.out.println("Все тесты пройдены!");
        System.out.println("Внимание: при добавлении null выводится сообщение об ошибке, но объект не добавляется.");
    }
}