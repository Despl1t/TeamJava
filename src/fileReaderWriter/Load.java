package fileReaderWriter;

import builder.Builder;
import car.Car;
import car.CarList;
import car.CarValidation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Load {

    public static CarList readMemory(CarList carList) throws IOException {
        Path path = Path.of("MemoryList.txt");
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
        System.out.println("\nЧтение файла " + path + " завершилось: \n- всего " + carList.size() + " машин.");
        return carList;
    }
}

