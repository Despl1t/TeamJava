package car;

public final class CarValidation {

    private CarValidation() {
    }

    public static boolean isValidPower(int power) {
        return power > 0;
    }

    public static boolean isValidModel(String model) {
        if (model == null) {
            return false;
        }

        if (model.trim().isEmpty()) {
            return false;
        }

        return model.matches("[a-zA-Zа-яА-ЯёЁ0-9 -]+");
    }

    public static boolean isValidYear(int year) {
        return year >= 1885 && year <= 2100;
    }
}