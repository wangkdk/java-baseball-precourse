package baseball.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BaseballNumberValidatorTest {
	private final String VALIDATE_SIZE_MESSAGE = "[ERROR] 야구 게임 숫자는 3개만 가능합니다.";
	private final String VALIDATE_DUPLICATE_MESSAGE = "[ERROR] 야구 게임 숫자는 중복될 수 없습니다.";
	private final String VALIDATE_NUMBER_MESSAGE = "[ERROR] 1 ~ 9 사이의 숫자만 입력 가능합니다.";

	@DisplayName("3자리 숫자 인지 확인")
	@Test
	void validateNumbersSize() {
		BaseballNumberValidator.validateNumbersSize(Arrays.asList(1, 2, 3));
	}

	@DisplayName("3자리 숫자 인지 확인 - 2자리")
	@Test
	void validateNumbersSize_lessThan() {
		assertThatThrownBy(() -> BaseballNumberValidator.validateNumbersSize(Arrays.asList(1, 2)))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(VALIDATE_SIZE_MESSAGE);
	}

	@DisplayName("3자리 숫자 인지 확인 - 5자리")
	@Test
	void validateNumber_greaterThan() {
		assertThatThrownBy(() -> BaseballNumberValidator.validateNumbersSize(Arrays.asList(1, 2, 3, 4, 5)))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(VALIDATE_SIZE_MESSAGE);
	}

	@DisplayName("중복된 숫자가 있는지 확인")
	@Test
	void validateNumbersDuplicate() {
		BaseballNumberValidator.validateNumbersDuplicate(Arrays.asList(1, 2, 3));
	}

	@DisplayName("중복된 숫자가 있는지 확인 - 중복")
	@Test
	void validateNumberDuplicate_fail() {
		assertThatThrownBy(() -> BaseballNumberValidator.validateNumbersDuplicate(Arrays.asList(1, 2, 2)))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(VALIDATE_DUPLICATE_MESSAGE);
	}

	@DisplayName("1~9 사이의 숫자")
	@Test
	void validateOnlyNumberByOneToNine() {
		BaseballNumberValidator.validateOnlyNumberByOneToNine("123");
	}

	@DisplayName("1~9 사이의 숫자 - 숫자가 아닌 값 포함")
	@Test
	void validateOnlyNumberByOneToNine_nonNumber() {
		assertThatThrownBy(() -> BaseballNumberValidator.validateOnlyNumberByOneToNine("12a"))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(VALIDATE_NUMBER_MESSAGE);
	}

	@DisplayName("1~9 사이의 숫자 - 0 포함")
	@Test
	void validateOnlyNumberByOneToNine_zero() {
		assertThatThrownBy(() -> BaseballNumberValidator.validateOnlyNumberByOneToNine("012"))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(VALIDATE_NUMBER_MESSAGE);
	}
}
