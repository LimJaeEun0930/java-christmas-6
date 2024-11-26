package christmas;

import java.util.Arrays;
import java.util.HashSet;

public class Constants {
    public static final String INPUT_MESSAGE_VISIT_DATE = "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)";
    public static final String INPUT_MESSAGE_ORDER_MENU = "주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)";
    public static final String INPUT_MESSAGE_UNVALID_ORDER = "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.";

    public static final HashSet<Integer> starredDays = new HashSet<>(Arrays.asList(3, 10, 17, 24, 25, 31));
    public static final int Price_Qualified_To_Get_GiveAway = 120000;

}
