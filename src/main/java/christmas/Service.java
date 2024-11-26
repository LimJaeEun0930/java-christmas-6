package christmas;

//import static christmas.Constants.Price_Qualified_To_Get_GiveAway;

import christmas.menu.IFood;
import java.util.HashMap;

public class Service {
    private static Service service;

    public static Service getInstance() {
        if (service == null) {
            service = new Service();
        }
        return service;
    }
    private Service() {

    }

    public AppliedBenefit ProcessBenefit(int day, HashMap<IFood, Integer> orderDetail) {
        AppliedBenefit benefit = new AppliedBenefit();
        benefit.setChristMasDdaySale(day);
        if (isWeekend(day)) {
            benefit.setWeekendSale(orderDetail);
        }
        if (!isWeekend(day)) {
            benefit.setNormalDaySale(orderDetail);
        }
        if (Constants.starredDays.contains(day)) {
            benefit.setSpecialSale();
        }
        if (hasQualifyToGetGiveAway(orderDetail)) {
            benefit.setGiveAway();
        }
        return benefit;
    }

    private boolean hasQualifyToGetGiveAway(HashMap<IFood, Integer> orderDetail) {
        int sum = 0;
        for (IFood food : orderDetail.keySet()) {
            int foodCount = orderDetail.get(food);
            sum += food.getMenuPrice() * foodCount;
        }
        if (sum >= Constants.Price_Qualified_To_Get_GiveAway) {
            return true;
        }
        return false;
    }
    private boolean isWeekend(int day) {
        for (int i = 0; i <= 4; ++i) {
            if (day == 1 + i * 7 || day == 2 + i * 7) {
                return true;
            }
        }
        return false;
    }
}
