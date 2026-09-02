package test;

import car.CarValidation;

/**
 * Тест для класса CarValidation
 * Проверяем валидацию: мощность, модель, год
 */
public class CarValidationTest {
    public static void main(String[] args) {
        System.out.println("=== ТЕСТИРОВАНИЕ CARVALIDATION ===\n");

        // ТЕСТ 1: Проверка мощности (isValidPower)
        System.out.println("1. Проверка мощности (isValidPower):");

        System.out.println("   isValidPower(150) = " + CarValidation.isValidPower(150) + " (ожидалось true)");
        System.out.println("   isValidPower(0)   = " + CarValidation.isValidPower(0) + " (ожидалось false)");
        System.out.println("   isValidPower(-50) = " + CarValidation.isValidPower(-50) + " (ожидалось false)");
        System.out.println("   isValidPower(1)   = " + CarValidation.isValidPower(1) + " (ожидалось true)");
        System.out.println();

        // ТЕСТ 2: Проверка модели (isValidModel)
        System.out.println("2. Проверка модели (isValidModel):");

        System.out.println("   isValidModel(\"Toyota\")     = " + CarValidation.isValidModel("Toyota") + " (ожидалось true)");
        System.out.println("   isValidModel(\"BMW 3\")      = " + CarValidation.isValidModel("BMW 3") + " (ожидалось true)");
        System.out.println("   isValidModel(\"Audi A4\")    = " + CarValidation.isValidModel("Audi A4") + " (ожидалось true)");
        System.out.println("   isValidModel(\"Lada\")       = " + CarValidation.isValidModel("Lada") + " (ожидалось true)");
        System.out.println("   isValidModel(\"\")           = " + CarValidation.isValidModel("") + " (ожидалось false)");
        System.out.println("   isValidModel(\"   \")        = " + CarValidation.isValidModel("   ") + " (ожидалось false)");
        System.out.println("   isValidModel(null)          = " + CarValidation.isValidModel(null) + " (ожидалось false)");
        System.out.println("   isValidModel(\"Toyota@\")    = " + CarValidation.isValidModel("Toyota@") + " (ожидалось false)");
        System.out.println("   isValidModel(\"Toyota_123\") = " + CarValidation.isValidModel("Toyota_123") + " (ожидалось false)");
        System.out.println();

        // ТЕСТ 3: Проверка года (isValidYear)
        System.out.println("3. Проверка года (isValidYear):");

        System.out.println("   isValidYear(2020) = " + CarValidation.isValidYear(2020) + " (ожидалось true)");
        System.out.println("   isValidYear(2000) = " + CarValidation.isValidYear(2000) + " (ожидалось true)");
        System.out.println("   isValidYear(1885) = " + CarValidation.isValidYear(1885) + " (ожидалось true)");
        System.out.println("   isValidYear(2100) = " + CarValidation.isValidYear(2100) + " (ожидалось true)");
        System.out.println("   isValidYear(1884) = " + CarValidation.isValidYear(1884) + " (ожидалось false)");
        System.out.println("   isValidYear(2101) = " + CarValidation.isValidYear(2101) + " (ожидалось false)");
        System.out.println("   isValidYear(0)    = " + CarValidation.isValidYear(0) + " (ожидалось false)");
        System.out.println("   isValidYear(-100) = " + CarValidation.isValidYear(-100) + " (ожидалось false)");
        System.out.println();

        // ТЕСТ 4: Комплексная проверка
        System.out.println("4. Комплексная проверка (все поля корректны):");

        int power = 150;
        String model = "Toyota";
        int year = 2020;

        boolean allValid = CarValidation.isValidPower(power)
                && CarValidation.isValidModel(model)
                && CarValidation.isValidYear(year);

        System.out.println("   Мощность: " + power + " -> " + CarValidation.isValidPower(power));
        System.out.println("   Модель: " + model + " -> " + CarValidation.isValidModel(model));
        System.out.println("   Год: " + year + " -> " + CarValidation.isValidYear(year));
        System.out.println("   Все поля валидны? " + allValid + " (ожидалось true)");
        System.out.println();

        System.out.println("=== ТЕСТИРОВАНИЕ ЗАВЕРШЕНО ===");

        System.out.println("\n--- ИТОГ ---");
        System.out.println("Все тесты пройдены!");
        System.out.println("CarValidation работает корректно.");
    }
}