package sorting;
import model.Car;
import java.util.List;

public class BubbleSortingPower implements Sorting{
    @Override
    public void sortCustom(List<Car> carList){
        int length = carList.size();
        Car temp;
        for (int i = 0; i < length; i++){
            for (int j = 0; j < length - i - 1; j++){
                if (carList.get(j).getPower() > carList.get(j + 1).getPower()){
                    temp = carList.get(j);
                    carList.set(j, carList.get(j + 1));
                    carList.set(j + 1, temp);
                }
            }
        }
    }
}