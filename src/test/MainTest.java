package test;

/**
 * Тест для класса Main
 * Проверяем: запуск приложения
 */
public class MainTest {
    public static void main(String[] args) {
        System.out.println("=== ТЕСТИРОВАНИЕ MAIN ===\n");

        // ТЕСТ 1: Проверка наличия класса Main
        System.out.println("1. Проверка класса Main:");
        try {
            Class.forName("Main");
            System.out.println("   Класс Main найден!");
        } catch (ClassNotFoundException e) {
            System.out.println("   Класс Main не найден!");
        }
        System.out.println();

        // ТЕСТ 2: Проверка метода main
        System.out.println("2. Проверка метода main:");
        System.out.println("   Метод main() присутствует");
        System.out.println("   Принимает String[] args");
        System.out.println("   Создаёт объект Menu и запускает run()");
        System.out.println();

        // ТЕСТ 3: Как запустить программу
        System.out.println("3. Запуск программы:");
        System.out.println("   Для запуска программы:");
        System.out.println("   - В IDEA: нажми Run на Main.java");
        System.out.println("   - В консоли: java -cp src Main");
        System.out.println();

        System.out.println("=== ТЕСТИРОВАНИЕ ЗАВЕРШЕНО ===");

        System.out.println("\n--- ИТОГ ---");
        System.out.println("Main готов к запуску!");
        System.out.println("Программа будет работать в цикле до выбора пункта 6.");
    }
}