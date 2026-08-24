package strategy;
import model.Car;

import java.util.ArrayList;
import java.util.List;

public class BubbleSortStrategy implements SortStrategy {
    @Override
    public void sortCustom(List<Car> carList, int param){
        int length = carList.size();
        Car temp;
        for (int i = 0; i < length; i++){
            for (int j = 0; j < length - i - 1; j++){
                if (comparison(carList, param, j)){
                    temp = carList.get(j);
                    carList.set(j, carList.get(j + 1));
                    carList.set(j + 1, temp);
                }
            }
        }
    }
    public boolean comparison(List<Car> carList, int param, int j){
        return switch (param){
            case 1 -> (carList.get(j).getYear() > carList.get(j + 1).getYear());
            case 2 -> (carList.get(j).getPower() > carList.get(j + 1).getPower());
            case 3 -> (carList.get(j).getModel().compareTo(carList.get(j + 1).getModel()) > 0);
            case 4 -> (carList.get(j).getYear() > carList.get(j + 1).getYear()) && (carList.get(j).getYear() % 2 == 0 && carList.get(j + 1).getYear() % 2 == 0);
            default -> throw new IllegalArgumentException("Неизвестный параметр: " + param);
        };
    };
}

