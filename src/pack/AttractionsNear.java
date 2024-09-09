package pack;

public class AttractionsNear extends Attrections{
    private double distance;
    private double driveTime;

    public AttractionsNear(String name, double rayting, int price, int dayWork, String hourWork, int timeView, double distance, double driveTime){
        super(name, rayting, price, dayWork, hourWork, timeView);
        this.distance = distance;
        this.driveTime = driveTime;
    }

    public double getDistance(){
        return this.distance;
    }

    public double getDriveTime(){
        return this.driveTime;
    }

    @Override
    public String toString() {
        return   getName() + " идти: " + distance + " км, " + driveTime + " час.";
    }

}
