package christmas.view;

import christmas.AppliedBenefit;
import christmas.menu.IFood;
import java.util.HashMap;

public class OutputView {
    private static OutputView outputView;

    public static OutputView getInstance() {
        if (outputView == null) {
            outputView = new OutputView();
        }
        return outputView;
    }

    private OutputView() {

    }
    public void printWelcomeMessage() {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
    }

    public void printPreviewEventBenefit(HashMap<IFood, Integer> orderDetail, AppliedBenefit benefit) {
        System.out.println("12월 3일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");
        printOrderMenues(orderDetail);
        printTotalPriceBeforeDiscount(orderDetail);
        printGiveAway(benefit);
        printBenefitList(benefit);
        printTotalBenefitPrice(benefit);
        printExpectedPriceAfterDiscount(orderDetail, benefit);
        printBadge(benefit);
    }

    private void printBadge(AppliedBenefit benefit) {
        System.out.println("<12월 이벤트 배지>");
        int totalBenefitPrice = getTotalBenefitPrice(benefit);
        if (totalBenefitPrice < 5000) {
            System.out.println("없음");
        }
        if (totalBenefitPrice >= 5000 && totalBenefitPrice < 10000) {
            System.out.println("별");
        }
        if (totalBenefitPrice >= 10000 && totalBenefitPrice < 20000) {
            System.out.println("트리");
        }
        if (totalBenefitPrice >= 20000) {
            System.out.println("산타");
        }
    }

    private void printExpectedPriceAfterDiscount(HashMap<IFood, Integer> orderDetail, AppliedBenefit benefit) {
        System.out.println("<할인 후 예상 결제 금액>");
        System.out.printf("%,d원" + "%n" + "%n", getTotalPriceBeforeDiscount(orderDetail) - getTotalDiscountPrice(benefit));
    }
    private void printOrderMenues(HashMap<IFood, Integer> orderDetail) {
        System.out.println();
        System.out.println("<주문 메뉴>");
        for (IFood food : orderDetail.keySet()) {
            System.out.printf("%s %d개" + "%n", food.getMenuName(), orderDetail.get(food));
        }
    }

    private void printTotalPriceBeforeDiscount(HashMap<IFood, Integer> orderDetail) {
        int sum = getTotalPriceBeforeDiscount(orderDetail);
        System.out.println();
        System.out.println("<할인 전 총주문 금액>");
        System.out.printf("%,d원" + "%n", sum);
        System.out.println();
    }

    private static int getTotalPriceBeforeDiscount(HashMap<IFood, Integer> orderDetail) {
        int sum = 0;
        for (IFood food : orderDetail.keySet()) {
            int foodCount = orderDetail.get(food);
            sum += food.getMenuPrice() * foodCount;
        }
        return sum;
    }

    private void printGiveAway(AppliedBenefit benefit) {
        System.out.println("<증정 메뉴>");
        IFood giveAway = benefit.getGiveAway();
        if (giveAway == null) {
            System.out.println("없음");
            return;
        }
        System.out.println(giveAway.getMenuName() + " 1개");
    }

    private void printBenefitList(AppliedBenefit benefit) {
        System.out.println();
        System.out.println("<혜택 내역>");
        boolean hasBenefit = false;
        hasBenefit |= printChristMasDdayDiscount(benefit);
        hasBenefit |= printDayDiscount(benefit);
        hasBenefit |= printSpecialDiscount(benefit);
        hasBenefit |= printGiveAwayEvent(benefit);
        if (!hasBenefit) {
        System.out.println("없음");
        }
    }

    private boolean printGiveAwayEvent(AppliedBenefit benefit) {
        if (benefit.getGiveAway() != null) {
            System.out.printf("증정 이벤트: -%,d원" + "%n", benefit.getGiveAway().getMenuPrice());
            return true;
        }
        return false;
    }

    private boolean printSpecialDiscount(AppliedBenefit benefit) {
        if (benefit.getSpecialSale() > 0) {
            System.out.printf("특별 할인: -%,d원" + "%n", benefit.getSpecialSale());
            return true;
        }
        return false;
    }

    private boolean printChristMasDdayDiscount(AppliedBenefit benefit) {
        if (benefit.getChristMasDdaySale() > 0) {
            System.out.printf("크리스마스 디데이 할인: -%,d원" + "%n", benefit.getChristMasDdaySale());
            return true;
        }
        return false;
    }

    private boolean printDayDiscount(AppliedBenefit benefit) {
        if (benefit.getNormalDaySale() > 0) {
            System.out.printf("평일 할인: -%,d원" + "%n", benefit.getNormalDaySale());
            return true;
        }
        if (benefit.getWeekendSale() > 0) {
            System.out.printf("주말 할인: -%,d원" + "%n", benefit.getWeekendSale());
            return true;
        }
        return false;
    }

    private void printTotalBenefitPrice(AppliedBenefit benefit) {
        System.out.println("<총혜택 금액>");
        System.out.printf("%,d원" + "%n" + "%n", getTotalBenefitPrice(benefit));

    }
    private int getTotalBenefitPrice(AppliedBenefit benefit) {
        int discountPrice = getTotalDiscountPrice(benefit);
        if (benefit.getGiveAway() != null) {
            discountPrice += benefit.getGiveAway().getMenuPrice();
            return discountPrice;
        }
        return discountPrice;
    }
    private int getTotalDiscountPrice(AppliedBenefit benefit) {
        return benefit.getChristMasDdaySale() + benefit.getSpecialSale() + benefit.getNormalDaySale()
                + benefit.getWeekendSale();
    }

}
