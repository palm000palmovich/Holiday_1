package pack;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Plan plan = new Plan(3,new int[]{2, 3, 4}, 52000);

        //Заполнение плана. срок, дни недели, бюджет
        System.out.println("Давайте заполним ваш план отпуска.");
        System.out.println("Введите количество дней.");
        int days = scanner.nextInt();
        plan.setCountDays(days);
        scanner.nextLine();
        System.out.println("Введите номера дней(1 - это понедельник, а 7 - это воскресенье).");
        int[] array = new int[days];
        for (int i = 0; i < days; i++){
            array[i] = scanner.nextInt();
            scanner.nextLine();
        }
        plan.setDaysForHoliday(array);

        System.out.println("Введите ваш бюджет.");
        int money = scanner.nextInt();
        plan.setBudget(money);
        scanner.nextLine();
        System.out.println(plan);


        //нахождение 2-х крайних дней
        int[] mas = plan.getDaysForHoliday();
        int max2 = 0, max1 = 8, x1 = 0;
        for (int i = 0; i < mas.length; i++){
            if (mas[i] > max2){
                max2 = mas[i];
                x1 = i;
            }
        }
        for (int i = 0; i < mas.length; i++){
            if (mas[i] < max1 && i != x1){
                max1 = mas[i];
            }
        }

        //Заполнение достопримечательностей и соседних к ним
        Attrections[] attrs = new Attrections[4];
        attrs[0] = new Attrections("Памятник банану", 9.0, 4500, 1, "12:00 - 17:30", 2.5);
        attrs[1] = new Attrections("Зоопарк", 6.5, 2000, 2, "10:00 - 20:00", 3.3);
        attrs[2] = new Attrections("Музей искусства", 7, 3000, 4, "11:30- 19:30", 4.5);
        attrs[3] = new Attrections("Концерт Трэвиса Скотта" , 10.0, 15000, 5, "18:00 - 24:00", 3);

        AttractionsNear[] atNears = new AttractionsNear[4];
        atNears[0] = new AttractionsNear("Матвей", 8.7, 10000, 3, "10:00 - 22:00", 2, 3.1, 1.2);
        atNears[1] = new AttractionsNear("Закрытый пляж", 9.6, 200, 5, "7:00-23:00", 2, 1.8, 0.5);
        atNears[2] = new AttractionsNear("Старый замок", 7.2, 1500, 1, "14:00-20:00", 1, 2.8, 1.0);
        atNears[3] = new AttractionsNear("Парк аттракционов", 5.2, 2500, 4, "10:00-23:00", 1, 0.8, 0.2);

        //Заполнение ресторанов и соседних к ним
        Restaurant[] rests = new Restaurant[4];
        rests[0] = new Restaurant("Франция", 2500, 8.7, "10:00 - 22:00");
        rests[1] = new Restaurant("Турция", 1800, 8.3, "10:00-22:00");
        rests[2] = new Restaurant("Китай", 1500, 7.9, "9:00 - 22:00");
        rests[3] = new Restaurant("Бангладеш", 1790, 9.0, "10:00-22:00");

        RestaurantsNear[] resNears = new RestaurantsNear[4];
        resNears[0] = new RestaurantsNear("Индокитай", 990, 6.7, "08:00 - 23:00",  1.0, 0.3);
        resNears[1] = new RestaurantsNear(" Япония", 800, 7.3, "08:00 - 22:00", 0.3, 0.08);
        resNears[2] = new RestaurantsNear(" Турция", 600, 4.8, "09:00 - 22:00", 0.5, 0.1);
        resNears[3] = new RestaurantsNear(" Бургерная", 1000, 9.4, " 10:00 - 22:00", 0.4, 0.1);

        //Поход  по достопримечательностям

        int totalTime = plan.getCountDays()*16;
        int activeTime = 0;
        int activeBudget = 0;

        System.out.println("Поехали посмотрим на самые главные достопримечательности!");

        for (int i = 0; i < attrs.length; i++){
            if ((activeTime+=attrs[i].getTimeView()) <= totalTime && (max1 <= attrs[i].getDayWork() && max2 >= attrs[i].getDayWork())
            && (activeBudget+=attrs[i].getPrice()) <= plan.getBudget()){
                System.out.println(attrs[i] + "\n");

                //Каждые 3 часа он ест
                if (activeTime >= 3){
                    totalTime-=activeTime;
                    activeTime = 0;
                    System.out.println("Давайте поедим! Выберите ресторан.");
                    for (int j = 0; j < rests.length; j++){
                        if ((activeBudget+rests[j].getPrice()) <= plan.getBudget()){
                            System.out.println(rests[j] + "\t\t\t" + (j+1));
                        }
                    }
                    int numRest = scanner.nextInt();
                    activeBudget+=rests[numRest-1].getPrice();
                } else{
                    totalTime-=activeTime;
                    activeTime=0;
                }
            }
        }
        scanner.nextLine();


        plan.setBudget(plan.getBudget() - activeBudget);
        activeBudget = 0;
        System.out.println("Запас времени: " + totalTime);
        System.out.println("Остаток денег: " + plan.getBudget());

        System.out.println("А теперь погнали погуляем по городу!");
        for (int i = 0; i < atNears.length; i++){
            if ((activeTime+=(atNears[i].getTimeView() + atNears[i].getDriveTime())) <= totalTime && (max1 <= atNears[i].getDayWork() && max2 >= atNears[i].getDayWork())
                    && (activeBudget+=atNears[i].getPrice()) <= plan.getBudget()){
                System.out.println(atNears[i] + "\n");

                //Каждые 5 часов он ест
                if (activeTime >= 5){
                    totalTime-=activeTime;
                    activeTime = 0;
                    System.out.println("Давайте поедим! Выберите ресторан.");
                    for (int j = 0; j < resNears.length; j++){
                        if ((activeBudget+ resNears[j].getPrice()) <= plan.getBudget() && (activeTime+=resNears[j].getDriveTime()) <= totalTime){
                            System.out.println(resNears[j] + "\t\t\t" + (j+1));
                        }
                    }
                    totalTime-=activeTime;
                    int numRest = scanner.nextInt();
                    activeBudget+=resNears[numRest-1].getPrice();
                } else{
                    totalTime-=activeTime;
                    activeTime=0;
                }
            }
        }

        plan.setBudget(plan.getBudget() - activeBudget);
        activeBudget = 0;
        System.out.println("Запас времени: " + totalTime);
        System.out.println("Остаток денег: " + plan.getBudget());


    }
}