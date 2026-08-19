package strategy;
import java.util.List;
import model.Car;


public interface SortStrategy {
    public void sortCustom(List<Car> carList);
}