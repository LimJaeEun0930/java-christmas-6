package christmas.view;

import static christmas.Constants.*;

import camp.nextstep.edu.missionutils.Console;
import christmas.exception.UnvalidDateException;
import christmas.menu.Drink;
import christmas.menu.IFood;
import christmas.menu.MenuUtil;
import java.util.HashMap;

public class InputView {
    private static InputView inputView;

    public static InputView getInstance() {
        if (inputView == null) {
            inputView = new InputView();
        }
        return inputView;
    }

    private InputView() {

    }

    public int getVisitDate() {
        while (true) {
            try {
                String input = input(INPUT_MESSAGE_VISIT_DATE);
                int day = Integer.parseInt(input);
                isValidDate(day);
                return day;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
            }
        }
    }

    public HashMap<IFood, Integer> getFoodOrder() {

        while (true) {
            try {
                String input = input(INPUT_MESSAGE_ORDER_MENU);
                return makeOrderDetails(input);
            } catch (RuntimeException e) {
                System.out.println(INPUT_MESSAGE_UNVALID_ORDER);
            }
        }
    }

    private HashMap<IFood, Integer> makeOrderDetails(String input) throws RuntimeException {
        HashMap<IFood, Integer> orderDetails = new HashMap<>();
        String[] orders = input.split(",");
        for (String order : orders) {
            String menuName = order.substring(0, order.indexOf('-'));
            int count = Integer.parseInt(order.substring(order.indexOf('-') + 1));
            IFood food = MenuUtil.getFoodByName(menuName);
            makeOrderDetaiHashMap(orderDetails, food, count);
        }
        if (orderDetails.keySet().iterator().next() instanceof Drink) {
            throw new IllegalArgumentException();
        }
        return orderDetails;
    }

    private void makeOrderDetaiHashMap(HashMap<IFood, Integer> orderDetail, IFood food, int count) throws IllegalArgumentException{
        int sum = 0;
        for (Integer foodCount : orderDetail.values()) {
            sum += foodCount;
        }
        if (count < 1 || sum + count > 20 || orderDetail.containsKey(food)) {
            throw new IllegalArgumentException();
        }
        orderDetail.put(food, count);
    }

    private boolean isValidDate(int day) throws UnvalidDateException{
        if (1 <= day && 31 >= day) {
            return true;
        }
        throw new UnvalidDateException();
    }

    private String input(String displayMessage, Object... args) {
        System.out.printf(displayMessage + "%n", args);
        String input = Console.readLine();
        return input;
    }
}
