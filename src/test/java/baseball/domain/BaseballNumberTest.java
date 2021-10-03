package baseball.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BaseballNumberTest {

	private final String VALIDATE_SIZE_MESSAGE = "[ERROR] 야구 게임 숫자는 3개만 가능합니다.";
	private final String VALIDATE_DUPLICATE_MESSAGE = "[ERROR] 야구 게임 숫자는 중복될 수 없습니다.";
	private final String VALIDATE_NUMBER_MESSAGE = "[ERROR] 1 ~ 9 사이의 숫자만 입력 가능합니다.";

	@DisplayName("BaseballNumber 객체 정상 생성 테스트")
	@Test
	void initBaseballNumber() {
		BaseballNumber.create(Arrays.asList(1, 2, 3));
	}

	@DisplayName("3개 이하의 숫자로 생성시 실패 테스트")
	@Test
	void validateNumber_lessThan() {
		assertThatThrownBy(() -> BaseballNumber.create(Arrays.asList(1, 2)))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(VALIDATE_SIZE_MESSAGE);
	}

	@DisplayName("3개 이상의 숫자로 생성시 실패 테스트")
	@Test
	void validateNumber_greaterThan() {
		assertThatThrownBy(() -> BaseballNumber.create(Arrays.asList(1, 2, 3, 4, 5)))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(VALIDATE_SIZE_MESSAGE);
	}

	@DisplayName("중복되는 숫자로 생성시 실패 테스트")
	@Test
	void validateNumbers_duplicate() {
		assertThatThrownBy(() -> BaseballNumber.create(Arrays.asList(1, 2, 2)))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(VALIDATE_DUPLICATE_MESSAGE);
	}

	@DisplayName("Player BaseballNumber 객체 정상 생성 테스트 - 문자열 매개변수로 생성")
	@Test
	void initBaseballNumber_string() {
		BaseballNumber.create("123");
	}

	@DisplayName("Player BaseballNumber 객체 생성 테스트 - 문자를 포함한 매개변수")
	@Test
	void validateNonNumber_fail() {
		assertThatThrownBy(() -> BaseballNumber.create("a12"))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(VALIDATE_NUMBER_MESSAGE);
	}

	@DisplayName("Player BaseballNumber 객체 생성 테스트 - 숫자 0을 포함한 매개변수")
	@Test
	void validateZeroNumber_fail() {
		assertThatThrownBy(() -> BaseballNumber.create("022"))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(VALIDATE_NUMBER_MESSAGE);
	}

	@DisplayName("Player BaseballNumber 객체 생성 테스트 - 2자리 숫자 매개변수")
	@Test
	void validateNumber_lessThan_fail() {
		assertThatThrownBy(() -> BaseballNumber.create("12"))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(VALIDATE_SIZE_MESSAGE);
	}

	@DisplayName("Player BaseballNumber 객체 생성 테스트 - 5자리 숫자 매개변수")
	@Test
	void validateNumber_greaterThan_fail() {
		assertThatThrownBy(() -> BaseballNumber.create("123456"))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(VALIDATE_SIZE_MESSAGE);
	}

	@DisplayName("Player BaseballNumber 객체 생성 테스트 - 중복된 숫자 매개변수")
	@Test
	void validateNumber_duplicate_fail() {
		assertThatThrownBy(() -> BaseballNumber.create("222"))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(VALIDATE_DUPLICATE_MESSAGE);
	}
}
