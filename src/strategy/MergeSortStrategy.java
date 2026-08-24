package strategy;

import model.Car;

import java.util.ArrayList;
import java.util.List;

public class MergeSortStrategy implements SortStrategy{
    @Override
    public void sortCustom(List<Car> carList, int param){
        if (param == 4){
            sortEvenYears(carList);
            return;
        }
        mergeSort(carList, 0, carList.size() - 1, param);
    }

    private void mergeSort(List<Car> carList, int left, int right, int param){
        if (left >= right){
            return;
        }

        int middle = (left + right) / 2;
        mergeSort(carList, left, middle, param);
        mergeSort(carList, middle + 1, right, param);

        merge(carList, left, middle, right, param);
    }

    private void merge(List<Car> carList, int left, int middle, int right, int param){
        List<Car> temp = new ArrayList<>();
        int i = left;
        int j = middle + 1;
        while ((i <= middle) && (j <= right)){
            if (!comparison(carList, i, j, param)){
                temp.add(carList.get(i));
                i++;
            }else{
                temp.add(carList.get(j));
                j++;
            }
        }

        while (i <= middle){
            temp.add(carList.get(i));
            i++;
        }

        while (j <= right){
            temp.add(carList.get(j));
            j++;
        }
        for (int k = 0; k < temp.size(); k++){
            carList.set(left + k, temp.get(k));
        }
    }
    private void sortEvenYears(List<Car> carList){
        List<Car> temp = new ArrayList<>();
        for (Car car : carList) {
            if (car.getYear() % 2 == 0) {
                temp.add(car);
            }
        }

        mergeSort(temp, 0, temp.size() - 1, 1);

        int evenI = 0;

        for (int i = 0; i < carList.size() - 1; i++){
            if (carList.get(i).getYear() % 2 == 0){
                carList.set(i, temp.get(evenI));
                evenI++;
            }
        }
    }

    private boolean comparison(List<Car> carList, int i, int j, int param){
        return switch (param) {
            case 1 -> carList.get(i).getYear() > carList.get(j).getYear();
            case 2 -> carList.get(i).getPower() > carList.get(j).getPower();
            case 3 -> carList.get(i).getModel().compareTo(carList.get(j).getModel()) > 0;
            default -> throw new IllegalArgumentException("Неизвестный параметр: " + param);
        };
    }
}
