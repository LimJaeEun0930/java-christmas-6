package christmas;

import christmas.view.InputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        int visitDate = inputView.getVisitDate();
        System.out.println(visitDate);

    }
}
