package sorting;

public class BubbleSortingYear implements Sorting{
    @Override
    public void sortCustom(List<Car> carList){
        int length = carList.size();
        Car temp;
        for (int i = 0; i < length; i++){
            for (int j = 0; j < length - i - 1; j++){
                if (carList.get(j).getYear().compareTo(carList.get(j + 1).getYear()) > 0){
                    temp = carList.get(j);
                    carList.set(j, carList.get(j + 1));
                    carList.set(j + 1, temp);
                }
            }
        }
    }
}