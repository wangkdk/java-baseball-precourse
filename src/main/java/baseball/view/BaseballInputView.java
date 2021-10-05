package baseball.view;

import baseball.domain.BaseballNumber;
import nextstep.utils.Console;

public class BaseballInputView {
    private final static String INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요: ";

    private BaseballInputView() {
    }

    public static BaseballNumber inputBaseballNumber() {
        System.out.print(INPUT_NUMBER_MESSAGE);
        String inputNumbers = Console.readLine();
        try {
            return BaseballNumber.create(inputNumbers);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return inputBaseballNumber();
        }
    }
}
