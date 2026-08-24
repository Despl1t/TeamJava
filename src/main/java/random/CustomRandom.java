package random;
import model.Car;
import builder.Builder;
import java.util.Random;
import java.util.List;
import java.util.Scanner;

public class CustomRandom{
    public void FIllRandom(List<Car> carList){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число рандомных объектов: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Введите ЦЕЛОЕ ЧИСЛО:");
            scanner.next();
        }
        int input = scanner.nextInt();
        String[] randomModel = new String[]{"Toyota Camry", "BMW 3 Series", "Audi A4", "Mercedes-Benz C-Class", "Ford Mustang", "Volkswagen Golf", "Honda Civic", "Hyundai Sonata", "Kia Sportage", "Nissan Qashqai", "Mazda CX-5", "Subaru Forester", "Volvo XC60", "Lexus RX", "Chevrolet Camaro", "Porsche 911", "Tesla Model 3", "Renault Megane", "Skoda Octavia", "Mitsubishi Outlander"};
        Random rand = new Random();
        for (int i = 0; i < input; i++){

            carList.add(new Builder()
                    .setModel(randomModel[rand.nextInt(20)])
                    .setYear(rand.nextInt(2026 - 1980 + 1) + 1980)
                    .setPower(rand.nextInt(300 - 100 + 1) + 100)
                    .build()
            );
        }
    }
}