package builder;

import car.Car;
import car.CarValidation;

public class Builder {
    private int power;
    private String model;
    private int year;

    public Builder setPower(int power) {
        if (!CarValidation.isValidPower(power)) {
            throw new IllegalArgumentException("Мощность должна быть положительным числом: " + power);
        }
        this.power = power;
        return this;
    }

    public Builder setModel(String model) {
        if (!CarValidation.isValidModel(model)) {
            throw new IllegalArgumentException("Некорректное название модели: " + model);
        }
        this.model = model.trim();
        return this;
    }

    public Builder setYear(int year) {
        if (!CarValidation.isValidYear(year)) {
            throw new IllegalArgumentException("Год выпуска должен быть между 1885 и 2100: " + year);
        }
        this.year = year;
        return this;
    }

    public Car build() {
        if (power == 0 || model == null || year == 0) {
            throw new IllegalStateException("Все поля должны быть заполнены перед созданием объекта");
        }
        return new Car(power, model, year);
    }
}
