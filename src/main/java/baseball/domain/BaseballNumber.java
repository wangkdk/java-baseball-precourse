package baseball.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BaseballNumber {

	private static final int BASEBALL_NUMBERS_SIZE = 3;
	private static final String VALIDATE_SIZE_MESSAGE = "야구 게임 숫자는 3개만 가능합니다.";
	private static final String VALIDATE_DUPLICATE_MESSAGE = "야구 게임 숫자는 중복될 수 없습니다.";

	private final List<Integer> baseballNumbers;

	public BaseballNumber(List<Integer> baseballNumbers) {
		validateNumbersSize(baseballNumbers);
		validateNumbersDuplicate(baseballNumbers);
		this.baseballNumbers = baseballNumbers;
	}

	private void validateNumbersSize(List<Integer> baseballNumbers) {
		if (baseballNumbers.size() != BASEBALL_NUMBERS_SIZE) {
			throw new IllegalArgumentException(VALIDATE_SIZE_MESSAGE);
		}
	}

	private void validateNumbersDuplicate(List<Integer> baseballNumbers) {
		Set<Integer> nonDuplicateNumbers = new HashSet<>(baseballNumbers);
		if (nonDuplicateNumbers.size() != BASEBALL_NUMBERS_SIZE) {
			throw new IllegalArgumentException(VALIDATE_DUPLICATE_MESSAGE);
		}
	}
}
