package fileReaderWriter;

import car.Car;
import car.CarList;
import car.CarValidation;
import builder.Builder;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

//TODO Реализовать чтение данных из файла и их парсинг в CarList
public class Reader {

    // Читает файл и возвращает CarList.
    // формат строки horsepower,model,year
    // Пример: 200,BMW X5,2020

    public static CarList readCarsFromFile(CarList carList) throws IOException {

        Path path = Path.of("CarsList.txt");
        List<String> errors = new ArrayList<>();

        try (BufferedReader buffer = new BufferedReader(new FileReader(path.toString()))) {
            String line;
            int lineNum = 0;
            while ((line = buffer.readLine()) != null) {
                lineNum++;

                if (line.trim().isEmpty() || line.startsWith("#")) {
                    continue;
                }

                String[] parts = line.trim().split(",");
                if (parts.length != 3) {
                    errors.add("Строка" + lineNum + ":ожидалось 3 поля, получено: " + parts.length);
                    continue;
                }

                try {
                    int power = Integer.parseInt(parts[0].trim());
                    String model = parts[1].trim();
                    int year = Integer.parseInt(parts[2].trim());

                    Car candidate = new Builder()
                            .setPower(power)
                            .setModel(model)
                            .setYear(year)
                            .build();

                    if (!CarValidation.isValidPower(power)) {
                        String errorMessage = "Некорректно указана мощность " + power;
                        errors.add("Строка " + lineNum + " не прошла валидацию: " + errorMessage);
                        continue;

                    } else if (!CarValidation.isValidModel(model)) {
                        String errorMessage = "Некорректное название модели " + model;
                        errors.add("Строка " + lineNum + " не прошла валидацию: " + errorMessage);
                        continue;
                    } else if (!CarValidation.isValidYear(year)) {
                        String errorMessage = "Некорректно указан год ";
                        errors.add("Строка " + lineNum + " не прошла валидацию: " + errorMessage);
                        continue;
                    }
                    carList.add(candidate);

                } catch (NumberFormatException e) {
                    errors.add("Строка " + lineNum + " ошибка чтения: " + line);
                }
            }
        }

        if (!errors.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            sb.append("\nФайл прочитан с ошибками:\n");
            errors.forEach(e -> sb.append("- ").append(e).append("\n"));
            System.out.print(sb);
        }
        System.out.println("Чтение файла " + path + " завершилось: \n- всего " + carList.size() + " машин.");
        return carList;
    }
}