package baseball.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BaseballResultTest {

	private BaseballResult baseballResult;

	@BeforeEach
	void setup() {
		baseballResult = new BaseballResult();
	}

	@DisplayName("3 스트라이크")
	@Test
	void three_strike() {
		baseballResult.plusStrike(3);
		assertTrue(baseballResult.isPerfect());
	}

	@DisplayName("1 스트라이크 1 볼")
	@Test
	void one_strike_one_ball() {
		baseballResult.plusBall(1);
		baseballResult.plusStrike(1);
		assertFalse(baseballResult.isPerfect());
	}
}
