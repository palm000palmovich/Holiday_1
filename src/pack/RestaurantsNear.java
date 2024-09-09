package pack;

public class RestaurantsNear extends Restaurant{
    private double distance;
    private double driveTime;

    public RestaurantsNear(String kitchen, int price, double rayting, String hours, double distance, double driveTime){
        super(kitchen, price, rayting, hours);
        this.distance = distance;
        this.driveTime = driveTime;
    }

    public double getDistanceRest(){
        return this.distance;
    }

    public double getDriveTime(){
        return this.driveTime;
    }

    @Override
    public String toString() {
        return getKitchen() + "идти " + distance + " км, ехать " + driveTime + " час.";
    }

}
