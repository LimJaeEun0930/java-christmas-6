package christmas;

import christmas.menu.Dessert;
import christmas.menu.Drink;
import christmas.menu.IFood;
import christmas.menu.MainMenu;
import java.util.HashMap;

public class AppliedBenefit {
    private IFood giveAway;
    private int christMasDdaySale;
    private int normalDaySale;
    private int weekendSale;
    private int specialSale;
    private Badge eventBadge;


    public void setChristMasDdaySale(int day) {
        if (day >= 1 && day <= 25) {
            this.christMasDdaySale += 900 * (day * 100);
        }
    }
    public void setWeekendSale(HashMap<IFood, Integer> orderDetail) {
        for (IFood food : orderDetail.keySet()) {
            if (food instanceof MainMenu) {
                this.weekendSale += 2023;
            }
        }
    }

    public void setNormalDaySale(HashMap<IFood, Integer> orderDetail) {
        for (IFood food : orderDetail.keySet()) {
            if (food instanceof Dessert) {
                this.normalDaySale += 2023;
            }
        }
    }

    public void setSpecialSale() {
        this.specialSale = 1000;
    }

    public void setGiveAway() {
        this.giveAway = Drink.RED_WINE;
    }
}
