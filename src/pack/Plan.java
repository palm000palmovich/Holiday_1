package pack;

import java.util.Arrays;

public class Plan {

    private int countDays;
    private int[] daysForHoliday;
    private int budget;

    //конструктор
    public Plan(int days, int[] daysForHoliday, int budget){
        this.countDays = days;
        this.daysForHoliday = daysForHoliday;
        this.budget = budget;
    }


    //Геттеры

    public int getCountDays(){
        return this.countDays;
    }

    public int[] getDaysForHoliday(){
        short flag = 1;
        if (this.daysForHoliday.length < this.countDays){
            flag = 0;
            throw new IllegalArgumentException("Вы не дописали дни недели!");
        } else{
            for (int i = 0; i < this.daysForHoliday.length; i++){
                if (this.daysForHoliday[i] >= 1 && this.daysForHoliday[i] <= 7){
                    flag = 1;
                } else {
                    flag = 0;
                    throw new IllegalArgumentException("Недопустимое значение дня недели!");
                }
            }
        }
        if (flag != 1){
            throw new IllegalArgumentException("Исправьте аргументы!");
        }
        return this.daysForHoliday;
    }

    public int getBudget(){
        if (this.budget < 0){
            throw new IllegalArgumentException("Недопустимое значения бюджета!");
        }
        return this.budget;
    }

    //Сеттеры
    public void setCountDays(int newCount){
        this.countDays = newCount;
    }

    public void setDaysForHoliday(int[] newDays){
        this.daysForHoliday = newDays;
    }

    public void setBudget(int newBudget){
        this.budget = newBudget;
    }


    @Override
    public String toString() {
        return "Количество дней: " + countDays + " дни отдыха: " + Arrays.toString(daysForHoliday) +
                ", бюджет: " + budget;
    }

}
