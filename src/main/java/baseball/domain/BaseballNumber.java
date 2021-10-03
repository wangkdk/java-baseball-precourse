package baseball.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class BaseballNumber {

	private static final int BASEBALL_NUMBERS_SIZE = 3;
	private static final String VALIDATE_SIZE_MESSAGE = "[ERROR] 야구 게임 숫자는 3개만 가능합니다.";
	private static final String VALIDATE_DUPLICATE_MESSAGE = "[ERROR] 야구 게임 숫자는 중복될 수 없습니다.";
	private static final String VALIDATE_NUMBER_MESSAGE = "[ERROR] 1 ~ 9 사이의 숫자만 입력 가능합니다.";
	private static final Pattern BASEBALL_NUMBER_PATTERN = Pattern.compile("^[1-9]*$");

	private final List<Integer> baseballNumbers;

	private BaseballNumber(List<Integer> baseballNumbers) {
		validateNumbersSize(baseballNumbers);
		validateNumbersDuplicate(baseballNumbers);
		this.baseballNumbers = baseballNumbers;
	}

	public static BaseballNumber create(List<Integer> baseballNumbers) {
		return new BaseballNumber(baseballNumbers);
	}

	public static BaseballNumber create(String numbers) {
		validateOnlyNumberByOneToNine(numbers);
		List<Integer> baseballNumbers = convertValueToBaseballNumbers(numbers);
		return new BaseballNumber(baseballNumbers);
	}

	private static void validateOnlyNumberByOneToNine(String numbers) {
		if (!BASEBALL_NUMBER_PATTERN.matcher(numbers).matches()) {
			throw new IllegalArgumentException(VALIDATE_NUMBER_MESSAGE);
		}
	}

	private static List<Integer> convertValueToBaseballNumbers(String numbers) {
		List<Integer> baseballNumbers = new ArrayList<>();
		for (int i = 0; i < numbers.length(); i++) {
			String number = String.valueOf(numbers.charAt(i));
			baseballNumbers.add(Integer.valueOf(number));
		}
		return baseballNumbers;
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
