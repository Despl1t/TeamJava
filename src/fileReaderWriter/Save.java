package fileReaderWriter;

import car.Car;
import car.CarList;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

public class Save {

    public static void overwriteMemory(CarList list) throws IOException {
        Path path = Path.of("MemoryList.txt");

        try(BufferedWriter writer = new BufferedWriter(new FileWriter(path.toString(), false))) {
            for (int i = 0; i < list.size(); i++) {
                Car car = list.get(i);
                writer.write(car.getPower() + "," + car.getModel() + "," + car.getYear());
                writer.newLine();
            }
        }
    }
}
