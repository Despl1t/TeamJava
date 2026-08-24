package fileReaderWriter;

import car.Car;
import car.CarList;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

//TODO реализовать запись отсортированных данных в файл с возможностью добавление данных в файл и его перезаписи

//Записывает коллекцию автомобилей в файл в режиме добавления
//Каждая строка типа: Power, model, year

public class Writer {

    public static void appendCarsToFile(CarList list) throws IOException {
        Path path = Path.of("SortedCarsList.txt");

        try(BufferedWriter writer = new BufferedWriter(new FileWriter(path.toString(), true))) {
            for (int i = 0; i < list.size(); i++) {
                Car car = list.get(i);
                writer.write(car.getPower() + "," + car.getModel() + "," + car.getYear());
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void overwriteCarsToFile(CarList list) throws IOException {
        Path path = Path.of("SortedCarsList.txt");

        try(BufferedWriter writer = new BufferedWriter(new FileWriter(path.toString(), false))) {
            for (int i = 0; i < list.size(); i++) {
                Car car = list.get(i);
                writer.write(car.getPower() + "," + car.getModel() + "," + car.getYear());
                writer.newLine();
            }
        }
    }
}
