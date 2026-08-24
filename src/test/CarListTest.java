package test;

import car.Car;
import car.CarList;

public class CarListTest {
    public static void main(String[] args) {
        System.out.println("=== ТЕСТИРОВАНИЕ CARLIST ===\n");

        CarList list = new CarList();
        Car car1 = new Car(100, "Audi", 2018);
        Car car2 = new Car(200, "BMW", 2019);

        System.out.println("1. Добавление машин...");
        list.add(car1);
        list.add(car2);
        System.out.println("   Размер списка: " + list.size() + " (ожидалось 2)");

        System.out.println("\n2. Получение машины по индексу...");
        Car getCar = list.get(0);
        System.out.println("   Получен: " + getCar.getModel() + " (ожидалось Audi)");

        System.out.println("\n3. Удаление машины...");
        Car removed = list.remove(0);
        System.out.println("   Удалён: " + removed.getModel() + " (ожидалось Audi)");
        System.out.println("   Размер после удаления: " + list.size() + " (ожидалось 1)");

        System.out.println("\n4. Проверка на null (должно выбросить исключение)...");
        try {
            list.add(null);
            System.out.println("   ❌ Ошибка: null был добавлен!");
        } catch (IllegalArgumentException e) {
            System.out.println("   ✅ Исключение перехвачено: " + e.getMessage());
        }

        System.out.println("\n=== ТЕСТИРОВАНИЕ ЗАВЕРШЕНО ===");
    }
}