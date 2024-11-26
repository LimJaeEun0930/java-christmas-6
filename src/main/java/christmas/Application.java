package christmas;

import christmas.menu.IFood;
import christmas.view.InputView;
import java.util.HashMap;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        //int visitDate = inputView.getVisitDate();
        //System.out.println(visitDate);
        HashMap<IFood, Integer> foodOrder = inputView.getFoodOrder();
        for (IFood food : foodOrder.keySet()) {
            System.out.println(food.getMenuName() + foodOrder.get(food));

        }
    }
}
