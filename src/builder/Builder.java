package builder;

import model.Car;

public class Builder {
    private int power;
    private String model;
    private int year;

    public Builder setPower(int power) {
        if (power <= 0) {
            throw new IllegalArgumentException("Мощность должна быть положительным числом");
        }
        this.power = power;
        return this;
    }

    public Builder setModel(String model) {
        if (model == null || model.trim().isEmpty()) {
            throw new IllegalArgumentException("Модель не может быть пустой");
        }
        this.model = model;
        return this;
    }

    public Builder setYear(int year) {
        if (year < 1885 || year > 2100) {
            throw new IllegalArgumentException("Год выпуска должен быть между 1885 и 2100");
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
