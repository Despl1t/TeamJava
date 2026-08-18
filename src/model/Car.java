package model;

import java.util.Objects;

public class Car implements Comparable<Car> {
    private int power;
    private String model;
    private int year;

    // Private constructor used by Builder
    private Car(int power, String model, int year) {
        this.power = power;
        this.model = model;
        this.year = year;
    }

    public int getPower() { return power; }
    public String getModel() { return model; }
    public int getYear() { return year; }

    @Override
    public int compareTo(Car o) {
        if (o == null) return 1;
        // Базовая сортировка по всем трем полям: мощность -> модель -> год
        int powerCompare = Integer.compare(this.power, o.power);
        if (powerCompare != 0) return powerCompare;

        int modelCompare = this.model.compareTo(o.model);
        if (modelCompare != 0) return modelCompare;

        return Integer.compare(this.year, o.year);
    }

    @Override
    public String toString() {
        return "Автомобиль{" +
                "мощность=" + power +
                ", модель='" + model + '\'' +
                ", год=" + year +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return power == car.power && year == car.year && Objects.equals(model, car.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(power, model, year);
    }

    public static class Builder {
        private int power;
        private String model;
        private int year;

        public Builder setPower(int power) {
            if (power <= 0) throw new IllegalArgumentException("Мощность должна быть положительным числом");
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
            if (year < 1885 || year > 2100) { // First car was around 1886
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
}
