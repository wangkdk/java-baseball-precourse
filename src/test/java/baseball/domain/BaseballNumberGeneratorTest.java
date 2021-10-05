package baseball.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BaseballNumberGeneratorTest {
	private List<Integer> numbers;

	@BeforeEach
	void setup() {
		numbers = BaseballNumberGenerator.generateNonDuplicateNumbers();
	}

	@DisplayName("생성된 숫자 사이즈 체크")
	@Test
	void checkNumbersSize() {
		assertEquals(3, numbers.size());
	}

	@DisplayName("생성된 숫자 중복 체크")
	@Test
	void checkNumbersDuplicate() {
		assertTrue(checkNumbersForNonDuplicate());
	}

	private boolean checkNumbersForNonDuplicate() {
		Set<Integer> nonDuplicateNumbers = new HashSet<>(numbers);
		return nonDuplicateNumbers.size() == 3;
	}
}
