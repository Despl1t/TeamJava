package car;

public final class CarValidation {

    private CarValidation() {
    }

    public static boolean isValid(int power, String model, int year) {

        if (power <= 0) {
            return false;
        } else if (model == null || model.trim().isEmpty()) {
            return false;
        } else if (!model.matches("[a-zA-Zа-яА-ЯёЁ0-9 -]+")) {
            return false;
        } else if (year < 1885 || year > 2100) {
            return false;
        }

        return true;
    }
}