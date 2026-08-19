package sorting;

public class BubbleSortingModel implements Sorting{
    @Override
    public void sortCustom(List<Car> carList){
        int length = carList.size();
        Car temp;
        for (int i = 0; i < length; i++){
            for (int j = 0; j < length - i - 1; j++){
                if (carList.get(j).getModel().compareTo(carList.get(j + 1).getModel()) > 0){
                    temp = carList.get(j);
                    carList.set(j, carList.get(j + 1));
                    carList.set(j + 1, temp);
                }
            }
        }
    }
}