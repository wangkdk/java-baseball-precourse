package baseball.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BaseballNumberTest {

	private final String VALIDATE_SIZE_MESSAGE = "[ERROR] 야구 게임 숫자는 3개만 가능합니다.";
	private final String VALIDATE_DUPLICATE_MESSAGE = "[ERROR] 야구 게임 숫자는 중복될 수 없습니다.";
	private final String VALIDATE_NUMBER_MESSAGE = "[ERROR] 1 ~ 9 사이의 숫자만 입력 가능합니다.";

	@DisplayName("BaseballNumber 객체 생성 테스트")
	@Test
	void initBaseballNumber() {
		BaseballNumber.create(Arrays.asList(1, 2, 3));
	}

	@DisplayName("BaseballNumber 객체 생성 테스트 - 3개 이하의 숫자")
	@Test
	void validateNumber_lessThan() {
		assertThatThrownBy(() -> BaseballNumber.create(Arrays.asList(1, 2)))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(VALIDATE_SIZE_MESSAGE);
	}

	@DisplayName("BaseballNumber 객체 생성 테스트 - 3개 이상의 숫자")
	@Test
	void validateNumber_greaterThan() {
		assertThatThrownBy(() -> BaseballNumber.create(Arrays.asList(1, 2, 3, 4, 5)))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(VALIDATE_SIZE_MESSAGE);
	}

	@DisplayName("BaseballNumber 객체 생성 테스트 - 중복되는 숫자")
	@Test
	void validateNumbers_duplicate() {
		assertThatThrownBy(() -> BaseballNumber.create(Arrays.asList(1, 2, 2)))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(VALIDATE_DUPLICATE_MESSAGE);
	}

	@DisplayName("player BaseballNumber 객체 생성 테스트")
	@Test
	void initPlayerBaseballNumber() {
		BaseballNumber.create("123");
	}

	@DisplayName("player BaseballNumber 객체 생성 테스트 - 2자리 숫자")
	@Test
	void validatePlayerNumber_lessThan() {
		assertThatThrownBy(() -> BaseballNumber.create("12"))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(VALIDATE_SIZE_MESSAGE);
	}

	@DisplayName("player BaseballNumber 객체 생성 테스트 - 5자리 숫자")
	@Test
	void validatePlayerNumber_greaterThan() {
		assertThatThrownBy(() -> BaseballNumber.create("123456"))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(VALIDATE_SIZE_MESSAGE);
	}

	@DisplayName("player BaseballNumber 객체 생성 테스트 - 중복된 숫자 매개변수")
	@Test
	void validatePlayerNumber_duplicate() {
		assertThatThrownBy(() -> BaseballNumber.create("222"))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(VALIDATE_DUPLICATE_MESSAGE);
	}

	@DisplayName("player BaseballNumber 객체 생성 테스트 - 문자 포함")
	@Test
	void validatePlayerNumber_nonNumber() {
		assertThatThrownBy(() -> BaseballNumber.create("a12"))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(VALIDATE_NUMBER_MESSAGE);
	}

	@DisplayName("player BaseballNumber 객체 생성 테스트 - 숫자 0 포함")
	@Test
	void validatePlayerNumber_zero() {
		assertThatThrownBy(() -> BaseballNumber.create("022"))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(VALIDATE_NUMBER_MESSAGE);
	}

	@DisplayName("상대방의 숫자와 플레이어의 숫자를 비교 - 3 strike")
	@Test
	void checkBaseballNumbers_three_strike() {
		BaseballNumber baseballNumber = BaseballNumber.create(Arrays.asList(1, 2, 3));
		BaseballNumber playerBaseballNumber = BaseballNumber.create("123");

		BaseballResult baseballResult = baseballNumber.match(playerBaseballNumber);
		assertThat(baseballResult).extracting("strike").isEqualTo(3);
		assertTrue(baseballResult.isPerfect());
	}

	@DisplayName("상대방의 숫자와 플레이어의 숫자를 비교 - 1 strike 1 ball")
	@Test
	void checkBaseballNumbers_one_strike_one_ball() {
		BaseballNumber baseballNumber = BaseballNumber.create(Arrays.asList(1, 2, 3));
		BaseballNumber playerBaseballNumber = BaseballNumber.create("135");

		BaseballResult baseballResult = baseballNumber.match(playerBaseballNumber);
		assertThat(baseballResult).extracting("strike").isEqualTo(1);
		assertThat(baseballResult).extracting("ball").isEqualTo(1);
		assertFalse(baseballResult.isPerfect());
	}
}
