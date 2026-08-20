package fileReaderWriter;

import car.Car;
import car.CarList;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

//TODO реализовать запись отсортированных данных в файл с возможностью добавление данных в файл и его перезаписи

    //Записывает коллекцию автомобилей в файл в режиме добавления
    //Каждая строка типа: Power, model, year

public class Writer {

    public static void appendCarsToFile(String path, CarList list)) throws IOExceprion {

        try(BufferedWriter writer = new BufferedWriter(new FileWriter(path, true))) {
            for (int i = 0; i < list.size(); i++) {
                Car car = list.get(i);
                writer.write(car.getPower+ ", " + car.getModel() + ", " + car.getYear());
                writer.newLine();
            }
        }
    }
    public static void overwriteCarsToFile(String path, CarList list) throws IOException {

        try(BufferedWriter writer = new BufferedWriter(new FileWriter(path, false))) {
            for (int i = 0; i < list.size(); i++) {
                Car car = list.get(i);
                writer.write(car.getPower() + ", " + car.getModel() + ", " + car.getYear());
                writer.newLine();
            }
        }
    }
}
