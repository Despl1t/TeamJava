package file_reader_writer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//TODO Реализовать чтение данных из файла и их парсинг в CarList
public class Reader {

    // Читает файл и возвращает CarList.
    // формат строки horsepower,model,year
    // Пример: 200,BMW X5,2020

    public static CarList readCarsFromFile(String path) throws IOException{
        CarList carList = new CarList(16);
        List<String> errors = new ArrayList<>();

        try(BufferedReader buffer = new BufferedReader(new FileReader(path))){
            String line;
            int lineNum = 0;
                while((line = buffer.readLine()) != null) {
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
                        int hoursePower = Integer.parseInt(parts[0].trim());
                        String model = parts[1].trim();
                        int year = Integer.parseInt(parts[2].trim());

                        Car candidate = new Car.Bilder()
                                .setHorsePower(hoursePower)
                                .setModel(model)
                                .setYear(year)
                                .build();

                        if (!CarValidator.isValid(candidate)) {
                            var validationErrors = CarValidator.validateAndCollectErrors(candidate);
                            errors.add("Строка " + lineNum + "не прошла валидацию: " + String.join("; ", validationErrors));
                            continue;
                        }

                        carList.add(candidate);

                   }catch (NumberFormatException e) {
                        errors.add("Строка " + lineNum + ": ошибка чтения '" + line +"'");
                    }
                }
        }

        if (!errors.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            sb.append("Файла прочитан с ошибками:\n");
            errors.forEach(e -> sb.append("- ").append(e).append("\n"));
            System.out.print(sb.toString());
        }
        return carList;
    }
}
