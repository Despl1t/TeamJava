package strategy;
import model.Car;
import java.util.List;

public class ExtraSortStrategyYear implements SortStrategy{
    @Override
    public void sortCustom(List<Car> carList){
        int length = carList.size();
        Car temp;
        for (int i = 0; i < length; i++){
            for (int j = 0; j < length - i - 1; j++){
                if (carList.get(j).getYear() > carList.get(j + 1).getYear()){
                    if (carList.get(j).getYear() % 2 == 0 && carList.get(j + 1).getYear() % 2 == 0){ //доп сравнение
                        temp = carList.get(j);
                        carList.set(j, carList.get(j + 1));
                        carList.set(j + 1, temp);
                    }
                }
            }
        }
    }
}