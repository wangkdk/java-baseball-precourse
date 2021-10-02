package baseball.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BaseballNumberTest {

	private final String VALIDATE_SIZE_MESSAGE = "야구 게임 숫자는 3개만 가능합니다.";
	private final String VALIDATE_DUPLICATE_MESSAGE = "야구 게임 숫자는 중복될 수 없습니다.";

	@DisplayName("BaseballNumber 객체 정상 생성 테스트")
	@Test
	void initBaseballNumber() {
		new BaseballNumber(Arrays.asList(1, 2, 3));
	}

	@DisplayName("3개 이하의 숫자로 생성시 실패 테스트")
	@Test
	void validateNumber_minSize() {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> new BaseballNumber(Arrays.asList(1, 2)))
			.withMessageMatching(VALIDATE_SIZE_MESSAGE);
	}

	@DisplayName("3개 이상의 숫자로 생성시 실패 테스트")
	@Test
	void validateNumber_overSize() {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> new BaseballNumber(Arrays.asList(1, 2, 3, 4, 5)))
			.withMessageMatching(VALIDATE_SIZE_MESSAGE);
	}

	@DisplayName("중복되는 숫자로 생성시 실패 테스트")
	@Test
	void validateNumbers_duplicate() {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> new BaseballNumber(Arrays.asList(1, 2, 2)))
			.withMessageMatching(VALIDATE_DUPLICATE_MESSAGE);
	}
}
