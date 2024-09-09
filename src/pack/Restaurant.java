package pack;

public class Restaurant{

    private String kitchen;
    private int price;
    private double rayting;
    private String hours;

    public Restaurant(String kitchen, int price, double rayting, String hours){
        this.kitchen = kitchen;
        this.price = price;
        this.rayting = rayting;
        this.hours = hours;
    }

    public String getKitchen() {
        return kitchen;
    }

    public void setKitchen(String kitchen) {
        this.kitchen = kitchen;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public double getRayting() {
        return rayting;
    }

    public void setRayting(double rayting) {
        this.rayting = rayting;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    @Override
    public String toString() {
        return "Кухня: " + kitchen + ',' + '\n' +
                " стоиомость " + price +
                ", рейтинг " + rayting +
                ", часы работы " + hours ;
    }

}
