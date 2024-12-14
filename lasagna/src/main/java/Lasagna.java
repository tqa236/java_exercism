public class Lasagna {
    public int expectedMinutesInOven() {
        return 40;
    }

    public int remainingMinutesInOven(int active_time) {
        return expectedMinutesInOven() - active_time;
    }

    public int preparationTimeInMinutes(int layer) {
        return 2 * layer;
    }

    public int totalTimeInMinutes(int layer, int active_time) {
        return preparationTimeInMinutes(layer) + active_time;
    }
}
