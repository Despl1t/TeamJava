package builder;

import car.Car;
import car.CarValidation;

public class Builder {
    private int power;
    private String model;
    private int year;

    public Builder setPower(int power) {

        this.power = power;
        return this;
    }

    public Builder setModel(String model) {

        this.model = model.trim();
        return this;
    }

    public Builder setYear(int year) {

        this.year = year;
        return this;
    }

    public Car build() {

        return new Car(power, model, year);
    }
}
