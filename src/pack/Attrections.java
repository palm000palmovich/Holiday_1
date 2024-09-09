package pack;


public class Attrections {
    private String name;
    private double rayting;
    private int price;
    private String hourWork;
    private int dayWork;
    private double timeView;


    //Констрктор
    public Attrections(String name, double rayting, int price, int dayWork, String hourWork, double timeView) {
        this.name = name;
        this.rayting = rayting;
        this.price = price;
        this.dayWork = dayWork;
        this.hourWork = hourWork;
        this.timeView = timeView;
    }

    //Геттеры

    public String getName() {
        return name;
    }

    public double getRayting() {
        if (this.rayting < 0){
            this.name = null;
            this.price = 0;
            this.hourWork = null;
        }

        return rayting;
    }

    public int getPrice() {
        return price;
    }

    public int getDayWork() {
        return dayWork;
    }

    public String getHourWork() {
        return hourWork;
    }

    public double getTimeView() {
        return timeView;
    }

    @Override
    public String toString() {
        return "название: " + name + ',' + '\n' +
                "рейтинг: " + rayting +
                ", стоиомость: " + price +
                ", рабочие дни: " + dayWork + ',' + '\n' +
                "рабочие часы: " + hourWork  +
                ", время осмотра: " + timeView;
    }
}
