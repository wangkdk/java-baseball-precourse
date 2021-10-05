package baseball.controller;

import baseball.domain.BaseballNumber;
import baseball.domain.BaseballNumberGenerator;
import baseball.domain.BaseballResult;
import baseball.view.BaseballInputView;
import baseball.view.BaseballRestartView;
import baseball.view.BaseballResultView;

public class BaseballController {
	public static void start() {
		BaseballNumber baseballNumber = BaseballNumber.create(BaseballNumberGenerator.generateNonDuplicateNumbers());
		boolean isAnswer;
		do {
			BaseballNumber playerBaseballNumber = BaseballInputView.inputBaseballNumber();
			BaseballResult matchResult = baseballNumber.match(playerBaseballNumber);
			BaseballResultView.printMatchResult(matchResult);
			isAnswer = matchResult.isPerfect();
		} while (!isAnswer);
		reStart();
	}

	public static void reStart() {
		if (BaseballRestartView.selectRestart()) {
			start();
		}
	}
}
