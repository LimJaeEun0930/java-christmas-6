package christmas.view;

import static christmas.Constants.*;

import camp.nextstep.edu.missionutils.Console;
import christmas.exception.UnvalidDateException;

public class InputView {

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
