public class ElonsToyCar {
    private int battery = 100;
    private int distance = 0;

    public static ElonsToyCar buy() {
        return new ElonsToyCar();
    }

    public String distanceDisplay() {
        return "Driven " + Integer.toString(this.distance) + " meters";
    }

    public String batteryDisplay() {
        if (this.battery == 0) {
            return "Battery empty";
        }
        return "Battery at " + Integer.toString(this.battery) + "%";
    }

    public void drive() {
        if (this.battery > 0) {
            this.battery -= 1;
            this.distance += 20;
        }

    }

}
