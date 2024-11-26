package christmas.controller;

import christmas.AppliedBenefit;
import christmas.Service;
import christmas.menu.IFood;
import christmas.view.InputView;
import christmas.view.OutputView;
import java.util.HashMap;

public class Controller {
    private InputView inputView = InputView.getInstance();
    private OutputView outputView = OutputView.getInstance();
    private Service service = Service.getInstance();

    public void run() {
        outputView.printWelcomeMessage();
        int visitDate = inputView.getVisitDate();
        HashMap<IFood, Integer> foodOrder = inputView.getFoodOrder();
        AppliedBenefit appliedBenefit = service.ProcessBenefit(visitDate, foodOrder);
        outputView.printPreviewEventBenefit(foodOrder, appliedBenefit);
    }
}
