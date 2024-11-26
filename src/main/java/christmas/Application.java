package christmas;

import christmas.controller.Controller;
import christmas.menu.IFood;
import christmas.view.InputView;
import java.util.HashMap;

public class Application {
    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.run();
    }
}
