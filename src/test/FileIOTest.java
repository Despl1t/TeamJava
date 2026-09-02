package test;

import car.Car;
import car.CarList;
import fileReaderWriter.Load;
import fileReaderWriter.Reader;
import fileReaderWriter.Save;
import fileReaderWriter.Writer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Тест для классов работы с файлами
 * Проверяем: чтение, запись, загрузку, сохранение
 */
public class FileIOTest {
    public static void main(String[] args) {
        System.out.println("=== ТЕСТИРОВАНИЕ РАБОТЫ С ФАЙЛАМИ ===\n");

        // ТЕСТ 1: Создание тестовых данных
        System.out.println("1. Создание тестовых данных:");
        CarList testList = new CarList();
        testList.add(new Car(150, "Toyota", 2020));
        testList.add(new Car(200, "BMW", 2021));
        testList.add(new Car(100, "Audi", 2018));
        System.out.println("   Создано " + testList.size() + " машин для теста\n");

        // ТЕСТ 2: Запись в файл (Writer.appendCarsToFile)
        System.out.println("2. Запись в файл (Writer.appendCarsToFile):");
        try {
            Writer.appendCarsToFile(testList);
            System.out.println("   Данные записаны в SortedCarsList.txt");

            // Проверяем, что файл создался
            Path path = Path.of("SortedCarsList.txt");
            if (Files.exists(path)) {
                System.out.println("   Файл SortedCarsList.txt создан");
                System.out.println("   Размер файла: " + Files.size(path) + " байт");
            }
        } catch (IOException e) {
            System.out.println("   Ошибка записи: " + e.getMessage());
        }
        System.out.println();

        // ТЕСТ 3: Перезапись файла (Writer.overwriteCarsToFile)
        System.out.println("3. Перезапись файла (Writer.overwriteCarsToFile):");
        try {
            CarList newList = new CarList();
            newList.add(new Car(300, "Mercedes", 2022));
            newList.add(new Car(250, "Honda", 2019));

            Writer.overwriteCarsToFile(newList);
            System.out.println("   Файл перезаписан новыми данными");
        } catch (IOException e) {
            System.out.println("   Ошибка перезаписи: " + e.getMessage());
        }
        System.out.println();

        // ТЕСТ 4: Чтение из файла (Reader.readCarsFromFile)
        System.out.println("4. Чтение из файла (Reader.readCarsFromFile):");
        try {
            CarList readList = new CarList();
            Reader.readCarsFromFile(readList);
            System.out.println("   Прочитано машин: " + readList.size());
            for (int i = 0; i < readList.size(); i++) {
                System.out.println("     " + (i + 1) + ". " + readList.get(i));
            }
        } catch (IOException e) {
            System.out.println("   Ошибка чтения: " + e.getMessage());
        }
        System.out.println();

        // ТЕСТ 5: Сохранение в MemoryList (Save.overwriteMemory)
        System.out.println("5. Сохранение в MemoryList (Save.overwriteMemory):");
        try {
            Save.overwriteMemory(testList);
            System.out.println("   Данные сохранены в MemoryList.txt");
        } catch (IOException e) {
            System.out.println("   Ошибка сохранения: " + e.getMessage());
        }
        System.out.println();

        // ТЕСТ 6: Загрузка из MemoryList (Load.readMemory)
        System.out.println("6. Загрузка из MemoryList (Load.readMemory):");
        try {
            CarList memoryList = new CarList();
            Load.readMemory(memoryList);
            System.out.println("   Загружено машин: " + memoryList.size());
            for (int i = 0; i < memoryList.size(); i++) {
                System.out.println("     " + (i + 1) + ". " + memoryList.get(i));
            }
        } catch (IOException e) {
            System.out.println("   Ошибка загрузки: " + e.getMessage());
        }
        System.out.println();

        System.out.println("=== ТЕСТИРОВАНИЕ ЗАВЕРШЕНО ===");

        System.out.println("\n--- ИТОГ ---");
        System.out.println("Тесты работы с файлами выполнены!");
        System.out.println("Проверены:");
        System.out.println("   - Writer.appendCarsToFile()");
        System.out.println("   - Writer.overwriteCarsToFile()");
        System.out.println("   - Reader.readCarsFromFile()");
        System.out.println("   - Save.overwriteMemory()");
        System.out.println("   - Load.readMemory()");
    }
}