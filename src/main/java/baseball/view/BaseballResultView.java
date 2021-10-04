package baseball.view;

import baseball.domain.BaseballResult;

public class BaseballResultView {

	public static void printMatchResult(BaseballResult result) {
		System.out.println(result.getResultMessage());
		if (result.isPerfect()) {
			System.out.println(result.getPerfectMessage());
		}
	}
}
