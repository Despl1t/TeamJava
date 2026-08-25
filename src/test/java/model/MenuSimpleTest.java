package model;

import menu.Menu;

public class MenuSimpleTest {
    public static void main(String[] args) {
        System.out.println("=== ТЕСТИРОВАНИЕ МЕНЮ (упрощённое) ===\n");

        // Проверяем, что класс Menu существует
        System.out.println("1. Проверка наличия класса Menu:");
        try {
            Class.forName("menu.Menu");
            System.out.println("   Класс Menu найден ✅");
        } catch (ClassNotFoundException e) {
            System.out.println("   ❌ Класс Menu не найден!");
        }

        // Проверяем создание объекта
        System.out.println("\n2. Создание объекта Menu:");
        try {
            Menu menu = new Menu();
            System.out.println("   Объект Menu создан ✅");
        } catch (Exception e) {
            System.out.println("   ❌ Ошибка при создании: " + e.getMessage());
        }

        System.out.println("\n=== ТЕСТИРОВАНИЕ ЗАВЕРШЕНО ===");
        System.out.println("\n⚠️ Для полного тестирования меню нужно:");
        System.out.println("   1. Исправить импорты в Menu.java");
        System.out.println("   2. Добавить недостающие классы");
        System.out.println("   3. Запустить menu.Menu");
    }
}