package model;

import java.util.ArrayList;
import java.util.List;

public class CarList {

    private final List<Car> cars = new ArrayList<>();


    public void add(Car car) {
        if (car == null) {
            throw new IllegalArgumentException("Автомобиль не может быть null");
            }
        cars.add(car);
        }

    public Car get(int index) {
        return cars.get(index);
    }

    public void set(int index, Car car) {
        if (car == null) {
            throw new IllegalArgumentException("Автомобиль не может быть null");
        }

        cars.set(index, car);
    }

    public int size(){
        return cars.size();
    }

    public Car remove(int index) {
        return cars.remove(index);
    }

    public boolean isEmpty() {
        return cars.isEmpty();
    }
}
