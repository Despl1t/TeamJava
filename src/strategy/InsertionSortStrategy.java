package strategy;

import model.Car;

import java.util.ArrayList;
import java.util.List;

public class InsertionSortStrategy implements SortStrategy {
    @Override
    public void sortCustom(List<Car> carList, int param){
        if (param == 4){
            sortEvenYears(carList);
            return;
        }

        for (int i = 1; i < carList.size(); i++){
            Car key = carList.get(i);
            int j = i - 1;
            while(j >= 0 && comparison(carList, param, key, j)){
                carList.set(j, carList.get(j + 1));
                j--;
            }
            carList.set(j + 1, key);
        }
    }

    public boolean comparison(List<Car> carList, int param, Car key, int j){
        return switch (param){
            case 1 -> (carList.get(j).getYear() > key.getYear());
            case 2 -> (carList.get(j).getPower() > key.getPower());
            case 3 -> (carList.get(j).getModel().compareTo(key.getModel()) > 0);
            default -> throw new IllegalArgumentException("Неизвестный параметр: " + param);
        };
    }
    public void sortEvenYears(List<Car> carList){
        List<Car> temp = new ArrayList<>();
        for (Car car : carList) {
            if (car.getYear() % 2 == 0) {
                temp.add(car);
            }
        }

        sortCustom(temp, 1);

        int evenI = 0;
        for (int i = 0; i < carList.size(); i++){
            if (carList.get(i).getYear() % 2 == 0){
                carList.set(i, temp.get(evenI));
                evenI++;
            }
        }
    }
}
