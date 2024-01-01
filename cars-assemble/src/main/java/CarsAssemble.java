public class CarsAssemble {

    public double productionRatePerHour(int speed) {
        double carPerHour = 221;
        if (speed == 0) {
            return 0;
        } else if (speed <= 4) {
            return carPerHour * speed;
        } else if (speed <= 8) {
            return carPerHour * speed * 0.9;
        } else if (speed == 9) {
            return carPerHour * speed * 0.8;
        } else {
            return carPerHour * speed * 0.77;
        }

    }

    public int workingItemsPerMinute(int speed) {
        return (int) (productionRatePerHour(speed) / 60);
    }
}
