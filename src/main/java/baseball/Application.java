package baseball;

import baseball.controller.BaseballController;

public class Application {
    public static void main(String[] args) {
        BaseballController baseball = new BaseballController();
        baseball.start();
    }
}
