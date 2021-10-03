package baseball.domain;

public class BaseballResult {

	private int strike;
	private int ball;

	public void plusStrike(int strike) {
		this.strike += strike;
	}

	public void plusBall(int ball) {
		this.ball += ball;
	}

	public boolean isPerfect() {
		return strike == 3;
	}
}
