package menu;

import builder.Builder;
import car.Car;
import car.CarList;
import car.CarValidation;
import fileReaderWriter.Reader;
import fileReaderWriter.Writer;
import random.CustomRandom;
import strategy.SortStrategy;
import strategy.BubbleSortStrategy;
import strategy.InsertionSortStrategy;
import strategy.MergeSortStrategy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

public class Menu {

    private final Scanner scanner = new Scanner(System.in);
    private CarList carList = new CarList();


    public void run() {
        boolean running = true;
        while (running) {
            printMainMenu();
            int choice = readIntInRange("Выберите пункт меню: ", 1, 5);
            switch (choice) {
                case 1 -> fillArray();
                case 2 -> sortArray();
                case 3 -> printArray();
                case 4 -> saveToFile();
                case 5 -> running = false;
                default -> System.out.println("Некорректный пункт меню.");
            }
        }
        System.out.println("Работа программы завершена.");
    }

    private void printMainMenu() {
        System.out.println();
        System.out.println("===== ГЛАВНОЕ МЕНЮ =====");
        System.out.println("1. Заполнить массив автомобилей");
        System.out.println("2. Отсортировать массив");
        System.out.println("3. Показать текущий массив");
        System.out.println("4. Сохранить массив в файл (добавление)");
        System.out.println("5. Выход");
    }

    private void fillArray() {
        System.out.println();
        System.out.println("--- Заполнение массива ---");
        System.out.println("1. Из файла");
        System.out.println("2. Случайными значениями");
        System.out.println("3. Вручную");
        System.out.println("4. Назад");
        int choice = readIntInRange("Выберите способ заполнения: ", 1, 4);

        switch (choice) {
            case 1 -> fillFromFile();
            case 2 -> fillRandom();
            case 3 -> fillManually();
            case 4 -> { /* назад в меню */ }
            default -> System.out.println("Некорректный выбор.");
        }
    }

    private void fillFromFile() {
        String path = readNonEmptyLine("Введите путь к файлу: ");
        try {
            carList = Reader.readCarsFromFile();
            System.out.println("Загружено автомобилей: " + carList.size());
        } catch (IOException e) {
            System.out.println("Ошибка чтения файла: " + e.getMessage());
        }
    }

    private void fillRandom() {
        // CustomRandom сам запрашивает у пользователя количество объектов через свой Scanner.
        CustomRandom generator = new CustomRandom();
        List<Car> buffer = new ArrayList<>();
        generator.FIllRandom(buffer);
        carList = fromList(buffer);
        System.out.println("Сгенерировано автомобилей: " + carList.size());
    }

    private void fillManually() {
        int length = readIntInRange("Введите количество автомобилей для ввода: ", 1, 10_000);
        carList = new CarList();
        for (int i = 1; i <= length; i++) {
            System.out.println("Автомобиль #" + i);
            int power = readValidatedInt("  Мощность (л.с.): ", CarValidation::isValidPower);
            String model = readValidatedString("  Модель: ", CarValidation::isValidModel);
            int year = readValidatedInt("  Год выпуска: ", CarValidation::isValidYear);

            Car car = new Builder()
                    .setPower(power)
                    .setModel(model)
                    .setYear(year)
                    .build();
            carList.add(car);
        }
    }


    private void sortArray() {
        if (carList.isEmpty()) {
            System.out.println("Массив пуст. Сначала заполните его.");
            return;
        }

        System.out.println();
        System.out.println("--- Сортировка ---");
        System.out.println("1. По мощности");
        System.out.println("2. По модели");
        System.out.println("3. По году выпуска");
        System.out.println("4. По году выпуска: чётные — сортируются, нечётные — остаются на месте (доп. задание 1)");
        System.out.println("5. Назад");
        int choice = readIntInRange("Выберите поле/алгоритм: ", 1, 5);

        SortStrategy strategy = switch (choice) {
            case 1 -> new BubbleSortStrategyPower();
            case 2 -> new BubbleSortStrategyModel();
            case 3 -> new BubbleSortStrategyYear();
            case 4 -> new ExtraSortStrategyYear();
            default -> null;
        };

        if (strategy == null) {
            return;
        }

        List<Car> buffer = toList(carList);
        strategy.sortCustom(buffer);
        carList = fromList(buffer);
        System.out.println("Сортировка выполнена.");
    }


    private void printArray() {
        if (carList.isEmpty()) {
            System.out.println("Массив пуст.");
            return;
        }
        System.out.println();
        System.out.println("--- Текущий массив (" + carList.size() + " шт.) ---");
        for (int i = 0; i < carList.size(); i++) {
            System.out.println((i + 1) + ") " + carList.get(i));
        }
    }



    private void saveToFile() {                      // доп. задание 2, могу убрать если не надо
        if (carList.isEmpty()) {
            System.out.println("Массив пуст, нечего сохранять.");
            return;
        }
        String path = readNonEmptyLine("Введите путь к файлу (данные будут добавлены в конец файла): ");
        try {
            Writer.appendCarsToFile(carList);
            System.out.println("Данные добавлены в файл: " + path);
        } catch (IOException e) {
            System.out.println("Ошибка записи в файл: " + e.getMessage());
        }
    }



    private int readIntInRange(String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            String line = scanner.nextLine().trim();
            try {
                int value = Integer.parseInt(line);
                if (value < min || value > max) {
                    System.out.println("Введите число в диапазоне от " + min + " до " + max + ".");
                    continue;
                }
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Некорректный ввод. Введите целое число.");
            }
        }
    }

    private String readNonEmptyLine(String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = scanner.nextLine().trim();
            if (!line.isEmpty()) {
                return line;
            }
            System.out.println("Строка не может быть пустой. Попробуйте снова.");
        }
    }

    private int readValidatedInt(String prompt, IntPredicate validator) {
        while (true) {
            System.out.print(prompt);
            String line = scanner.nextLine().trim();
            try {
                int value = Integer.parseInt(line);
                if (!validator.test(value)) {
                    System.out.println("Значение не проходит валидацию. Попробуйте снова.");
                    continue;
                }
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Некорректный ввод. Введите целое число.");
            }
        }
    }

    private String readValidatedString(String prompt, Predicate<String> validator) {
        while (true) {
            System.out.print(prompt);
            String line = scanner.nextLine().trim();
            if (!validator.test(line)) {
                System.out.println("Значение не проходит валидацию. Попробуйте снова.");
                continue;
            }
            return line;
        }
    }



    private List<Car> toList(CarList source) {           // CarList не реализует List, а SortStrategy и CustomRandom ждут List<Car> сделал мост между ними
        List<Car> result = new ArrayList<>();
        for (int i = 0; i < source.size(); i++) {
            result.add(source.get(i));
        }
        return result;
    }

    private CarList fromList(List<Car> source) {
        CarList result = new CarList();
        for (Car car : source) {
            result.add(car);
        }
        return result;
    }
}