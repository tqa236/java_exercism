import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TestTrack {

    public static void race(RemoteControlCar car) {
        car.drive();
    }

    public static List<ProductionRemoteControlCar> getRankedCars(List<ProductionRemoteControlCar> cars) {
        List<ProductionRemoteControlCar> sortedCars = new ArrayList<ProductionRemoteControlCar>(cars);
        Collections.sort(sortedCars);
        return sortedCars;
    }
}
