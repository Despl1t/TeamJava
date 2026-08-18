public final class Car implements Comparable<Car> {
    private final int power;
    private final String model;
    private final int year;

    public Car(int power, String model, int year) {
        this.power = power;
        this.model = model;
        this.year = year;
    }

    public int getPower() {
        return power;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    @Override
    public int compareTo(Car o) {
        if (o == null) return 1;

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
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        Car car = (Car) object;

        return power == car.power
                && year == car.year
                && Objects.equals(model, car.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(power, model, year);
    }
}